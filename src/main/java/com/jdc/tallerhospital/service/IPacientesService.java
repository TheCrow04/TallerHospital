package com.jdc.tallerhospital.service;

import com.jdc.tallerhospital.entity.PacientesEntity;

import java.util.List;

public interface IPacientesService {

    public List<PacientesEntity> findAll();
    public PacientesEntity findById(Long id);
    public PacientesEntity save(PacientesEntity paciente);
    public void delete(Long id);
}
