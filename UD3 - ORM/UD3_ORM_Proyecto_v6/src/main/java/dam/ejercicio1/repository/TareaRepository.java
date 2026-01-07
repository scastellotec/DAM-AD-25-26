package dam.ejercicio1.repository;



import dam.ejercicio1.model.Tarea;
import dam.ejercicio1.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class TareaRepository implements BaseRepository<Tarea, Long> {

    @Override
    public Tarea save(Tarea entity) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Tarea managed;
            if (entity.getId() == null) {
                em.persist(entity);
                managed = entity;
            } else {
                managed = em.merge(entity);
            }
            tx.commit();
            return managed;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<Tarea> findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return Optional.ofNullable(em.find(Tarea.class, id));
        } finally {
            em.close();
        }
    }

    @Override
    public List<Tarea> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("select t from Tarea t", Tarea.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Tarea> findByUsuarioId(Long usuarioId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                            "select t from Tarea t where t.usuario.id = :id", Tarea.class)
                    .setParameter("id", usuarioId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Tarea t = em.find(Tarea.class, id);
            if (t != null) em.remove(t);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}

