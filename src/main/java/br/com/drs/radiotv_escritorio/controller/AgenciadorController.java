package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.dto.AgenciadorDTO;
import br.com.drs.radiotv_escritorio.service.AgenciadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agenciador")
@RequiredArgsConstructor
public class AgenciadorController {

    private final AgenciadorService service;

    @PostMapping
    public ResponseEntity<AgenciadorDTO> salvarAgenciador(@RequestBody AgenciadorDTO agenciadorDTO) {
        return ResponseEntity.ok(service.create(agenciadorDTO));
    }

    @GetMapping
    public ResponseEntity<List<AgenciadorDTO>> listarAgenciadores() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgenciadorDTO> obterAgenciadorPorId(Long id) {
        return ResponseEntity.ok(service.buscarporId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgenciadorDTO> atualizarAgenciador(Long id, AgenciadorDTO agenciadorDTO) {
        return ResponseEntity.ok(service.atualizarAgenciador(id, agenciadorDTO));
    }

    @DeleteMapping("/{id}")
    public void deletarAgenciador(Long id) {
        service.apagarAgenciador(id);
    }
}