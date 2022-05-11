package entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 30)
    private String username;

    @NotNull
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Message> messages;

    public User() {
    }

    public User(String username, String password, Set<Message> messages) {
        this.username = username;
        this.password = password;
        this.messages = messages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "[ID: " + id +
                ", username: " + username +
                ", messages: " + messages.size() + "]";
    }
}
