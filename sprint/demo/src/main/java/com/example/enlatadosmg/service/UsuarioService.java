package com.example.enlatadosmg.service;

import com.example.enlatadosmg.models.Usuario;
import com.example.enlatadosmg.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario authenticate(String nombre, String contrasena) {
        return usuarioRepository.findByNombreAndContrasena(nombre, contrasena);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Other CRUD operations
}