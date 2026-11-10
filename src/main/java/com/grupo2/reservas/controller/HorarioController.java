package com.grupo2.reservas.controller;

import com.grupo2.reservas.entity.Horario;
import com.grupo2.reservas.service.HorarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping
    public List<Horario> listar() {
        return horarioService.obtenerTodos();
    }

    @PostMapping
    public Horario crear(@RequestBody Horario horario) {
        return horarioService.guardar(horario);
    }
}