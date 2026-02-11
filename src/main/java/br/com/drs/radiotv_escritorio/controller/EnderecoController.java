package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.model.Endereco;
import br.com.drs.radiotv_escritorio.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService service;

    @PostMapping
    public Endereco salvarEndereco(@RequestBody Endereco endereco){
        return service.salvarEndereco(endereco);
    }

    @GetMapping("/{id}")
    public Endereco buscarEnderecoPorId(@PathVariable Long id) {
        return service.buscarEnderecoPorId(id);
    }

    @GetMapping
    public List<Endereco> buscarEnderecos(){
        return service.buscarEnderecos();
    }

    @PutMapping("/{id}")
    public Endereco atualizarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        return service.atualizarEndereco(id, endereco);
    }

    @DeleteMapping("/{id}")
    public void deletarEndereco(@PathVariable Long id) {
        service.deletarEndereco(id);
    }
}
