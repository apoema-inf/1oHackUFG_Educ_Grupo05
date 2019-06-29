package br.ufg.cei.grupo5.repository;

import br.ufg.cei.grupo5.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Iago Bruno
 * @since 1.0
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
