package org;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.model.Tarea;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm-clase");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Tarea t1 = new Tarea("Fregar los platos");
        Tarea t2 = new Tarea("Pasear al perro");
        Tarea t3 = new Tarea("Estudiar Acceso a datos");

        System.out.println("Guardo las 3 tareas");
        entityManager.persist(t1);
        entityManager.persist(t2);
        entityManager.persist(t3);

        System.out.println("Modifico una");
        t1.setTitulo("Bajar la basura");

        System.out.println("Tarea 1: "+t1);
        System.out.println("Tarea 2: "+t2);
        System.out.println("Tarea 3: "+t3);

        transaction.commit();
        entityManager.close();

        // Me vuelvo a conectar
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();

        System.out.println("Modifico otra");
        t2.setTitulo("Pasear al gato");

        entityManager.merge(t2);

        t3 = entityManager.merge(t3);
        entityManager.remove(t3);

        transaction.commit();
        entityManager.close();

    }
}