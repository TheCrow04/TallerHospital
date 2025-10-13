package com.jdc.tallerhospital.rest;

import com.jdc.tallerhospital.entity.PagosEntity;
import com.jdc.tallerhospital.entity.UsuariosEntity;
import com.jdc.tallerhospital.service.IPagosService;
import com.jdc.tallerhospital.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/pagos")
public class PagosRest {
    @Autowired
    private IPagosService pagosService;

    @GetMapping("/listar")
    public ResponseEntity<List<PagosEntity>> findAll() {
        return ResponseEntity.ok(pagosService.findAll());
    }

    @GetMapping("/listarby/{id}")
    public ResponseEntity<PagosEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pagosService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<PagosEntity> create(@RequestBody @Validated PagosEntity pagos) {
        try {
            pagosService.save(pagos);
            ResponseEntity.status(200);
            return ResponseEntity.ok(pagos);
        } catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<PagosEntity> edit(
            @PathVariable("id") Long id,
            @RequestBody @Validated PagosEntity pagos) {

        try {
            PagosEntity pagosexistente = pagosService.findById(id);
            pagosexistente.setTipopago(pagos.getTipopago());
            pagosService.save(pagosexistente);
            ResponseEntity.status(200);
            return ResponseEntity.ok(pagos);
        }catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable ("id") Long id) {
        try {
            pagosService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Usuario eliminado correctamente"+ id);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
