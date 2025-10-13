package com.jdc.tallerhospital.service;

import com.jdc.tallerhospital.entity.CategoriasEntity;

import java.util.List;

public interface ICategoriasService {

    public List<CategoriasEntity> findAll();
    public CategoriasEntity findById(Long id);
    public CategoriasEntity  save(CategoriasEntity categoria);
    public void delete(Long id);
}
