package com.jdc.tallerhospital.rest;

import com.jdc.tallerhospital.entity.MedicosEntity;
import com.jdc.tallerhospital.entity.UsuariosEntity;
import com.jdc.tallerhospital.service.IMedicosService;
import com.jdc.tallerhospital.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/medicos")
public class MedicosRest {
    @Autowired
    private IMedicosService medicosService;

    @GetMapping("/listar")
    public ResponseEntity<List<MedicosEntity>> findAll() {
        return ResponseEntity.ok(medicosService.findAll());
    }

    @GetMapping("/listarby/{id}")
    public ResponseEntity<MedicosEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(medicosService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<MedicosEntity> create(@RequestBody @Validated MedicosEntity medico) {
        try {
            medicosService.save(medico);
            ResponseEntity.status(200);
            return ResponseEntity.ok(medico);
        } catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<MedicosEntity> edit(
            @PathVariable("id") Long id,
            @RequestBody @Validated MedicosEntity medico) {

        try {
            MedicosEntity medicoexistente = medicosService.findById(id);
            medicoexistente.setNombres(medico.getNombres());
            medicoexistente.setPrimerapellido(medico.getPrimerapellido());
            medicoexistente.setSegundoapellido(medico.getSegundoapellido());
            medicoexistente.setGenero(medico.getGenero());
            medicoexistente.setEmail(medico.getEmail());
            medicoexistente.setTelefono(medico.getTelefono());
            medicoexistente.setCategoria(medico.getCategoria());
            medicosService.save(medicoexistente);
            ResponseEntity.status(200);
            return ResponseEntity.ok(medico);
        }catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable ("id") Long id) {
        try {
            medicosService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Usuario eliminado correctamente"+ id);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
