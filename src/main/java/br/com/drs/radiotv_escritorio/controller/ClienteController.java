package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.model.Cliente;
import br.com.drs.radiotv_escritorio.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return service.salvarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes(){
        return service.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id){
        return service.buscarClientePorId(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return service.atualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        service.deletarCliente(id);
    }
}