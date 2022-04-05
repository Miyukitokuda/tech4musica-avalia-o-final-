package br.com.tech4me.tech4compositor.dto;

import java.util.List;

import br.com.tech4me.tech4compositor.shared.Musica;

public class CompositorComMusicaDto {
  private String id;
  private String nome;
  private String nacionalidade;
  private String nascimento;
  private List<Musica> musica;
  
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
  public List<Musica> getMusica() {
    return musica;
  }
  public void setMusica(List<Musica> musica) {
    this.musica = musica;
  }

  
  
}
