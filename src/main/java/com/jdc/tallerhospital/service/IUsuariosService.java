package com.jdc.tallerhospital.service;

import com.jdc.tallerhospital.entity.UsuariosEntity;

import java.util.List;

public interface IUsuariosService {
    public List<UsuariosEntity> findAll();
    public UsuariosEntity findById(Integer id);
    public UsuariosEntity save(UsuariosEntity e);
    public void delete(Integer id);

}
