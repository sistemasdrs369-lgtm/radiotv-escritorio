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
    public ResponseEntity<DocumentoDTO> create(@RequestBody DocumentoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<DocumentoDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoDTO> update(@PathVariable Long id, @RequestBody DocumentoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
