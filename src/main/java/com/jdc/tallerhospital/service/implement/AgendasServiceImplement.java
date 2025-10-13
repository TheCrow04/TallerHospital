package com.jdc.tallerhospital.service.implement;

import com.jdc.tallerhospital.entity.AgendasEntity;
import com.jdc.tallerhospital.repository.AgendasRepository;
import com.jdc.tallerhospital.service.IAgendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgendasServiceImplement implements IAgendasService {

    @Autowired
    AgendasRepository agendasRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AgendasEntity> findAll() {
        return agendasRepository.findAll();
    }

    @Override
    public AgendasEntity findById(Long id) {
        return agendasRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public AgendasEntity save(AgendasEntity agenda) {
        return agendasRepository.save(agenda);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        agendasRepository.deleteById(id);
    }
}
