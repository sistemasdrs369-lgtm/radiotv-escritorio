package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.dto.ContratoMidiaDTO;
import br.com.drs.radiotv_escritorio.service.ContratoMidiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratosMidia")
@RequiredArgsConstructor
public class ContratoMidiaController {

    private final ContratoMidiaService service;

    @PostMapping
    public ResponseEntity<ContratoMidiaDTO> save(@RequestBody ContratoMidiaDTO dto) {
        return ResponseEntity.ok(service.salvarContrato(dto));
    }

    @GetMapping
    public ResponseEntity<List<ContratoMidiaDTO>> findAll() {
        return ResponseEntity.ok(service.listarContratoMidia());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoMidiaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarContratoMidiaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoMidiaDTO> update(@PathVariable Long id, @RequestBody ContratoMidiaDTO dto) {
        return ResponseEntity.ok(service.atualizarContratoMidia(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.apagarContratoMidia(id);
    }
}
