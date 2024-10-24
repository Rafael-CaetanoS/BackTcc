package com.Tcc.back_end.infra.security;

import com.Tcc.back_end.model.Atleta;
import com.Tcc.back_end.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class CustomUserDetailsSerivce implements UserDetailsService {
    @Autowired
    private AtletaRepository atletaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Atleta atleta = this.atletaRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Atleta não encontrado"));
        return new org.springframework.security.core.userdetails.User(atleta.getEmail(), atleta.getSenha(), new ArrayList<>());
    }
}
