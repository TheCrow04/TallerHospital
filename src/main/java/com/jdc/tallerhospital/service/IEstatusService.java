package com.jdc.tallerhospital.service;

import com.jdc.tallerhospital.entity.EstatusEntity;

import java.util.List;

public interface IEstatusService {

    public List<EstatusEntity> findAll();
    public EstatusEntity findById(Long id);
    public EstatusEntity save(EstatusEntity estatus);
    public void delete(Long id);
}
