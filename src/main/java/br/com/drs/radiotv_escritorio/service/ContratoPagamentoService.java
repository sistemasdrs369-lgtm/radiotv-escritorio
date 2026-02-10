package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.ContratoPagamentoDTO;
import br.com.drs.radiotv_escritorio.mapper.ContratoPagamentoMapper;
import br.com.drs.radiotv_escritorio.model.Agenciador;
import br.com.drs.radiotv_escritorio.model.Contrato;
import br.com.drs.radiotv_escritorio.model.ContratoPagamento;
import br.com.drs.radiotv_escritorio.repository.AgenciadorRepository;
import br.com.drs.radiotv_escritorio.repository.ContratoPagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratoPagamentoService {

    private final ContratoPagamentoRepository repository;

    private final ContratoPagamentoMapper mapper;

    private final AgenciadorRepository agenciadorRepository;


    public ContratoPagamentoDTO salvarContratoPagamento(@RequestBody ContratoPagamentoDTO contratoPagamentoDTO) {
        ContratoPagamento contratoPagamento = mapper.toEntity(contratoPagamentoDTO);
        contratoPagamento = repository.save(contratoPagamento);
        incluirParcelasAgenciador(contratoPagamento);
        return mapper.toDto(contratoPagamento);
    }

    public List<ContratoPagamentoDTO> listarContratoPagamento() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    public ContratoPagamentoDTO buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Contrato Pagamento não encontrado"));
    }

    public ContratoPagamentoDTO atualizarContratoPagamento(@PathVariable Long id, @RequestBody ContratoPagamentoDTO contratoPagamentoDTO) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("Contrato pagamento não encontrado"));
        ContratoPagamento pagamentoAtualizado = repository.save(mapper.toEntity(contratoPagamentoDTO));
        return mapper.toDto(pagamentoAtualizado);
    }

    public void deletarContratoPagamento(@PathVariable Long id) {
        repository.deleteById(id);
    }

    public void incluirParcelasAgenciador(ContratoPagamento pagamento) {
        Contrato contrato = pagamento.getContrato();
        Agenciador agenciador = contrato.getAgenciador();
        if (pagamento.getContrato().getId().equals(contrato.getId())) {
            if (agenciador.getId().equals(contrato.getAgenciador().getId())) {
                BigDecimal vendasMes = agenciador.getVendasMes();
                BigDecimal valorPagamento = pagamento.getValor();
                BigDecimal novoValorVendasMes = vendasMes.add(valorPagamento);
                agenciador.setVendasMes(novoValorVendasMes);
                agenciadorRepository.save(agenciador);
            }
        }
    }

}
