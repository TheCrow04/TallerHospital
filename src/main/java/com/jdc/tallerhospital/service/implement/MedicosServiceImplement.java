package com.jdc.tallerhospital.service.implement;

import com.jdc.tallerhospital.entity.MedicosEntity;
import com.jdc.tallerhospital.repository.MedicosRepository;
import com.jdc.tallerhospital.service.IMedicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicosServiceImplement implements IMedicosService {

    @Autowired
    private MedicosRepository medicosRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MedicosEntity> findAll() {
        return medicosRepository.findAll();
    }

    @Override
    public MedicosEntity findById(Long id) {
        return medicosRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public MedicosEntity save(MedicosEntity medico) {
        return medicosRepository.save(medico);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        medicosRepository.deleteById(id);
    }
}
