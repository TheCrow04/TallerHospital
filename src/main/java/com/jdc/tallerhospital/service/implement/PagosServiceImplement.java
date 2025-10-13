package com.jdc.tallerhospital.service.implement;

import com.jdc.tallerhospital.entity.PagosEntity;
import com.jdc.tallerhospital.repository.PagosRepository;
import com.jdc.tallerhospital.service.IPagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagosServiceImplement implements IPagosService {

    @Autowired
    private PagosRepository pagosRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PagosEntity> findAll() {
        return pagosRepository.findAll();
    }

    @Override
    public PagosEntity findById(Long id) {
        return pagosRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public PagosEntity save(PagosEntity pago) {
       return pagosRepository.save(pago);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pagosRepository.deleteById(id);
    }
}
