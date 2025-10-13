package com.jdc.tallerhospital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "agendas")
public class AgendasEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcitas")
    private Long idcitas;

    @ManyToOne
    @JoinColumn(name = "idpacientes", nullable = false)
    private PacientesEntity paciente;

    public Long getIdcitas() {
        return idcitas;
    }

    public void setIdcitas(Long idcitas) {
        this.idcitas = idcitas;
    }

    public void setPaciente(PacientesEntity paciente) {
        this.paciente = paciente;
    }

    public PacientesEntity getPaciente() {
        return paciente;
    }

    }
