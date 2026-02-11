package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.model.Contrato;
import br.com.drs.radiotv_escritorio.service.ContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrato")
@RequiredArgsConstructor
public class ContratoController {

    private final ContratoService service;

    @PostMapping
    public Contrato salvarContrato(@RequestBody Contrato contrato) {
        return service.salvarContrato(contrato);
    }

    @GetMapping
    public List<Contrato> listarContratos() {
        return service.listarContratos();
    }

    @GetMapping("/{id}")
    public Contrato obterContratoPorId(@PathVariable Long id) {
        return service.obterContratoPorId(id);
    }

    @PutMapping("/{id}")
    public Contrato atualizarContrato(@PathVariable Long id, @RequestBody Contrato contrato) {
        return service.atualizarContrato(id, contrato);
    }

    @DeleteMapping("/{id}")
    public void excluirContrato(@PathVariable Long id) {
        service.excluirContrato(id);
    }
}