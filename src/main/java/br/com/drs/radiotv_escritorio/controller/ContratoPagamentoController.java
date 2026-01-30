package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.dto.ContratoPagamentoDTO;
import br.com.drs.radiotv_escritorio.service.ContratoPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contratoPagamentos")
@RequiredArgsConstructor
public class ContratoPagamentoController {

    private final ContratoPagamentoService service;

    @PostMapping
    public ResponseEntity<ContratoPagamentoDTO> save(@RequestBody ContratoPagamentoDTO dto) {
        return ResponseEntity.ok(service.salvarContratoPagamento(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoPagamentoDTO> buscarPorId(@RequestParam Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoPagamentoDTO> atualizar(@PathVariable Long id, @RequestBody ContratoPagamentoDTO dto) {
        return ResponseEntity.ok(service.atualizarContratoPagamento(id, dto));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletarContratoPagamento(id);
    }
}
