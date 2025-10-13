package com.jdc.tallerhospital.service;

import com.jdc.tallerhospital.entity.UsuariosEntity;

import java.util.List;

public interface IUsuariosService {
    public List<UsuariosEntity> findAll();
    public UsuariosEntity findById(Long id);
    public UsuariosEntity save(UsuariosEntity usuario);
    public void delete(Long id);

}
