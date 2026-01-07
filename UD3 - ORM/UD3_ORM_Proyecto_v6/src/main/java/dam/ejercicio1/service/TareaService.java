package dam.ejercicio1.service;


import dam.ejercicio1.model.Tarea;
import dam.ejercicio1.repository.TareaRepository;

import java.util.List;

public class TareaService {

    private final TareaRepository tareaRepository = new TareaRepository();

    public List<Tarea> listarTodas() {
        return tareaRepository.findAll();
    }

    public List<Tarea> listarPorUsuario(Long usuarioId) {
        return tareaRepository.findByUsuarioId(usuarioId);
    }

    public void borrarTarea(Long tareaId) {
        tareaRepository.deleteById(tareaId);
    }
}

