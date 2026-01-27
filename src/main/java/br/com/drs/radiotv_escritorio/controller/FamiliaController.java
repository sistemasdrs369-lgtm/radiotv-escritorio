package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.dto.FamiliaDTO;
import br.com.drs.radiotv_escritorio.mapper.FamiliaMapper;
import br.com.drs.radiotv_escritorio.service.FamiliaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/familia")
@RequiredArgsConstructor
public class FamiliaController {

    private final FamiliaService service;

    private final FamiliaMapper mapper;

    @PostMapping
    public ResponseEntity<FamiliaDTO> createFamilia(@RequestBody FamiliaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<FamiliaDTO>> getAllFamilia() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{conjugue}")
    public ResponseEntity<FamiliaDTO> buscarPorConjugue(@PathVariable String conjugue) {
        return ResponseEntity.ok(service.buscarPorConjugue(conjugue));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamiliaDTO> atualizar(@PathVariable Long id, @RequestBody FamiliaDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.deletarFamilia(id);
    }
}
