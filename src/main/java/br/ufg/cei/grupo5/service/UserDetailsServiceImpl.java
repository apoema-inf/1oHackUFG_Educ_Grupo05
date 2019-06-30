/**
 * Copyright (C) 2018 Codex Med Ltda.
 *
 *
 * Proprietary code protected by intellectual property laws.
 */
package br.ufg.cei.grupo5.service;

import br.ufg.cei.grupo5.model.Usuario;
import br.ufg.cei.grupo5.repository.UsuarioRepository;
import br.ufg.cei.grupo5.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Iago Bruno
 * @since 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Usuario usuario = usuarioRepository.findByUsuario(username);

    if (usuario == null) {
      throw new UsernameNotFoundException(username);
    }

    return new CustomUserDetails(usuario);

  }

}
