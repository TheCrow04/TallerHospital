package com.jdc.tallerhospital.service.implement;

import com.jdc.tallerhospital.entity.CitasEntity;
import com.jdc.tallerhospital.repository.CitasRepository;
import com.jdc.tallerhospital.service.ICitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CitasServiceImplement implements ICitasService {

    @Autowired
    private CitasRepository citasRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CitasEntity> findAll() {
        return citasRepository.findAll();
    }

    @Override
    public CitasEntity findById(Long id) {
        return citasRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public CitasEntity save(CitasEntity cita) {
        return citasRepository.save(cita);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        citasRepository.deleteById(id);
    }
}
