package com.jdc.tallerhospital.rest;

import com.jdc.tallerhospital.entity.UsuariosEntity;
import com.jdc.tallerhospital.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosRest {

    @Autowired
    private IUsuariosService usuariosService;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuariosEntity>> findAll() {
        return ResponseEntity.ok(usuariosService.findAll());
    }

    @GetMapping("/listarby/{id}")
    public ResponseEntity<UsuariosEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(usuariosService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuariosEntity> create(@RequestBody @Validated UsuariosEntity usuario) {
        try {
            usuariosService.save(usuario);
            ResponseEntity.status(200);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<UsuariosEntity> edit(
            @PathVariable("id") Long id,
            @RequestBody @Validated UsuariosEntity usuario) {

        try {
            UsuariosEntity usuarioexistente = usuariosService.findById(id);
            usuarioexistente.setEstado(usuario.getEstado());
            usuarioexistente.setPassword(usuario.getPassword());
            usuarioexistente.setUsername(usuario.getUsername());

            UsuariosEntity actualizado = usuariosService.save(usuarioexistente);
            return ResponseEntity.ok(actualizado);
        }catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable ("id") Long id) {
        try {
            usuariosService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Usuario eliminado correctamente"+ id);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
