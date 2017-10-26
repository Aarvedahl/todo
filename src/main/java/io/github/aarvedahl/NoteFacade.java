package io.github.aarvedahl;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class NoteFacade {
    @PersistenceContext(unitName = "note")
    private EntityManager em;

    public List<Note> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Note> cq =  cb.createQuery(Note.class);
        // Select * from ...
        cq.select(cq.from(Note.class));
        return em.createQuery(cq).getResultList();
    }
  /*
    public List<Note> findHalf() {
        return em.createQuery("SELECT * FROM Note n", Note.class).getResultList();
    }
     */

}
