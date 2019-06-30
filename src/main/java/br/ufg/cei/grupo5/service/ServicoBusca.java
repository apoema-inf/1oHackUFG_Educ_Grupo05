package br.ufg.cei.grupo5.service;

import br.ufg.cei.grupo5.model.PerguntaNormalizada;
import br.ufg.cei.grupo5.model.enumerator.CategoriaEnum;
import br.ufg.cei.grupo5.repository.PerguntaNormalizadaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Iago Bruno
 * @since 1.0
 */
@Service
public class ServicoBusca {

  private final int NUM_REGISTRO = 5;

  @Autowired
  private PerguntaNormalizadaRepository perguntaNormalizadaRepository;


  @Transactional
  public List<PerguntaNormalizada> getPerguntasPesquisa(String query, Integer page,
      CategoriaEnum categoria) {
    return perguntaNormalizadaRepository.findByCategoria(categoria);

  }

}
