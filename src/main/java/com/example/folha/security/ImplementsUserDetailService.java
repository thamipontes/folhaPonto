package com.example.folha.security;

import com.example.folha.entity.Usuario;
import com.example.folha.repository.UsuariosRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ImplementsUserDetailService implements UserDetailsService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = Optional
            .ofNullable(usuariosRepository.findByLogin(login))
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        Set<GrantedAuthority> grantedAuthorities =  new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(usuario.getRole().name()));

        return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());

    }
}
