package br.com.tech4me.tech4compositor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("compositor")
public class compositor {
  @Id
  private String id;
  private String nome;
  private String nacionalidade;
  private String nascimento;

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getNacionalidade() {
    return nacionalidade;
  }
  public void setNacionalidade(String nacionalidade) {
    this.nacionalidade = nacionalidade;
  }
  public String getNascimento() {
    return nascimento;
  }
  public void setNascimento(String nascimento) {
    this.nascimento = nascimento;
  }

  
  
}
