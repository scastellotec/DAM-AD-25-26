package Repository.CSV;

import Model.Producto;
import Repository.ProductoRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVProductoRepository implements ProductoRepository {

    final String nombreArchivo;

    public CSVProductoRepository(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }


    @Override
    public void guardar(Producto producto) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo, true));
        pw.println(producto.getId()+","+producto.getNombre()+","+producto.getPrecio());
        pw.close();
    }

    @Override
    public Producto findByID(int id) {

        return null;
    }

    @Override
    public List<Producto> findAll() throws IOException {

        List<Producto> productosEncontrados = new ArrayList<>();
        Scanner sc = new Scanner(new FileReader(nombreArchivo));

        while(sc.hasNextLine()){
           String[] datos = sc.nextLine().split(",");
           productosEncontrados.add(new Producto(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2])));
        }

        sc.close();
        return productosEncontrados;
    }
}
