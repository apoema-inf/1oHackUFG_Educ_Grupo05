package br.ufg.cei.grupo5.repository;

import br.ufg.cei.grupo5.model.PerguntaNormalizada;
import br.ufg.cei.grupo5.model.enumerator.CategoriaEnum;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Iago Bruno
 * @since 1.0
 */
public interface PerguntaNormalizadaRepository extends JpaRepository<PerguntaNormalizada, Long> {

  List<PerguntaNormalizada> findByCategoria(CategoriaEnum categoria);

}
