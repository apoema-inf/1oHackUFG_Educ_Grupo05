package br.ufg.cei.grupo5.security;

import br.ufg.cei.grupo5.model.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Iago Bruno
 * @since 1.0
 */
public class CustomUserDetails implements UserDetails {

  private Usuario usuario;


  private Collection<GrantedAuthority> permissoes = new ArrayList<>();

  public CustomUserDetails(Usuario usuario) {
    this.usuario = usuario;
    if (usuario != null) {
      usuario.getPermissoes().forEach(permissao -> {
        this.permissoes.add(new SimpleGrantedAuthority(permissao.name()));
      });
    }
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.permissoes;
  }

  @Override
  public String getPassword() {
    return this.usuario.getSenha();
  }

  @Override
  public String getUsername() {
    return this.usuario.getUsuario();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
