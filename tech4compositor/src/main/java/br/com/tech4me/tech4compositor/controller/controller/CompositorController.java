package br.com.tech4me.tech4musica.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4compositor.dto.CompositorComMusicaDto;
import br.com.tech4me.tech4compositor.dto.CompositorDto;
import br.com.tech4me.tech4compositor.service.CompositorService;

@RestController
@RequestMapping("/api/compositor")
public class CompositorController {

  private ModelMapper mapper = new ModelMapper();

  @Autowired
  private CompositorService service;
  
  @GetMapping
  public ResponseEntity<List<CompositorDto>> obterTodos() {
    return new ResponseEntity<>(service.obterCompositor(), HttpStatus.OK);

  }

  @GetMapping("/{id}")
  public ResponseEntity<CompositorComMusicaDto> obterPorId(@PathVariable String id) {
    Optional<CompositorDto> compositor = service.obterCompositorPorId(id);

    if (compositor.isPresent()) {
      return new ResponseEntity<>(mapper.map(compositor.get(), CompositorComMusicaDto.class), HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public ResponseEntity<CompositorDto> cadastrarCompositor(@RequestBody CompositorDto compositor){
    return new ResponseEntity<>(service.cadastrarCompositor(compositor), HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirCompositorPorId(@PathVariable String id){
        service.excluirCompositor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompositorDto> atualizarCompositor(@PathVariable String id, @RequestBody @Valid CompositorDto compositor){
        return new ResponseEntity<>(service.alterarCompositor(id, compositor), HttpStatus.ACCEPTED);
    }



  
}
