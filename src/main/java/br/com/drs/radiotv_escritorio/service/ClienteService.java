package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.model.Cliente;
import br.com.drs.radiotv_escritorio.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    public List<Cliente> listarClientes(){
        return repository.findAll();
    }

    public Cliente buscarClientePorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        return repository.findById(id)
                .map(cliente -> {
                    return repository.save(cliente);
                })
                .orElse(null);
    }

    public void deletarCliente(Long id){
        repository.deleteById(id);
    }
}