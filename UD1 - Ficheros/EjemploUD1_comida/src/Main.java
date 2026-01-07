import Repository.CSV.CSVProductoRepository;
import Repository.ProductoRepository;
import Service.ProductoService;
import Vista.Consola;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Main {
    public static void main(String[] args) throws IOException {

        // Declaro el modo que voy a utilizar para guardar la infomracion
        Properties properties= new Properties();
        properties.load(new FileInputStream(new File("persistencia.properties")));
        String modoGuardado = properties.get("modo").toString();
        System.out.println("Se ha elegido el modo de guardado: "+modoGuardado);

        // Declaro el repositorio sin inicializar (hago referencia a la interface)
        ProductoRepository pRepository;

        if(modoGuardado.equals("CSV")){
            pRepository = new CSVProductoRepository("productos.csv");

        } else {
            // TODO: Para implementar cuando sea neceario
            pRepository = new CSVProductoRepository("productos.csv");
        }

        // Declaro el servicio (necesito pasarle el repository inicializado)
        ProductoService pService = new ProductoService(pRepository);

        // Hago por separado la parte de presentacion por si quisieramos hacer una distinta
        // Aunque no la haremos nunca en clase

        new Consola(pService).iniciar();

    }
}