package br.ufg.cei.grupo5.model;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/**
 * @author Iago Bruno
 * @since 1.0
 */
@Data
@MappedSuperclass
public abstract class BasicModel implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

}
