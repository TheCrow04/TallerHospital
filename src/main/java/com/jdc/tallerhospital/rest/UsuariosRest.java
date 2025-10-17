package com.jdc.tallerhospital.rest;

import com.jdc.tallerhospital.DTO.UsuariosDTO;
import com.jdc.tallerhospital.entity.UsuariosEntity;
import com.jdc.tallerhospital.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        var e = usuariosService.findById(id);
        return (e == null) ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado")
                : ResponseEntity.ok(e);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody @Validated UsuariosEntity body, UriComponentsBuilder uriBuilder) {
        var saved = usuariosService.save(body);
        URI location = uriBuilder.path("/api/usuarios/{id}").buildAndExpand(saved.getIdusuario()).toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable Integer id, @RequestBody @Validated UsuariosEntity body) {
        var e = usuariosService.findById(id);
        if (e == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        e.setUsername(body.getUsername());
        e.setPassword(body.getPassword());
        e.setEstado(body.getEstado());
        return ResponseEntity.ok(usuariosService.save(e));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        var e = usuariosService.findById(id);
        if (e == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        usuariosService.delete(id);
        return ResponseEntity.noContent().build(); // 204
    }
}
