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
    public ResponseEntity<ContratoDTO> salvar(@RequestBody ContratoDTO contratoDTO){
        return ResponseEntity.ok(service.salvarContrato(contratoDTO));
    }

    @GetMapping
    public ResponseEntity<List<ContratoDTO>> buscarTodos(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarContratoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> atualizar(@PathVariable Long id, @RequestBody ContratoDTO dto) {
        return ResponseEntity.ok(service.atualizarContrato(id, dto));
    }

    @DeleteMapping("/{id}")
    public void apagarContrato(@PathVariable Long id) {
        service.deletarContrato(id);
    }
}
