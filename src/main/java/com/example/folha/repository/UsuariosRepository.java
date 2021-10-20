package com.example.folha.repository;

import com.example.folha.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario, String> {
    Usuario findByLogin(String login);
}
