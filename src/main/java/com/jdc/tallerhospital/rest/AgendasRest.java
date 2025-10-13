package com.jdc.tallerhospital.rest;

import com.jdc.tallerhospital.entity.AgendasEntity;
import com.jdc.tallerhospital.entity.UsuariosEntity;
import com.jdc.tallerhospital.service.IAgendasService;
import com.jdc.tallerhospital.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/agendas")
public class AgendasRest {
    @Autowired
    private IAgendasService agendasService;

    @GetMapping("/listar")
    public ResponseEntity<List<AgendasEntity>> findAll() {
        return ResponseEntity.ok(agendasService.findAll());
    }

    @GetMapping("/listarby/{id}")
    public ResponseEntity<AgendasEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(agendasService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<AgendasEntity> create(@RequestBody @Validated AgendasEntity agenda) {
        try {
            agendasService.save(agenda);
            ResponseEntity.status(200);
            return ResponseEntity.ok(agenda);
        } catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<AgendasEntity> edit(
            @PathVariable("id") Long id,
            @RequestBody @Validated AgendasEntity agenda) {

        try {
            AgendasEntity agendaexistente = agendasService.findById(id);
            agendasService.save(agendaexistente);
            ResponseEntity.status(200);
            return ResponseEntity.ok(agenda);
        }catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable ("id") Long id) {
        try {
            agendasService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Usuario eliminado correctamente"+ id);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
