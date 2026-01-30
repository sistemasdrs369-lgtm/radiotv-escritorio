package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.ContratoMidiaDTO;
import br.com.drs.radiotv_escritorio.mapper.ContratoMidiaMapper;
import br.com.drs.radiotv_escritorio.model.ContratoMidia;
import br.com.drs.radiotv_escritorio.repository.ContratoMidiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratoMidiaService {

    private final ContratoMidiaRepository repository;

    private final ContratoMidiaMapper mapper;

    public ContratoMidiaDTO salvarContrato(@RequestBody ContratoMidiaDTO dto) {
        ContratoMidia contrato = mapper.toEntity(dto);
        contrato = repository.save(contrato);
        return mapper.toDto(contrato);
    }

    public List<ContratoMidiaDTO> listarContratoMidia() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    public ContratoMidiaDTO buscarContratoMidiaPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Contrato de Mídia não encontrado"));
    }

    public ContratoMidiaDTO atualizarContratoMidia(Long id, ContratoMidiaDTO dto) {
        ContratoMidia contratoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato de Mídia não encontrado"));

        ContratoMidia contratoAtualizado = mapper.toEntity(dto);
        contratoAtualizado.setId(contratoExistente.getId());
        contratoAtualizado = repository.save(contratoAtualizado);
        return mapper.toDto(contratoAtualizado);
    }

    public ContratoMidiaDTO apagarContratoMidia(Long id) {
        ContratoMidia contrato = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato de Mídia não encontrado"));
        repository.delete(contrato);
        return mapper.toDto(contrato);
    }
}
