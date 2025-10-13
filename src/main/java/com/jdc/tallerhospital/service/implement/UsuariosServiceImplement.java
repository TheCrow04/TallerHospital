package com.jdc.tallerhospital.service.implement;

import com.jdc.tallerhospital.entity.UsuariosEntity;
import com.jdc.tallerhospital.repository.UsuariosRepository;
import com.jdc.tallerhospital.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuariosServiceImplement implements IUsuariosService {
@Autowired
private UsuariosRepository usuariosRepository;

@Override
@Transactional(readOnly = true)
public List<UsuariosEntity> findAll() {
    return usuariosRepository.findAll();
}

    @Override
    public UsuariosEntity findById(Long id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public UsuariosEntity save(UsuariosEntity usuario) {
        return usuariosRepository.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuariosRepository.deleteById(id);
    }

}
