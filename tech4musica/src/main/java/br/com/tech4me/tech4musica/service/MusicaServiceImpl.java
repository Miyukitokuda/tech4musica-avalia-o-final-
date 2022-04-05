package br.com.tech4me.tech4musica.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4musica.dto.MusicaDTO;
import br.com.tech4me.tech4musica.model.Musica;
import br.com.tech4me.tech4musica.repository.MusicaRepository;

@Service
public class MusicaServiceImpl implements MusicaService {
    ModelMapper mapper = new ModelMapper();

    @Autowired
    private MusicaRepository repositorio;

    @Override
    public List<MusicaDTO> obterTodasAsMusica() {
        List<Musica> musica = repositorio.findAll();
        
        return musica.stream()
                .map(l -> mapper.map(l, MusicaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MusicaDTO> obterMusicaPorId(String id) {
        Optional<Musica> musica = repositorio.findById(id);

        if(musica.isPresent()) {
            return Optional.of(mapper.map(musica.get(), MusicaDTO.class));
        }

        return Optional.empty();
    }

    @Override
    public MusicaDTO armazenarMusica(MusicaDTO musica) {
        Musica musicaGravar = mapper.map(musica, Musica.class);
        musicaGravar = repositorio.save(musicaGravar);
        
        return mapper.map(musicaGravar, MusicaDTO.class);
    }

    @Override
    public void excluirMusicaPorId(String id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public MusicaDTO atualizarMusica(String id, MusicaDTO musica) {
        Musica musicaAtualizar = mapper.map(musica, Musica.class);
        musicaAtualizar.setId(id);
        musicaAtualizar = repositorio.save(musicaAtualizar);

        return mapper.map(musicaAtualizar, MusicaDTO.class);
    }

    @Override
    public List<MusicaDTO> obterPorCompositor(String compositor) {
        List<Musica> musica = repositorio.findByCompositor(compositor);
       
        return musica.stream()
            .map(l -> mapper.map(l, MusicaDTO.class))
            .collect(Collectors.toList());
    }
    
}
