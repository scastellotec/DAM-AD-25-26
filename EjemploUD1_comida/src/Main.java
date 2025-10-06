import Repository.CSV.CSVProductoRepository;
import Repository.ProductoRepository;
import Service.ProductoService;
import Vista.Consola;


public class Main {
    public static void main(String[] args) {

        // Declaro el modo que voy a utilizar para guardar la infomracion
        final String modoGuardado = "CSV";

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