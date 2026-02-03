package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.ContratoDTO;
import br.com.drs.radiotv_escritorio.mapper.ContratoMapper;
import br.com.drs.radiotv_escritorio.model.Contrato;
import br.com.drs.radiotv_escritorio.repository.ClienteRepository;
import br.com.drs.radiotv_escritorio.repository.ContratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratoService {

    private final ContratoRepository repository;

    private final ContratoMapper mapper;

    private final ClienteRepository clienteRepository;

    public ContratoDTO save(@RequestBody ContratoDTO contratoDTO) {
        Contrato contrato = mapper.toEntity(contratoDTO);
        buscarPorNomeFantasia(contrato.getCliente().getId());
        Contrato result = repository.save(contrato);
        return mapper.toDto(result);
    }

    public List<ContratoDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    public ContratoDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
    }

    public ContratoDTO atualizarContrato(@PathVariable Long id, @RequestBody ContratoDTO contratoDTO) {
        Contrato contratoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
        Contrato contratoAtualizado  = mapper.toEntity(contratoDTO);
        Contrato contartoAtualizado = repository.save(contratoExistente);
        return mapper.toDto(contartoAtualizado);
    }

    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    public ContratoDTO buscarPorNomeFantasia(Long clienteId) {
        Contrato contrato = repository.findByCliente(clienteId)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado para o Cliente ID: " + clienteId));
        System.out.println(clienteId);
        return mapper.toDto(contrato);
    }

}
