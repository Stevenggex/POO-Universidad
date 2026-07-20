package com.example.Examen_JPA.controller;

import com.example.Examen_JPA.model.Colegio;
import com.example.Examen_JPA.repository.ColegioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/colegio")
public class ColegioController {

    @Autowired
    private ColegioRepository colegioRepository;

    @PostMapping
    public ResponseEntity<Colegio> registrar(@Valid @RequestBody Colegio colegio) {
        Colegio nuevoRegistro = colegioRepository.save(colegio);
        return ResponseEntity.ok(nuevoRegistro);
    }

    @GetMapping
    public List<Colegio> listarTodos(){
        return colegioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colegio> buscarPorId(@PathVariable Long id){
        Optional<Colegio> colegio = colegioRepository.findById(id);
        return colegio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colegio> actualizar(@PathVariable Long id, @RequestBody Colegio registroDetalle) {
        return colegioRepository.findById(id).map(registroExistente -> {
            registroExistente.setNombre(registroDetalle.getNombre());
            registroExistente.setCiudad(registroDetalle.getCiudad());
            registroExistente.setRector(registroDetalle.getRector());
            registroExistente.setTelefono(registroDetalle.getTelefono());
            registroExistente.setCorreo(registroDetalle.getCorreo());

            Colegio actualizado = colegioRepository.save(registroExistente);
            return ResponseEntity.ok(actualizado);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        if (colegioRepository.existsById(id)){
            colegioRepository.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado correctamanete");
        }
        return ResponseEntity.notFound().build();
    }



}
