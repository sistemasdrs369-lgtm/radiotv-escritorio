package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.model.Agencia;
import br.com.drs.radiotv_escritorio.service.AgenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agencia")
@RequiredArgsConstructor
public class AgenciaController {

    private final AgenciaService service;

    @PostMapping
    public Agencia salvarAgencia(@RequestBody Agencia agencia){
        return service.salvarAgencia(agencia);
    }

    @GetMapping
    public List<Agencia> listarAgencias(){
        return service.listarAgencias();
    }

    @GetMapping("/{id}")
    public Agencia buscarAgenciaPorId(@PathVariable Long id){
        return service.buscarAgenciaPorId(id);
    }

    @PutMapping("/{id}")
    public Agencia atualizarAgencia(@PathVariable Long id, @RequestBody Agencia agencia) {
        return service.atualizarAgencia(id, agencia);
    }

    @DeleteMapping("/{id}")
    public void deletarAgencia(@PathVariable Long id) {
        service.deletarAgencia(id);
    }
}