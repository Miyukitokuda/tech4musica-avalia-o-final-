package br.com.tech4me.tech4compositor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4compositor.model.Autor;

public interface CompositorRepository extends MongoRepository< Compositor, String>{

}
