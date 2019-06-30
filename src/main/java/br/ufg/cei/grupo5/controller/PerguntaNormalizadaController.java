package br.ufg.cei.grupo5.controller;

import br.ufg.cei.grupo5.model.enumerator.CategoriaEnum;
import br.ufg.cei.grupo5.repository.PerguntaNormalizadaRepository;
import br.ufg.cei.grupo5.service.ServicoBusca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Iago Bruno
 * @since 1.0
 */
@Controller
public class PerguntaNormalizadaController {

  @Autowired
  private ServicoBusca servicoBusca;

  @Autowired
  private PerguntaNormalizadaRepository perguntaNormalizadaRepository;

  @RequestMapping("/perguntas-categorias")
  public String perguntasCategorias() {
    return "/perguntas-categorias";
  }

  @RequestMapping("/perguntas")
  public ModelAndView perguntas(String categoria, String query, Integer page, Model model) {
    try {
      if (StringUtils.isEmpty(query)) {
        model.addAttribute("perguntas",
            perguntaNormalizadaRepository.findByCategoria(CategoriaEnum.valueOf(categoria)));
      } else if (StringUtils.isEmpty(categoria)) {
        try {
          model.addAttribute("perguntas",
              servicoBusca.getPerguntasPesquisa(query, page, CategoriaEnum.valueOf(categoria)));
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    model.addAttribute("categoria", categoria);
    return new ModelAndView("/perguntas");
  }


}
