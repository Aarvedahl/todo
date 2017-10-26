package io.github.aarvedahl;

import javax.persistence.*;
import java.util.List;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteid;

    @Column(name="description", nullable = false, length = 1000)
    private String description;

    @Column(name = "author", length = 70)
    private String author;

    @Column(name = "done")
    private boolean done;


    @ManyToMany
    @JoinTable(
            name = "note_tag",
            joinColumns = {
                    @JoinColumn(
                            name="noteid", // Mellantabell Kolumnen vi vill joina till
                            referencedColumnName = "noteid" // Super Tabellen
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name="tagid",
                            referencedColumnName = "tagid"
                    )
            }
    )
    private List<Tag> tags;

    public int getNoteid() { return noteid;  }
    public void setNoteid(int noteid) { this.noteid = noteid; }
    public String getDescription() {  return description; }
    public void setDescription(String description) { this.description = description; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public boolean isDone() { return done; }
    public void setDone(boolean done) {
        this.done = done;
    }
    public List<Tag> getTags() {
        System.out.println(tags.size());
        return tags; }

    public void setTags(List<Tag> tags) { this.tags = tags; }
}
