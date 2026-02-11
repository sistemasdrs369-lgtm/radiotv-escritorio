package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.model.Contrato;
import br.com.drs.radiotv_escritorio.repository.ContratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratoService {

    private final ContratoRepository repository;

    public Contrato salvarContrato(Contrato contrato) {
        return repository.save(contrato);
    }

    public List<Contrato> listarContratos() {
        return repository.findAll();
    }

    public Contrato obterContratoPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
    }

    public Contrato atualizarContrato(Long id, Contrato contrato) {
        Contrato contratoExistente = repository.findById(id).orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
        return repository.save(contratoExistente);
    }

    public void excluirContrato(Long id) {
        Contrato contratoExistente = repository.findById(id).orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
        repository.delete(contratoExistente);
    }
}
