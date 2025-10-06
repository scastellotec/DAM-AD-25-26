package Service;

import Model.Producto;
import Repository.ProductoRepository;

import java.io.IOException;
import java.util.List;

public class ProductoService {

    ProductoRepository productoRepository;
    // Categoria Repository

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public void crearNuevo(Producto producto) throws IOException {
        System.out.println("Creando producto");
        productoRepository.guardar(producto);
    }

    public List<Producto> mostrarTodos() throws IOException {
        System.out.println("Mostrando todos los productos");
        return productoRepository.findAll();
    }

}
