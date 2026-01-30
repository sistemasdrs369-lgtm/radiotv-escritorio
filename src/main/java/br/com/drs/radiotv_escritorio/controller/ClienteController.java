package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.dto.ClienteDTO;
import br.com.drs.radiotv_escritorio.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(service.salvarCliente(clienteDTO));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar(){
        return ResponseEntity.ok(service.listarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarClientePorId(id));
    }

    @GetMapping("/{nomeFantasia}")
    public ResponseEntity<ClienteDTO> buscarPorNome(@PathVariable String nomeFantasia){
        return ResponseEntity.ok(service.buscarPorNomeFantasia(nomeFantasia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(service.atualizarCliente(id, clienteDTO));
    }

    @DeleteMapping("/{id}")
    public void apagarCliente(@PathVariable Long id){
        service.apagarCliente(id);
    }
}
