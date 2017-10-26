package io.github.aarvedahl;


import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class NoteBean implements Serializable{
    private static final long serialVersionUID = 1L;

    @EJB
    private NoteFacade noteFacade;

    private List<Note> notes;

    public List<Note> getNotes() {
        if (notes == null) {
            notes = noteFacade.findAll();
        }
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
