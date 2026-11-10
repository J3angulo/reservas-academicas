package com.grupo2.reservas.repository;

import com.grupo2.reservas.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    
}