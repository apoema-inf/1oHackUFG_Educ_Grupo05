package br.ufg.cei.grupo5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author Iago Bruno
 * @since 1.0
 */
@Data
@Entity
@Table(name = "respostas_normalizadas")
public class RespostaNormalizada extends BasicModel {

  @Lob
  @Column
  private String resposta;

  @Column
  private String respostaPlana;

  @ManyToOne
  @JoinColumn(name = "resposta_original_id")
  private RespostaOriginal aluno;

  @ManyToOne
  @JoinColumn(name = "pergunta_normalizada_id")
  private PerguntaNormalizada perguntaNormalizada;

  @Column
  private Boolean aprovado;

}
