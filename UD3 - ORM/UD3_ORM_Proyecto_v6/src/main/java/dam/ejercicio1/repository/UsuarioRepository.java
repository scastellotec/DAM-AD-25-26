package dam.ejercicio1.repository;

import dam.ejercicio1.model.Tarea;
import dam.ejercicio1.model.Usuario;
import dam.ejercicio1.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class UsuarioRepository implements BaseRepository<Usuario, Long> {

    @Override
    public Usuario save(Usuario entity) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Usuario managed;
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
    public Optional<Usuario> findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return Optional.ofNullable(em.find(Usuario.class, id));
        } finally {
            em.close();
        }
    }

    @Override
    public List<Usuario> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("select u from Usuario u", Usuario.class).getResultList();
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
            Usuario u = em.find(Usuario.class, id);
            if (u != null) em.remove(u);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Usuario addTarea(Long usuarioId, Tarea tarea) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Usuario u = em.find(Usuario.class, usuarioId); // managed
            if (u == null) {
                throw new IllegalArgumentException("Usuario no existe: " + usuarioId);
            }

            u.addTarea(tarea); // aquí NO hay LazyInitializationException

            tx.commit();
            return u;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
