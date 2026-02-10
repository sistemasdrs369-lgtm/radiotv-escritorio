package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.AgenciasDTO;
import br.com.drs.radiotv_escritorio.mapper.AgenciasMapper;
import br.com.drs.radiotv_escritorio.model.Agencias;
import br.com.drs.radiotv_escritorio.repository.AgenciasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgenciasService {

    private final AgenciasRepository repository;
    private final AgenciasMapper mapper;

    public AgenciasDTO salvarAgencias(AgenciasDTO agenciasDTO) {
        Agencias agencias = mapper.toEntity(agenciasDTO);
        agencias = repository.save(agencias);
        return mapper.toDTO(agencias);
    }

    public AgenciasDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Agencia não encontrada com este id: " + id));
    }

    public Optional<Agencias> buscarPorNome(String nomeFantasia) {
        return repository.findByNomeFantasia(nomeFantasia);
    }

    public AgenciasDTO atualizarAgencias(Long id, AgenciasDTO agenciasDTO) {
        Agencias agenciasExistentes = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agencia não encontrado"));

        Agencias agenciasAtualizadas = mapper.toEntity(agenciasDTO);
        agenciasAtualizadas.setId(agenciasExistentes.getId());
        agenciasAtualizadas = repository.save(agenciasAtualizadas);
        return mapper.toDTO(agenciasAtualizadas);
    }

    public AgenciasDTO apagarAgencia(Long id) {
        Agencias agencias = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agencia não encontrada"));
        repository.delete(agencias);
        return mapper.toDTO(agencias);
    }
}
