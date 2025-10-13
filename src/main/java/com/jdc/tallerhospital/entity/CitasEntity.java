package com.jdc.tallerhospital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "citas")
public class CitasEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcita")
    private Long idcita;

    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "nota", length = 50)
    private String nota;

    @Column(name = "fecha_cita", nullable = false)
    private LocalDate fechaCita;

    @Column(name = "sintomas", length = 100)
    private String sintomas;

    @Column(name = "medicamentos", nullable = false, length = 100)
    private String medicamentos;

    @Column(name = "tipocita", nullable = false)
    private String tipocita;

    @Column(name = "antecedentes", length = 100)
    private Boolean antecedentes;

    @ManyToOne
    @JoinColumn(name = "idmedico", nullable = false)
    private MedicosEntity medico;

    @ManyToOne
    @JoinColumn(name = "idpago", nullable = false)
    private PagosEntity pago;

    @ManyToOne
    @JoinColumn(name = "idestatus", nullable = false)
    private EstatusEntity estatus;

    public Long getIdcita() {
        return idcita;
    }

    public void setIdcita(Long idcita) {
        this.idcita = idcita;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getTipocita() {
        return tipocita;
    }

    public void setTipocita(String tipocita) {
        this.tipocita = tipocita;
    }

    public Boolean getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(Boolean antecedentes) {
        this.antecedentes = antecedentes;
    }

    public MedicosEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicosEntity medico) {
        this.medico = medico;
    }

    public PagosEntity getPago() {
        return pago;
    }

    public void setPago(PagosEntity pago) {
        this.pago = pago;
    }

    public EstatusEntity getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusEntity estatus) {
        this.estatus = estatus;
    }
}
