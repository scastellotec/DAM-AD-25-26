package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name="tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String asunto;

    private String observaciones;

    private int prioridad;

    public Tarea() {
    }

    public Tarea(String asunto, String observaciones, int prioridad) {
        this.asunto = asunto;
        this.observaciones = observaciones;
        this.prioridad = prioridad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", asunto='" + asunto + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", prioridad=" + prioridad +
                '}';
    }
}
