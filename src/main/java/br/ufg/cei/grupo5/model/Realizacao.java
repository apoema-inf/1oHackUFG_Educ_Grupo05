package br.ufg.cei.grupo5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author Iago Bruno
 * @since 1.0
 */
@Data
@Entity
@Table(name = "realizacoes")
public class Realizacao extends BasicModel {

  @Column
  private String nome;

}
