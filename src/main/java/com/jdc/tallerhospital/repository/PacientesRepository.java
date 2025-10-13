package com.jdc.tallerhospital.repository;

import com.jdc.tallerhospital.entity.PacientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientesRepository extends JpaRepository<PacientesEntity, Long> {
}
