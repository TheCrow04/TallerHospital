package com.jdc.tallerhospital.service.implement;

import com.jdc.tallerhospital.entity.EstatusEntity;
import com.jdc.tallerhospital.repository.EstatusRepository;
import com.jdc.tallerhospital.service.IEstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstatusServiceImplement implements IEstatusService {

    @Autowired
    private EstatusRepository estatusRepository;

    @Override
    @Transactional(readOnly = true)
    public List<EstatusEntity> findAll() {
        return estatusRepository.findAll();
    }

    @Override
    public EstatusEntity findById(Long id) {
        return estatusRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public EstatusEntity save(EstatusEntity estatus) {
        return estatusRepository.save(estatus);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        estatusRepository.deleteById(id);
    }
}
