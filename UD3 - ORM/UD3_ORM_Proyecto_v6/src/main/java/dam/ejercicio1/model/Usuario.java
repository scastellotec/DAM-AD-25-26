package dam.ejercicio1.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MariaDB: autoincrement
    private Long id;

    private String nombre;

    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarea> tareas = new ArrayList<>();

    public Usuario() {}

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    // Helper para mantener la bidireccionalidad
    public void addTarea(Tarea tarea) {
        tareas.add(tarea);
        tarea.setUsuario(this);
    }

    public void removeTarea(Tarea tarea) {
        tareas.remove(tarea);
        tarea.setUsuario(null);
    }

    // Getters/Setters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Tarea> getTareas() { return tareas; }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre='" + nombre + "', email='" + email + "'}";
    }
}

