package br.ufg.cei.grupo5.controller;

import br.ufg.cei.grupo5.model.PerguntaOriginal;
import br.ufg.cei.grupo5.model.enumerator.CategoriaEnum;
import br.ufg.cei.grupo5.repository.PerguntaOriginalRepository;
import br.ufg.cei.grupo5.repository.UsuarioRepository;
import br.ufg.cei.grupo5.security.CustomUserDetails;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PerguntaOriginalController {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private PerguntaOriginalRepository perguntaOriginalRepository;


  @RequestMapping("/fazer-pergunta")
  public ModelAndView fazerPergunta(Model model) {
    return new ModelAndView("/fazer-pergunta");
  }

  @PostMapping("/enviar-pergunta")
  public ModelAndView enviarPergunta(String textContent){

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();

    PerguntaOriginal perguntaOriginal = new PerguntaOriginal();

    perguntaOriginal.setDataEnvio(new Date());
    perguntaOriginal.setCategoria(CategoriaEnum.OUTROS);
    perguntaOriginal.setPergunta(textContent);
    perguntaOriginal.setQuestionador(usuarioRepository.findByUsuario(principal.getUsername()));

    perguntaOriginalRepository.save(perguntaOriginal);

    return new ModelAndView("/index");

  }

}
