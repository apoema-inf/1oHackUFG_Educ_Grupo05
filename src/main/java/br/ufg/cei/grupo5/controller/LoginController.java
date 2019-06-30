package br.ufg.cei.grupo5.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Iago Bruno
 * @since 1.0
 *
 */
@Controller
public class LoginController {

  /**
   * Requisição GET da página de login.
   *
   * @return retorna a página de login ou a tela home da aplicação caso já esteja autenticado
   */
  @RequestMapping("/login")
  public ModelAndView login(){
    try {
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      if (!(auth instanceof AnonymousAuthenticationToken)) {
        return new ModelAndView("redirect:/");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ModelAndView("/login");
  }

}
