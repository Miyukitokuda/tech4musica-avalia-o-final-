package br.com.tech4me.tech4compositor.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4compositor.dto.CompositorDto;
import br.com.tech4me.tech4compositor.model.Compositor;
import br.com.tech4me.tech4compositor.repository.CompositorRepository;

@Service
public class CompositorServiceImpl implements CompositorService {

  private ModelMapper mapper = new ModelMapper();

  @Autowired
  private CompositorRepository compositorRepository;

  @Override
  public CompositorDto cadastrarCompositor(CompositorDto compositor) {
    Compositor compositorCadastro = mapper.map(compositor, Compositor.class);
    compositorCadastro = compositorRepository.save(compositorCadastro);
    return mapper.map(compositorCadastro, CompositorDto.class);
  }

  @Override
  public List<CompositorDto> obterCompositor() {
    List<Compositor> compositor = compositorRepository.findAll();

    return compositor.stream()
                  .map(a -> mapper.map(a, CompositorDto.class))
                  .collect(Collectors.toList()); 
  }

  @Override
  public Optional<CompositorDto> obterCompositorPorId(String id) {
    Optional<Compositor> compositor = compositorRepository.findById(id);

    if (compositor.isPresent()) {
      CompositorDto dto = mapper.map(compositor.get(), CompositorDto.class);
      
      dto.setMusica(musica.obterMusicaPorCompositor(id));

      return Optional.of(dto);
    }
    return Optional.empty();
  }

  @Override
  public void excluirCompositor(String id) {
    compositorRepository.deleteById(id);
    
  }

  @Override
  public CompositorDto alterarCompositor(String id, CompositorDto compositor) {
    Optional<Compositor> compositorBusca = compositorRepository.findById(id);

    if (compositorBusca.isPresent()) {
      Compositor compositorAlteracao = mapper.map(compositor, Compositor.class);
      compositorAlteracao.setId(id);
      compositorAlteracao = compositorRepository.save(compositorAlteracao);
      return mapper.map(compositorAlteracao, CompositorDto.class);
    }
   
    return null;
  }
  
}
