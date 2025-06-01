package com.example.enlatadosmg.controller;

import com.example.enlatadosmg.models.Usuario;
import com.example.enlatadosmg.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
        Usuario authenticated = usuarioService.authenticate(usuario.getNombre(), usuario.getContrasena());
        if (authenticated != null) {
            return ResponseEntity.ok(authenticated);
        }
        return ResponseEntity.status(401).build();
    }
}