package com.example.folha.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

import com.example.folha.entity.Role;
import com.example.folha.entity.Usuario;
import com.example.folha.repository.UsuariosRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UsuarioService.class)
class TestUsuarioService {

    @MockBean
    private UsuariosRepository usuariosRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Test
    void testMudarRole() {
        String login = "teste";
        Mockito.when(usuariosRepository.findByLogin(anyString())).thenReturn(null);

        Exception exception = assertThrows(
                UsernameNotFoundException.class,
                () -> {
                    usuarioService.mudarRole(Role.ROLE_ADMIN, login);
                }
        );

        String expectedMessage = "Usuário não encontrado!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testMudarRoleReturnUsuario() {
        String login = "login";

        Usuario usuario = new Usuario();
        usuario.setNomeCompleto("Teste");
        usuario.setRole(Role.ROLE_USER);
        usuario.setSenha("password");
        usuario.setLogin("login");
        usuario.setEmail("teste@teste.com");

        Mockito.when(usuariosRepository.findByLogin(anyString())).thenReturn(usuario);

         Usuario usuario1 = usuarioService.mudarRole(Role.ROLE_ADMIN, login);

        assertEquals(login, usuario1.getLogin());
        assertEquals("password", usuario1.getPassword());
        assertEquals("teste@teste.com", usuario1.getEmail());
    }


}
