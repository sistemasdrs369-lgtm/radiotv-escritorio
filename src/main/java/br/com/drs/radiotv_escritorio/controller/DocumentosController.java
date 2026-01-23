package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.model.Documentos;
import br.com.drs.radiotv_escritorio.service.DocumentosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
public class DocumentosController {

    private DocumentosService documentosService;

    @PostMapping
    public ResponseEntity<Documentos> salvar(@RequestBody Documentos documentos) {
        Documentos novoDocumento = documentosService.salvarDocumentos(documentos);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDocumento);
    }

    @GetMapping
    public List<Documentos> listar() {
        return documentosService.listarDocumentos();
    }

    @GetMapping("/cpf")
    public ResponseEntity<Optional<Documentos>> buscarPorCpf(@RequestBody Documentos documentos) {
        return ResponseEntity.ok(documentosService.buscarPorCpf(String.valueOf(documentos)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Documentos> atualizar(@PathVariable Long id, @RequestBody Documentos documentos) {
        if(documentos.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(documentosService.atualizarDocumentos(id, documentos));
    }
}
