package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.ClienteDTO;
import br.com.drs.radiotv_escritorio.mapper.ClienteMapper;
import br.com.drs.radiotv_escritorio.model.Cliente;
import br.com.drs.radiotv_escritorio.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    private final ClienteMapper mapper;

    public ClienteDTO salvarCliente(ClienteDTO dto) {
        Cliente cliente = mapper.toEntity(dto);
        cliente = repository.save(cliente);
        return mapper.toDTO(cliente);
    }

    public ClienteDTO buscarClientePorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public ClienteDTO buscarPorNomeFantasia(String nomeFantasia) {
        return repository.findByNomeFantasia(nomeFantasia);
    }

    public ClienteDTO atualizarCliente(@PathVariable Long id, ClienteDTO dto) {
        Cliente clienteExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Cliente clienteAtualizado = mapper.toEntity(dto);
        clienteAtualizado.setId(clienteExistente.getId());
        clienteAtualizado = repository.save(clienteAtualizado);
        return mapper.toDTO(clienteAtualizado);
    }

    public ClienteDTO apagarCliente(@PathVariable Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        repository.delete(cliente);
        return mapper.toDTO(cliente);
    }
}
