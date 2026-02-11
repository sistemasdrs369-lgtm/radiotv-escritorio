package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.model.Endereco;
import br.com.drs.radiotv_escritorio.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;

    public Endereco salvarEndereco(@RequestBody Endereco endereco) {
        return repository.save(endereco);
    }

    public Endereco buscarEnderecoPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public List<Endereco> buscarEnderecos() {
        return repository.findAll();
    }

    public Endereco atualizarEndereco(@PathVariable Long id,  @RequestBody Endereco endereco) {
        Endereco enderecoExistente = buscarEnderecoPorId(id);
        enderecoExistente.setLogradouro(endereco.getLogradouro());
        enderecoExistente.setNumero(endereco.getNumero());
        enderecoExistente.setComplemento(endereco.getComplemento());
        enderecoExistente.setBairro(endereco.getBairro());
        enderecoExistente.setCidade(endereco.getCidade());
        enderecoExistente.setEstado(endereco.getEstado());
        enderecoExistente.setCep(endereco.getCep());
        return repository.save(enderecoExistente);
    }

    public void deletarEndereco(@PathVariable Long id) {
        Endereco enderecoExistente = buscarEnderecoPorId(id);
        repository.delete(enderecoExistente);
    }
}
