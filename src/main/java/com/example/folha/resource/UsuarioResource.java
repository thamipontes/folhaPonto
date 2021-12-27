package com.example.folha.resource;

import com.example.folha.dto.UsuarioDTO;
import com.example.folha.entity.Role;
import com.example.folha.entity.Usuario;
import com.example.folha.repository.UsuariosRepository;
import com.example.folha.service.UsuarioService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    private final UsuariosRepository usuariosRepository;

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> salvarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        if (usuariosRepository.findByLogin(usuarioDTO.getLogin()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        usuarioService.salvarUsuario(usuarioDTO);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "login")
    public ResponseEntity<?> login(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        if (principal == null || principal.getName() == null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        Usuario usuario = usuariosRepository.findByLogin(principal.getName());

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping(value = "logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return null;
    }

    @PutMapping(value = "{login}/change/{role}")
    public ResponseEntity<?> changeRole(@PathVariable String login, @PathVariable Role role) {

        Usuario usuario = usuarioService.mudarRole(role, login);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping
    public List<UsuarioDTO> pegarTodosUsuarioClient() {
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        List<Usuario> usuarios = usuariosRepository.findAll();
        usuarios.forEach(usuario -> {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            BeanUtils.copyProperties(usuario, usuarioDTO);
            usuariosDTO.add(usuarioDTO);
        });
        return usuariosDTO;
    }
}
