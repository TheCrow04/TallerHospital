package com.jdc.tallerhospital.service.implement;

import com.jdc.tallerhospital.entity.CategoriasEntity;
import com.jdc.tallerhospital.repository.CategoriasRepository;
import com.jdc.tallerhospital.service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriasServiceImplement implements ICategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CategoriasEntity> findAll() {
        return categoriasRepository.findAll();
    }

    @Override
    public CategoriasEntity findById(Long id) {
        return categoriasRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public CategoriasEntity save(CategoriasEntity categoria) {
       return categoriasRepository.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        categoriasRepository.deleteById(id);
    }
}
