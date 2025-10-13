package com.jdc.tallerhospital.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "estatus")
public class EstatusEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestatus")
    private Long idestatus;

    @Column(name = "nombreestatus", nullable = false, length = 200)
    private String nombreestatus;

    public Long getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(Long idestatus) {
        this.idestatus = idestatus;
    }

    public String getNombreestatus() {
        return nombreestatus;
    }

    public void setNombreestatus(String nombreestatus) {
        this.nombreestatus = nombreestatus;
    }
}
