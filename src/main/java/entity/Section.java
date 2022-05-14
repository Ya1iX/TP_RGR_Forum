package entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_sections")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
    private Set<Topic> topics;

    public Section() {
    }

    public Section(String name, Set<Topic> topics) {
        this.name = name;
        this.topics = topics;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Section[ID: " + id +
                ", name: " + name +
                ", topics: " + topics.size() +"]";
    }
}
