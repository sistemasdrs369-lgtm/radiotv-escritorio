package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.model.Familia;
import br.com.drs.radiotv_escritorio.service.FamiliaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/familia")
@RequiredArgsConstructor
public class FamiliaController {

    private final FamiliaService service;

    @PostMapping
    public Familia salvarFamilia(@RequestBody Familia familia) {
        return service.salvarFamilia(familia);
    }

    @GetMapping("/{id}")
    public Familia buscarFamiliaPorId(@PathVariable Long id) {
        return service.buscarFamiliaPorId(id);
    }

    @GetMapping
    public java.util.List<Familia> listarFamilias() {
        return service.listarFamilias();
    }

    @PutMapping("/{id}")
    public Familia atualizarFamilia(@PathVariable Long id, @RequestBody Familia familiaAtualizada) {
        return service.atualizarFamilia(id, familiaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarFamilia(@PathVariable Long id) {
        service.deletarFamilia(id);
    }
}
