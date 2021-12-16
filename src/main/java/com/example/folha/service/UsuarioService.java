package com.example.folha.service;

import com.example.folha.dto.UsuarioDTO;
import com.example.folha.entity.Role;
import com.example.folha.entity.Usuario;
import com.example.folha.repository.UsuariosRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private final UsuariosRepository usuariosRepository;

    public UsuarioService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public void salvarUsuario(UsuarioDTO usuarioDTO) {
        usuarioDTO.setSenha(new BCryptPasswordEncoder().encode(usuarioDTO.getSenha()));
        usuarioDTO.setDataCriacao(LocalDateTime.now().toString());
        usuarioDTO.setRole(Role.ROLE_USER);

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuariosRepository.save(usuario);
    }

    public Usuario mudarRole(Role novaRole, String login) {
        Usuario usuario = Optional
            .ofNullable(usuariosRepository.findByLogin(login))
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
        usuario.setRole(novaRole);
        return usuariosRepository.save(usuario);
    }
}
