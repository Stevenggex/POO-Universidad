package com.example.Practica1.controller;

import com.example.Practica1.model.Estudiante;
import com.example.Practica1.repository.EstudianteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteRestController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    //Registrar estudiantes
    @PostMapping
    public ResponseEntity<Estudiante> registrarEstudiante(@Valid @RequestBody Estudiante estudiante){
        Estudiante nuevoEstudiante = estudianteRepository.save(estudiante);
        return ResponseEntity.ok(nuevoEstudiante);
    }

    //Consultar todos los registros
    @GetMapping
    public List<Estudiante> obtener(){
        return estudianteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable Long id){
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarPorId(@PathVariable Long id, @Valid @RequestBody Estudiante detallesEstudiante){
        return estudianteRepository.findById(id).map(estudianteExistente -> {
            estudianteExistente.setNombre(detallesEstudiante.getNombre());
            estudianteExistente.setApellido(detallesEstudiante.getApellido());
            estudianteExistente.setCarrera(detallesEstudiante.getCarrera());
            estudianteExistente.setEdad(detallesEstudiante.getEdad());

            Estudiante actualizado = estudianteRepository.save(estudianteExistente);
            return ResponseEntity.ok(actualizado);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRegistroPorId(@PathVariable Long id){
        if (estudianteRepository.existsById(id)){
            estudianteRepository.deleteById(id);
            return ResponseEntity.ok("Estudiante eliminado correctamente.");
        }
        return ResponseEntity.notFound().build();
    }
}
