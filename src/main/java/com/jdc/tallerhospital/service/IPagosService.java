package com.jdc.tallerhospital.service;

import com.jdc.tallerhospital.entity.PagosEntity;

import java.util.List;

public interface IPagosService {

    public List<PagosEntity> findAll();
    public PagosEntity findById(Long id);
    public PagosEntity save(PagosEntity pago);
    public void delete(Long id);
}
