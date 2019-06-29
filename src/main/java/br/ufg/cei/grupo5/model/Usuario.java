package br.ufg.cei.grupo5.model;

import br.ufg.cei.grupo5.model.enumerator.PermissaoEnum;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author Iago Bruno
 * @since 1.0
 */
@Data
@Entity
@Table(name = "usuarios")
public class Usuario extends BasicModel {

  @Column
  private String nome;

  @Column
  private String usuario;

  @Column
  private String senha;

  @Column
  private String email;

  @ElementCollection(targetClass = PermissaoEnum.class)
  @JoinTable(name = "usuarios_permissoes", joinColumns = @JoinColumn(name = "id"))
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  Collection<PermissaoEnum> permissoes;

}
