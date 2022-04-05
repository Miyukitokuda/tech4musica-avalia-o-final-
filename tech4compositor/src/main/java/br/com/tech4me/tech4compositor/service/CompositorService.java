package br.com.tech4me.tech4compositor.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4compositor.dto.CompositorDto;

public interface CompositorService {
  CompositorDto cadastrarCompositor(CompositorDto compositor);
  List<CompositorDto> obterCompositor();
  Optional<CompositorDto> obterCompositorPorId(String id);
  void excluirCompositor(String id);
  CompositorDto alterarCompositor(String id, CompositorDto compositor);
  
}
