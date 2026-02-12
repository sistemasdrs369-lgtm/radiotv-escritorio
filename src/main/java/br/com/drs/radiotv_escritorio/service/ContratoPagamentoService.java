package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.model.ContratoPagamento;
import br.com.drs.radiotv_escritorio.repository.ContratoPagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratoPagamentoService {

    private final ContratoPagamentoRepository repository;

    private final VendedorService vendedorService;

    private final AgenciaService agenciaService;

    public ContratoPagamento salvarContrato(@RequestBody ContratoPagamento contratoPagamento){
        return repository.save(contratoPagamento);
    }

    public List<ContratoPagamento> consultarContratoPagamento(){
        return repository.findAll();
    }

    public ContratoPagamento consultarContratoPagamentoPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public ContratoPagamento atualizarContratoPagamento(Long id, @RequestBody ContratoPagamento contratoPagamento){
        ContratoPagamento contratoExistente = repository.findById(id).orElse(null);
        if (contratoExistente != null) {
            return repository.save(contratoExistente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarContratoPagamento(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
