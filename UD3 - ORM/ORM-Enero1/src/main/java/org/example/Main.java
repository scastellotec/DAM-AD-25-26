package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.Model.Direccion;
import org.example.Model.Login;
import org.example.Model.Usuario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Inicio el entity Manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm-clase");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tran = em.getTransaction();
        tran.begin();

        // Creo la instancia
        Usuario sergio = new Usuario("Sergio");
        Login login = new Login("scastellotec");
        Direccion direccion = new Direccion("Batalla de Lepanto",30);
        sergio.setLogin(login);
        //sergio.setDireccion(direccion);

        // Guardo la entidad nueva
        em.persist(sergio);
        //em.persist(login);

        em.remove(sergio);

        // Finalizo
        tran.commit();
        em.close();

    }
}