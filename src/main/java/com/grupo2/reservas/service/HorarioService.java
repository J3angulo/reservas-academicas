package com.grupo2.reservas.service;

import com.grupo2.reservas.entity.Horario;
import com.grupo2.reservas.repository.HorarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;

    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public List<Horario> obtenerTodos() {
        return horarioRepository.findAll();
    }

    public Horario guardar(Horario horario) {
        return horarioRepository.save(horario);
    }
}