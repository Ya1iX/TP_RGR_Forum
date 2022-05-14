-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Май 14 2022 г., 20:03
-- Версия сервера: 8.0.24
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `tp_forum`
--
CREATE DATABASE IF NOT EXISTS `tp_forum` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `tp_forum`;

-- --------------------------------------------------------

--
-- Структура таблицы `t_messages`
--

CREATE TABLE `t_messages` (
  `id` bigint NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `text` varchar(1500) NOT NULL,
  `topic_id` bigint NOT NULL,
  `author_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `t_messages`
--

INSERT INTO `t_messages` (`id`, `date`, `text`, `topic_id`, `author_id`) VALUES
(1, '2022-05-11 22:21:43.110000', 'В этом топике мы обсудим некоторые возможности Java.', 1, 1),
(2, '2022-05-11 22:25:49.688000', 'Java — строго типизированный объектно-ориентированный язык программирования общего назначения, разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).', 1, 1),
(3, '2022-05-11 22:27:07.027000', 'Разработка ведётся сообществом, организованным через Java Community Process; язык и основные реализующие его технологии распространяются по лицензии GPL. Права на торговую марку принадлежат корпорации Oracle.', 1, 1),
(4, '2022-05-11 22:27:07.044000', 'Приложения Java обычно транслируются в специальный байт-код, поэтому они могут работать на любой компьютерной архитектуре, для которой существует реализация виртуальной Java-машины.', 1, 1),
(5, '2022-05-11 22:27:07.045000', 'Дата официального выпуска — 23 мая 1995 года. Занимает высокие места в рейтингах популярности языков программирования.', 1, 1),
(6, '2022-05-11 22:42:56.990000', 'Изначально язык назывался Oak («Дуб»), разрабатывался Джеймсом Гослингом для программирования бытовых электронных устройств.', 1, 2),
(7, '2022-05-11 22:42:57.005000', 'Из-за того, что язык с таким названием уже существовал, Oak был переименован в Java.', 1, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `t_sections`
--

CREATE TABLE `t_sections` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `t_sections`
--

INSERT INTO `t_sections` (`id`, `name`) VALUES
(1, 'IT');

-- --------------------------------------------------------

--
-- Структура таблицы `t_topics`
--

CREATE TABLE `t_topics` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` int NOT NULL,
  `section_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `t_topics`
--

INSERT INTO `t_topics` (`id`, `name`, `rating`, `section_id`) VALUES
(1, 'Немного о Java', 2, 1),
(2, 'Немного о Python', 0, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `t_users`
--

CREATE TABLE `t_users` (
  `id` bigint NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) NOT NULL,
  `authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mail` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `t_users`
--

INSERT INTO `t_users` (`id`, `password`, `username`, `authority`, `mail`) VALUES
(1, '$2a$10$I0BOCCDqRH6905RIlUmgd.2L008fmT3QvFtjEynyJQ2WoKDFRNGo6', 'user', 'ROLE_USER', 'user@forum.loc'),
(2, '$2a$08$dbEukibuSZQoGbDmnP8yd.GQTVMAmIXLTVf1yvqmmTtOZQr9SQc1C', 'Farmer', 'ROLE_USER', 'farmer@forum.loc'),
(3, '$2a$10$jrryFNptnoGWwyWhxc47eeeHpin/LPOut7J221Xv4DB3qTswVcvJS', 'admin', 'ROLE_ADMIN', 'admin@forum.loc');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `t_messages`
--
ALTER TABLE `t_messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9ufkia34wg9luefn4hy0clw5l` (`topic_id`),
  ADD KEY `FK82ota1gx7vu5mheof5394thyw` (`author_id`);

--
-- Индексы таблицы `t_sections`
--
ALTER TABLE `t_sections`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `t_topics`
--
ALTER TABLE `t_topics`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkmllry9ahn65bj0jrsdqll2f9` (`section_id`);

--
-- Индексы таблицы `t_users`
--
ALTER TABLE `t_users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_sp0e01od15gf4nu5ffu87qb9n` (`username`),
  ADD UNIQUE KEY `UKsp0e01od15gf4nu5ffu87qb9n` (`username`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `t_messages`
--
ALTER TABLE `t_messages`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT для таблицы `t_sections`
--
ALTER TABLE `t_sections`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `t_topics`
--
ALTER TABLE `t_topics`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `t_users`
--
ALTER TABLE `t_users`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `t_messages`
--
ALTER TABLE `t_messages`
  ADD CONSTRAINT `FK82ota1gx7vu5mheof5394thyw` FOREIGN KEY (`author_id`) REFERENCES `t_users` (`id`),
  ADD CONSTRAINT `FK9ufkia34wg9luefn4hy0clw5l` FOREIGN KEY (`topic_id`) REFERENCES `t_topics` (`id`);

--
-- Ограничения внешнего ключа таблицы `t_topics`
--
ALTER TABLE `t_topics`
  ADD CONSTRAINT `FKkmllry9ahn65bj0jrsdqll2f9` FOREIGN KEY (`section_id`) REFERENCES `t_sections` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
