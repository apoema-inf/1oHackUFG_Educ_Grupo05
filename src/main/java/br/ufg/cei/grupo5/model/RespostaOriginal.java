package br.ufg.cei.grupo5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author Iago Bruno
 * @since 1.0
 */
@Data
@Entity
@Table(name = "respostas_originais")
public class RespostaOriginal extends BasicModel {

  @Column
  private String resposta;

  @ManyToOne
  @JoinColumn(name = "aluno_id")
  private Usuario aluno;

  @ManyToOne
  @JoinColumn(name = "professor_id")
  private Usuario professor;

  @Column
  private String observacao;

  @Column
  private Boolean aprovada;



}
