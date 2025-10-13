package com.jdc.tallerhospital.service;

import com.jdc.tallerhospital.entity.MedicosEntity;

import java.util.List;

public interface IMedicosService {

    public List<MedicosEntity> findAll();
    public MedicosEntity findById(Long id);
    public MedicosEntity save(MedicosEntity medico);
    public void delete(Long id);
}
