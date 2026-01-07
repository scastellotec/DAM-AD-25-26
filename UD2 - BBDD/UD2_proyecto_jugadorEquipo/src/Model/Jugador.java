package Model;

public class Jugador {

    private int id;
    private String nombre;
    private int dorsal;
    private int idEquipo; // Clave foránea hacia equipo

    public Jugador() {
    }

    public Jugador(int id, String nombre, int dorsal, int idEquipo) {
        this.id = id;
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.idEquipo = idEquipo;
    }

    public Jugador(String nombre, int dorsal, int idEquipo) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.idEquipo = idEquipo;
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

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dorsal=" + dorsal +
                ", idEquipo=" + idEquipo +
                '}';
    }
}

