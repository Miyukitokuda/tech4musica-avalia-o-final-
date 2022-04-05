package br.com.tech4me.tech4musica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4musica.model.Musica;

public interface MusicaRepository extends MongoRepository<Musica, String> {

  List<Musica> findByCompositor(String compositor);

}
