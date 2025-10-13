package com.jdc.tallerhospital.rest;

import com.jdc.tallerhospital.entity.CitasEntity;
import com.jdc.tallerhospital.entity.UsuariosEntity;
import com.jdc.tallerhospital.service.ICitasService;
import com.jdc.tallerhospital.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/citas")
public class CitasRest {
    @Autowired
    private ICitasService citasService;

    @GetMapping("/listar")
    public ResponseEntity<List<CitasEntity>> findAll() {
        return ResponseEntity.ok(citasService.findAll());
    }

    @GetMapping("/listarby/{id}")
    public ResponseEntity<CitasEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(citasService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<CitasEntity> create(@RequestBody @Validated CitasEntity cita) {
        try {
            citasService.save(cita);
            ResponseEntity.status(200);
            return ResponseEntity.ok(cita);
        } catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<CitasEntity> edit(
            @PathVariable("id") Long id,
            @RequestBody @Validated CitasEntity cita) {

        try {
            CitasEntity citaexistente = citasService.findById(id);
            citaexistente.setTitulo(cita.getTitulo());
            citaexistente.setNota(cita.getNota());
            citaexistente.setFechaCita(cita.getFechaCita());
            citaexistente.setSintomas(cita.getSintomas());
            citaexistente.setMedicamentos(cita.getMedicamentos());
            citaexistente.setTipocita(cita.getTipocita());
            citaexistente.setAntecedentes(cita.getAntecedentes());
            citasService.save(citaexistente);
            ResponseEntity.status(200);
            return ResponseEntity.ok(cita);
        }catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable ("id") Long id) {
        try {
            citasService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Usuario eliminado correctamente"+ id);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
