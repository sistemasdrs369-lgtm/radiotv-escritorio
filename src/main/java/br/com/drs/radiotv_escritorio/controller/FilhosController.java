package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.dto.FilhosDTO;
import br.com.drs.radiotv_escritorio.service.FilhosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/filhos")
@RequiredArgsConstructor
public class FilhosController {

    private final FilhosService service;

    @PostMapping
    public ResponseEntity<FilhosDTO> create(@RequestBody FilhosDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<FilhosDTO>> findAll() {
        return ResponseEntity.ok(Collections.singletonList(service.listarFilhos()));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<FilhosDTO> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(service.listarFilhosPorNome(nome));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilhosDTO> update(@PathVariable Long id, @RequestBody FilhosDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.apagarFilhos(id);
    }
}
