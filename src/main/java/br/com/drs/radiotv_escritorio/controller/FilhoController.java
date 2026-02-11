package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.model.Filho;
import br.com.drs.radiotv_escritorio.service.FilhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filho")
@RequiredArgsConstructor
public class FilhoController {

    private final FilhoService service;

    @PostMapping
    public Filho adicionarFilho(@RequestBody Filho filho){
        return service.salvarFilho(filho);
    }

    @GetMapping
    public List<Filho> listarFilho(){
        return service.listarFilho();
    }

    @GetMapping("/{id}")
    public Filho obterFilhoPorId(@PathVariable Long id) {
        return service.buscarFilhoPorId(id);
    }

    @PutMapping
    public Filho atualizarFilho(@RequestParam Long id, @RequestBody Filho filhoAtualizado) {
        return service.atualizarFilho(id, filhoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarFilho(@PathVariable Long id) {
        service.deletarFilho(id);
    }
}
