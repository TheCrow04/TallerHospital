package com.jdc.tallerhospital.service.implement;

import com.jdc.tallerhospital.entity.PacientesEntity;
import com.jdc.tallerhospital.repository.PacientesRepository;
import com.jdc.tallerhospital.service.IPacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacientesServiceImplement implements IPacientesService {

    @Autowired
    private PacientesRepository pacientesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PacientesEntity> findAll() {
        return pacientesRepository.findAll();
    }

    @Override
    public PacientesEntity findById(Long id) {
        return pacientesRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public PacientesEntity save(PacientesEntity paciente) {
       return pacientesRepository.save(paciente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pacientesRepository.deleteById(id);
    }
}
