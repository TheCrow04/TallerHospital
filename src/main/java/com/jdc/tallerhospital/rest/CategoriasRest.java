package com.jdc.tallerhospital.rest;

import com.jdc.tallerhospital.entity.CategoriasEntity;
import com.jdc.tallerhospital.entity.UsuariosEntity;
import com.jdc.tallerhospital.service.ICategoriasService;
import com.jdc.tallerhospital.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/categorias")
public class CategoriasRest {
    @Autowired
    private ICategoriasService categoriasService;

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriasEntity>> findAll() {
        return ResponseEntity.ok(categoriasService.findAll());
    }

    @GetMapping("/listarby/{id}")
    public ResponseEntity<CategoriasEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriasService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<CategoriasEntity> create(@RequestBody @Validated CategoriasEntity categoria) {
        try {
            categoriasService.save(categoria);
            ResponseEntity.status(200);
            return ResponseEntity.ok(categoria);
        } catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<CategoriasEntity> edit(
            @PathVariable("id") Long id,
            @RequestBody @Validated CategoriasEntity categoria) {

        try {
            CategoriasEntity categoriaexistente = categoriasService.findById(id);
            categoriaexistente.setNombrecategoria(categoria.getNombrecategoria());
            categoriasService.save(categoriaexistente);
            ResponseEntity.status(200);
            return ResponseEntity.ok(categoria);
        }catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable ("id") Long id) {
        try {
            categoriasService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Usuario eliminado correctamente"+ id);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
