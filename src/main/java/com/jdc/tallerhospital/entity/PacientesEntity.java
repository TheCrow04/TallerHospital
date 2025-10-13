package com.jdc.tallerhospital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
public class PacientesEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpaciente")
    private Long idpacientes;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "primerapellido", nullable = false)
    private String primerapellido;

    @Column(name = "segundoapellido", nullable = false)
    private String segundoapellido;

    @Column(name = "documento", nullable = false)
    private String documento;

    @Column(name = "fechanacimiento", nullable = false)
    private LocalDate fechanacimiento;

    @Column(name = "medicamentos", nullable = false)
    private String medicamentos;

    @Column(name = "alergias", nullable = false)
    private String alergias;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idusuario", nullable = false)
    private UsuariosEntity usuario;

    public Long getIdpacientes() {
        return idpacientes;
    }

    public void setIdpacientes(Long idpacientes) {
        this.idpacientes = idpacientes;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getprimerapellido() {
        return primerapellido;
    }

    public void setprimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getsegundoapellido() {
        return segundoapellido;
    }

    public void setsegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public UsuariosEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
    }
}
