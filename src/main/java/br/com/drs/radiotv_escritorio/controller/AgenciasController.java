package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.dto.AgenciasDTO;
import br.com.drs.radiotv_escritorio.model.Agencias;
import br.com.drs.radiotv_escritorio.service.AgenciasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agencias")
@RequiredArgsConstructor
public class AgenciasController {

    private final AgenciasService service;

    @PostMapping
    public ResponseEntity<AgenciasDTO> salvar(@RequestBody AgenciasDTO agenciasDTO){
        return ResponseEntity.ok(service.salvarAgencias(agenciasDTO));
    }

    @GetMapping
    public ResponseEntity<List<AgenciasDTO>> listar(){
        return ResponseEntity.ok(service.listarAgencias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgenciasDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/{nomeFantasia}")
    public ResponseEntity<Optional<Agencias>> buscarPorNome(@PathVariable String nomeFantasia){
        return ResponseEntity.ok(service.buscarPorNome(nomeFantasia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgenciasDTO> atualizar(@PathVariable Long id, @RequestBody AgenciasDTO agenciasDTO){
        return ResponseEntity.ok(service.atualizarAgencias(id,agenciasDTO));
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        service.apagarAgencia(id);
    }
}
