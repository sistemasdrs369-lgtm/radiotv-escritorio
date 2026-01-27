package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.dto.DocumentoDTO;
import br.com.drs.radiotv_escritorio.service.DocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documento")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoService service;

    @PostMapping
    public ResponseEntity<DocumentoDTO> cadastrarDocumento(@RequestBody DocumentoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarDocumento(dto));
    }

    @GetMapping
    public ResponseEntity<List<DocumentoDTO>> listarDocumentos() {
        return  ResponseEntity.ok(service.listarDocumentos());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<DocumentoDTO> listarDocumento(@PathVariable String cpf) {
        return ResponseEntity.ok(service.buscarPorDocumento(cpf));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoDTO> atualizarDocumento(@PathVariable Long id, @RequestBody DocumentoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public void removerDocumento(@PathVariable Long id) {
        service.deletarPorDocumento(id);
    }
}
