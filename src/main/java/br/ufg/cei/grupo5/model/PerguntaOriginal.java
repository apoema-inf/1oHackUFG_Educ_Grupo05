package br.ufg.cei.grupo5.model;

import br.ufg.cei.grupo5.model.enumerator.CategoriaEnum;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * @author Iago Bruno
 * @since 1.0
 */
@Data
@Entity
@Table(name = "perguntas_originais")
public class PerguntaOriginal extends BasicModel {

  @Column
  private String pergunta;

  @ManyToOne
  @JoinColumn(name = "questionador_id")
  private Usuario questionador;

  @Column
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date dataEnvio;

  @Column
  @Enumerated(EnumType.STRING)
  private CategoriaEnum categoria;

  @ManyToOne
  @JoinColumn(name = "unidade_academica_id")
  private UnidadeAcademica unidadeAcademica;

  @OneToMany
  @JoinColumn(name = "respostas_originais_id")
  private List<RespostaOriginal> respostasOriginais;

}
