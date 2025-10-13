package com.jdc.tallerhospital.service;

import com.jdc.tallerhospital.entity.AgendasEntity;

import java.util.List;

public interface IAgendasService {

    public List<AgendasEntity> findAll();
    public AgendasEntity findById(Long id);
    public AgendasEntity  save(AgendasEntity agenda);
    public void delete(Long id);
}
