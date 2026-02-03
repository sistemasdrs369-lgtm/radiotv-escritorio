package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.dto.ContratoDTO;
import br.com.drs.radiotv_escritorio.service.ContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrato")
@RequiredArgsConstructor
public class ContratoController {

    private final ContratoService service;

    @PostMapping
    public ResponseEntity<ContratoDTO> save(@RequestBody ContratoDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<ContratoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> atualizarContrato(@PathVariable Long id, @RequestBody ContratoDTO dto) {
        return ResponseEntity.ok(service.atualizarContrato(id, dto));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
