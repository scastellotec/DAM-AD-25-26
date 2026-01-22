
package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.model.Producto;
import org.example.util.JPAUtil;

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
public class main {

    public static void main(String[] args) {

        Long productoId;

        // persist(): transient → managed → commit
        productoId = crearProducto();

        //find() + modificación MANAGED (sin usar merge)
        modificarProductoManaged(1L);

        //detach(): Modificar una entidad DETACHED NO debe persistir
        //merge() Volver a asociar una entidad DETACHED
        probarDetach(productoId);

        //remove() Eliminar la entidad
        eliminarProducto(productoId);

        // Cierre final del EntityManagerFactory
        JPAUtil.shutdown();
    }

    /**
     * Crear un producto y persistirlo
     */
    private static Long crearProducto() {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            // Creo producto nuevo, estado: TRANSIENT
            Producto p = new Producto("Baliza v16", 44.99); // ← sustituir
            System.out.println("Producto creado en estado TRANSIENT");
            System.out.println(p.toString());

            // Persisto el producto, estado: MANAGER
            em.persist(p);

            System.out.println("Producto en estado MANAGED");
            System.out.println(p.toString());

            p.setNombre("Baliza v16.1");

            tx.commit();
            return p.getId();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close(); // al cerrar, la entidad pasa a DETACHED
        }


    }

    /**
     * find() + modificar estando MANAGED
     */
    private static void modificarProductoManaged(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            System.out.println("Buscamos producto con FIND");
            Producto pBuscado = em.find(Producto.class, id);
            System.out.println("Modificamos precio");
            pBuscado.setPrecio(19.99);

            tx.commit();

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
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            System.out.println("Buscamos producto con FIND");
            Producto pBuscado = em.find(Producto.class, id);
            System.out.println("Detach producto");
            em.detach(pBuscado);
            System.out.println("Modificamos precio");
            pBuscado.setPrecio(9.99);

            System.out.println("Merge");
            pBuscado = em.merge(pBuscado);
            System.out.println("Modificamos precio");
            pBuscado.setPrecio(9.99);

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
//        EntityManager em = JPAUtil.getEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        try {
//            tx.begin();
//
//            /*
//             *  - Recuperar el producto con find()
//             *  - Llamar a remove()
//             */
//
//            tx.commit();
//            /*
//             *  - Indicar que el producto debe haberse eliminado
//             */
//
//        } catch (Exception e) {
//            if (tx.isActive()) tx.rollback();
//            throw e;
//        } finally {
//            em.close();
//        }
    }
}
