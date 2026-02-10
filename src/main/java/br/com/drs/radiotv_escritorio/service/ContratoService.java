package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.ContratoDTO;
import br.com.drs.radiotv_escritorio.mapper.ContratoMapper;
import br.com.drs.radiotv_escritorio.model.Contrato;
import br.com.drs.radiotv_escritorio.repository.ContratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContratoService {

    private final ContratoRepository repository;

    private final ContratoMapper mapper;

    public ContratoDTO salvarContrato(ContratoDTO dto) {
        Contrato contrato = mapper.toEntity(dto);
        contrato = repository.save(contrato);
        return mapper.toDTO(contrato);
    }

    public List<ContratoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ContratoDTO buscarContratoPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
    }

    public ContratoDTO atualizarContrato(Long id, ContratoDTO dto) {
        Contrato contratoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado"));

        Contrato contratoAtualizado = mapper.toEntity(dto);
        contratoAtualizado.setId(contratoExistente.getId());
        contratoAtualizado = repository.save(contratoAtualizado);
        return mapper.toDTO(contratoAtualizado);
    }

    public void deletarContrato(Long id) {
        Contrato contrato = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
        repository.delete(contrato);
    }
}
