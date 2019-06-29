package br.ufg.cei.grupo5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Iago Bruno
 * @since 1.0
 */
@Entity
@Table(name = "perguntas_normalizadas")
public class PerguntaNormalizada extends BasicModel {

  @Column
  private String titulo;

  @Column
  private String pergunta;

}
