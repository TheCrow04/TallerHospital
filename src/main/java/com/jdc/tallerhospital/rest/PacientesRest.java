package com.jdc.tallerhospital.rest;

import com.jdc.tallerhospital.entity.PacientesEntity;
import com.jdc.tallerhospital.entity.UsuariosEntity;
import com.jdc.tallerhospital.service.IPacientesService;
import com.jdc.tallerhospital.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/pacientes")
public class PacientesRest {
    @Autowired
    private IPacientesService pacientesService;

    @GetMapping("/listar")
    public ResponseEntity<List<PacientesEntity>> findAll() {
        return ResponseEntity.ok(pacientesService.findAll());
    }

    @GetMapping("/listarby/{id}")
    public ResponseEntity<PacientesEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pacientesService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<PacientesEntity> create(@RequestBody @Validated PacientesEntity paciente) {
        try {
            pacientesService.save(paciente);
            ResponseEntity.status(200);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<PacientesEntity> edit(
            @PathVariable("id") Long id,
            @RequestBody @Validated PacientesEntity paciente) {

        try {
            PacientesEntity pacienteexistente = pacientesService.findById(id);
            pacienteexistente.setNombres(paciente.getNombres());
            pacienteexistente.setprimerapellido(paciente.getprimerapellido());
            pacienteexistente.setsegundoapellido(paciente.getsegundoapellido());
            pacienteexistente.setDocumento(paciente.getDocumento());
            pacienteexistente.setFechanacimiento(paciente.getFechanacimiento());
            pacienteexistente.setMedicamentos(paciente.getMedicamentos());
            pacienteexistente.setAlergias(paciente.getAlergias());
            pacientesService.save(pacienteexistente);
            ResponseEntity.status(200);
            return ResponseEntity.ok(paciente);
        }catch (Exception e) {
            System.out.println("El error es:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable ("id") Long id) {
        try {
            pacientesService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Usuario eliminado correctamente"+ id);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
