package Model;

public class Jugador {

    private int id;
    private String nombre;
    private int dorsal;

    public Jugador() {
    }

    public Jugador(int id, String nombre, int dorsal) {
        this.id = id;
        this.nombre = nombre;
        this.dorsal = dorsal;
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

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dorsal=" + dorsal +
                '}';
    }
}
