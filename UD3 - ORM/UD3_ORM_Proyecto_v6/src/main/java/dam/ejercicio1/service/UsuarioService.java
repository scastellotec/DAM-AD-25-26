package dam.ejercicio1.service;



import dam.ejercicio1.model.Tarea;
import dam.ejercicio1.model.Usuario;
import dam.ejercicio1.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository = new UsuarioRepository();

    public Usuario crearUsuario(String nombre, String email) {
        return usuarioRepository.save(new Usuario(nombre, email));
    }

    public Usuario asignarTarea(Long usuarioId, String titulo) {
        return usuarioRepository.addTarea(usuarioId, new Tarea(titulo));
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void borrarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }


}
