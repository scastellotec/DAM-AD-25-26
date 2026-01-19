package org.example.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "perfiles")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)private long id;

    private String bio;
    private String telefono;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn( name = "usuario_id")
    private Usuario usuario;

    public Perfil(String bio, String telefono) {
        this.bio = bio;
        this.telefono = telefono;
    }

    public Perfil() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
