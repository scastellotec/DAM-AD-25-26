package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.Model.Perfil;
import org.example.Model.Usuario;
import org.example.Util.JPAUtil;

/**
 * Ejercicio 2
 */
public class Main {

    public static void main(String[] args) {

        Long usuarioId = crearUsuarioConPerfil();

       /* leerUsuarioYAccederAlPerfil(usuarioId);

        probarAccesoConEntityManagerCerrado(usuarioId);

        borrarUsuarioYComprobarCascade(usuarioId);*/

        JPAUtil.shutdown();
    }

    /**
     * PASO A: Crear Usuario + Perfil y persistir SOLO el usuario.
     * - Si cascade incluye PERSIST, el perfil se persistirá automáticamente.
     */
    private static Long crearUsuarioConPerfil() {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Usuario u = new Usuario("Ana");
            Perfil p = new Perfil("Bio de Ana", "600123123");

            /*
             * TODO 1:
             *  - Asocia el perfil al usuario (lado dueño)
             *    u.setPerfil(p);
             */
            p.setUsuario(u);

            /*
             * TODO 2 (solo si implementas bidireccionalidad):
             *  - Mantén consistencia en memoria:
             *    p.setUsuario(u);
             */

            /*
             * TODO 3:
             *  - Persiste SOLO el usuario
             *    em.persist(u);
             */
            em.persist(p);

            tx.commit();

            System.out.println("[A] Usuario creado con id=" + u.getId());
            return u.getId();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * PASO B: Borrar usuario y comprobar el efecto del cascade.
     * - Con cascade=PERSIST: se borra usuario, pero el perfil normalmente queda en la tabla perfiles.
     * - Con cascade=ALL o REMOVE: se borra usuario y su perfil.
     */
   /* private static void borrarUsuarioYComprobarCascade(Long usuarioId) {

        Long perfilId = null;

        // 1) Leer perfilId antes de borrar (para comprobar después)
        EntityManager emRead = JPAUtil.getEntityManager();
        try {
            Perfil u0 = emRead.find(Perfil.class, usuarioId);
*/
            /*
             * TODO 8:
             *  - Elimina el usuario con em.remove(u)
             */
/*
            tx.commit();
            System.out.println("\n[D] Usuario eliminado (commit OK).");

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }*/

    /**
     * PASO C: Leer Usuario y acceder al Perfil.
     * - Con EAGER normalmente se carga inmediatamente.
     * - Con LAZY se carga al acceder (si EM sigue abierto).
     */
   /* private static void leerUsuarioYAccederAlPerfil(Long usuarioId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Perfil u = em.find(Perfil.class, usuarioId);
            System.out.println("\n[B] Usuario leído: " + u);
*/
            /*
             * TODO 4:
             *  - Accede al perfil y muéstralo por consola
             *    System.out.println("[B] Perfil: " + u.getPerfil());
             */
/*
        } finally {
            em.close();
        }
    }*/

    /**
     * PASO D: Probar acceso a la relación con el EntityManager cerrado.
     * - Si fetch=LAZY, es posible que salte una excepción al hacer u.getPerfil()
     *   fuera de sesión.
     */
/*    private static void probarAccesoConEntityManagerCerrado(Long usuarioId) {

        Perfil u;

        EntityManager em = JPAUtil.getEntityManager();
        try {
            u = em.find(Perfil.class, usuarioId);
            System.out.println("\n[C] Usuario cargado (aún con EM abierto): " + u);
*/
            /*
             * TODO 5 (opcional):
             *  - Si quieres evitar la excepción en LAZY, fuerza la carga aquí:
             *    u.getPerfil();
             *  - Pero para “provocarla”, NO llames a getPerfil aquí.
             */
/*
        } finally {
            em.close();
        }

        System.out.println("[C] EntityManager cerrado. Intentando acceder al perfil...");

        try {*/
            /*
             * TODO 6:
             *  - Accede al perfil con EM cerrado:
             *    System.out.println(u.getPerfil());
             */
 /*       } catch (Exception ex) {
            System.out.println("[C] Excepción al acceder al perfil con EM cerrado:");
            System.out.println("    " + ex.getClass().getName() + " -> " + ex.getMessage());
        }
    }*/
}
