package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.model.Tarea;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Declaro el objeto que deseo guardar
       /* Tarea t1 = new Tarea("Lavar los platos", "No usar lavavajillas",1);
        Tarea t2 = new Tarea("Comprar patatas", "Bolsa de 5 KG.",5);

        em.persist(t1);
        em.persist(t2);*/

        Tarea t3 = em.find(Tarea.class, 2L);
        t3.setAsunto("Pasear al perro");

        transaction.commit();
        em.close();

    }
}