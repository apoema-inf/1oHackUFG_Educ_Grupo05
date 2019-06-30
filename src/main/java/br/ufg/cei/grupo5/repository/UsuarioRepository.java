package br.ufg.cei.grupo5.repository;

import br.ufg.cei.grupo5.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Iago Bruno
 * @since 1.0
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  Usuario findByUsuario(String usuario);
}
