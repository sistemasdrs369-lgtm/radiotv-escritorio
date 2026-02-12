package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.model.ContratoPagamento;
import br.com.drs.radiotv_escritorio.service.ContratoPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratoPagamento")
@RequiredArgsConstructor
public class ContratoPagamentoController {

    private final ContratoPagamentoService service;

    @PostMapping
    public ContratoPagamento novoContratoPagamento(@RequestBody ContratoPagamento cp) {
        return service.salvarContrato(cp);
    }

    @GetMapping
    public List<ContratoPagamento> listarContratoPagamento(){
        return service.consultarContratoPagamento();
    }

    @GetMapping("/{id}")
    public ContratoPagamento buscarContratoPagamentoPorId(@PathVariable Long id) {
        return service.consultarContratoPagamentoPorId(id);
    }

    @PutMapping("/{id}")
    public ContratoPagamento atualizarContratoPagamento(@PathVariable Long id, @RequestBody ContratoPagamento cp) {
        return service.atualizarContratoPagamento(id, cp);
    }

    @DeleteMapping("/{id}")
    public void deletarContratoPagamento(@PathVariable Long id) {
        service.deletarContratoPagamento(id);
    }
}