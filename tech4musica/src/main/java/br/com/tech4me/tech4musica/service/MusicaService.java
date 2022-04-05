package br.com.tech4me.tech4musica.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4musica.dto.MusicaDTO;

public interface MusicaService {
    List<MusicaDTO> obterTodasAsmusica();

    Optional<MusicaDTO> obterMusicaPorId(String id);

    MusicaDTO armazenarMusica(MusicaDTO musica);

    void excluirMusicaPorId(String id);

    MusicaDTO atualizarMusica(String id, MusicaDTO musica);

    List<MusicaDTO> obterPorCompositor(String compositor);
}
