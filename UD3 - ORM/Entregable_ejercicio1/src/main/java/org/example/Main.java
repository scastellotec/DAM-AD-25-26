package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.Model.Producto;
import org.example.Util.JPAUtil;
/**
 * Ejercicio 1 – Ciclo de vida de una entidad
 *
 * En este main se deben probar, en orden:
 *  - persist()
 *  - find()
 *  - modificación de entidad MANAGED
 *  - detach()
 *  - merge()
 *  - remove()
 *
 * Sigue los pasos y completa SOLO donde se indica.
 */
public class Main {

    public static void main(String[] args) {

        Long productoId;

        // persist(): transient → managed → commit
        productoId = crearProducto();
/*
        //find() + modificación MANAGED  (sin usar merge)
        modificarProductoManaged(productoId);

        //detach(): Modificar una entidad DETACHED NO debe persistir
        //merge() Volver a asociar una entidad DETACHED
        probarDetach(productoId);

        //remove() Eliminar la entidad
        eliminarProducto(productoId);
*/
        // Cierre final del EntityManagerFactory
        JPAUtil.shutdown();
    }

    /**
     * Crear un producto y persistirlo
     */
    private static Long crearProducto() {
        // Recuperamos de JPAUtil una instancia del entityManager
        EntityManager em = JPAUtil.getEntityManager();

        // Instanciamos una transacción
        EntityTransaction et = em.getTransaction();

        try {
            // Iniciamos una transacción
            et.begin();
            System.out.println("#1. Crear un prodcuto");

            // Creo un nuevo objeto
            Producto p = new Producto("Gel hidroalcoholico", 1.5); // ← sustituir
            System.out.println("Producto en estado TRANSIENT");

            // Guardo la instancia de producto
            em.persist(p);
            System.out.println("Producto MANAGED y listo para guardar");

            // Hacemos un commit()
            et.commit();

            // Muestro y devuelvo el ID asignado a esta entidad
            System.out.println("Producto creado con ID: "+ p.getId());
            return p.getId(); // ← sustituir

        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            throw e;
        } finally {
            em.close(); // al cerrar, la entidad pasa a DETACHED
        }
    }

    /**
     * find() + modificar estando MANAGED
     */
    private static void modificarProductoManaged(Long id) {
        // Inicializamos entityManager y la transacción

        try {
            /*
             * TODO 4:
             *  - Recuperar el producto usando find()
             *  - Mostrarlo por consola
             */

            /*
             * TODO 5:
             *  - Modificar el precio
             *  - NO usar merge()
             */

            tx.commit();
            /*
             * TODO 6:
             *  - Indicar por consola que el cambio debe haberse guardado
             */

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * detach()
     */
    private static void probarDetach(Long id) {
        // Inicializamos entityManager y la transacción

        try {

            /*
             *  - Recuperar el producto con find()
             *  - Llamar a detach()
             */

            /*
             *  - Modificar el precio estando DETACHED
             *  - Mostrar por consola el nuevo valor
             */

            tx.commit();
            /*
             *  - Indicar que NO debería haberse guardado en BBDD
             */

            /*
             *  - Llamar a merge()
             *  - Guardar la referencia devuelta (entidad MANAGED)
             */

            tx.commit();
            /*
             * TODO 13:
             *  - Indicar que el cambio ahora SÍ debe persistirse
             */

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * remove()
     */
    private static void eliminarProducto(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            /*
             *  - Recuperar el producto con find()
             *  - Llamar a remove()
             */

            tx.commit();
            /*
             *  - Indicar que el producto debe haberse eliminado
             */

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

}

