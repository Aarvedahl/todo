package io.github.aarvedahl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Tag implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagid;

    @Column(name="tagname")
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Note> notes;

    public int getTagid() { return tagid; }
    public void setTagid(int tagid) { this.tagid = tagid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Note> getNotes() { return notes; }
    public void setNotes(List<Note> notes) { this.notes = notes; }
}
