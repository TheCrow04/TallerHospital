package com.jdc.tallerhospital.rest;

import com.jdc.tallerhospital.entity.EstatusEntity;
import com.jdc.tallerhospital.service.IEstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/estatus")
public class EstatusRest {
    @Autowired
    private IEstatusService estatusService;

    @GetMapping("/listar")
    public ResponseEntity<List<EstatusEntity>> findAll() {
        return ResponseEntity.ok(estatusService.findAll());
    }

    @GetMapping("/listarby/{id}")
    public ResponseEntity<EstatusEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(estatusService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<EstatusEntity> create(@RequestBody @Validated EstatusEntity estatus) {
        try {
            estatusService.save(estatus);
            ResponseEntity.status(200);
            return ResponseEntity.ok(estatus);
        } catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<EstatusEntity> edit(
            @PathVariable("id") Long id,
            @RequestBody @Validated EstatusEntity estatus) {

        try {
            EstatusEntity estatusexistente = estatusService.findById(id);
            estatusexistente.setNombreestatus(estatus.getNombreestatus());
            estatusService.save(estatusexistente);
            ResponseEntity.status(200);
            return ResponseEntity.ok(estatus);
        }catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable ("id") Long id) {
        try {
            estatusService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Usuario eliminado correctamente"+ id);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
