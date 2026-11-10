package com.grupo2.reservas.service;

import com.grupo2.reservas.entity.Usuario;
import com.grupo2.reservas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Inyección por constructor
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        // Aquí puedes agregar reglas de negocio si tu profe las pide
        return usuarioRepository.save(usuario);
    }
}