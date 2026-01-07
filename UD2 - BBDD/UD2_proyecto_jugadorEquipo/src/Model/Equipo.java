package Model;

public class Equipo {

    private int id;
    private String nombre;
    private String estadio;
    private int seguidores;

    public Equipo() {
    }

    public Equipo(int id, String nombre, String estadio, int seguidores) {
        this.id = id;
        this.nombre = nombre;
        this.estadio = estadio;
        this.seguidores = seguidores;
    }

    public Equipo(String nombre, String estadio, int seguidores) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.seguidores = seguidores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estadio='" + estadio + '\'' +
                ", seguidores=" + seguidores +
                '}';
    }
}

