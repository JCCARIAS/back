
package com.example.enlatadosmg.repositories;

import com.example.enlatadosmg.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNombreAndContrasena(String nombre, String contrasena);
}