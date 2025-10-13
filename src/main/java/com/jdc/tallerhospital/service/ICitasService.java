package com.jdc.tallerhospital.service;

import com.jdc.tallerhospital.entity.CitasEntity;

import java.util.List;

public interface ICitasService {

    public List<CitasEntity> findAll();
    public CitasEntity findById(Long id);
    public CitasEntity save(CitasEntity cita);
    public void delete(Long id);
}
