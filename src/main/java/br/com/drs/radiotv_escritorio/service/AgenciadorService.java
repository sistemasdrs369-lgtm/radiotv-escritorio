package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.AgenciadorDTO;
import br.com.drs.radiotv_escritorio.mapper.AgenciadorMapper;
import br.com.drs.radiotv_escritorio.model.Agenciador;
import br.com.drs.radiotv_escritorio.repository.AgenciadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgenciadorService {

    private final AgenciadorRepository repository;

    private final AgenciadorMapper mapper;

    public AgenciadorDTO create(@RequestBody AgenciadorDTO dto) {
        Agenciador agenciador = mapper.toEntity(dto);
        agenciador = repository.save(agenciador);
        return mapper.toDto(agenciador);
    }

    public List<AgenciadorDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public AgenciadorDTO buscarporId(@PathVariable Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Agenciador não encontrado"));
    }

    public AgenciadorDTO atualizarAgenciador(@PathVariable Long id, @RequestBody AgenciadorDTO dto) {
        Agenciador agenciadorExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agenciador não encontrado"));

        Agenciador agenciadorAtualizado = mapper.toEntity(dto);
        agenciadorAtualizado.setId(agenciadorExistente.getId());

        agenciadorAtualizado = repository.save(agenciadorAtualizado);
        return mapper.toDto(agenciadorAtualizado);
    }

    public AgenciadorDTO apagarAgenciador(@PathVariable Long id) {
        Agenciador agenciador = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agenciador não encontrado"));
        repository.delete(agenciador);
        return mapper.toDto(agenciador);
    }
}
