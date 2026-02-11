package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.model.Vendedor;
import br.com.drs.radiotv_escritorio.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedor")
@RequiredArgsConstructor
public class VendedorController {

    private final VendedorService service;

    @PostMapping
    public Vendedor salvarVendedor(@RequestBody Vendedor vendedor) {
        return service.salvarVendedor(vendedor);
    }

    @GetMapping
    public List<Vendedor> listarVendedores() {
        return service.listarVendedores();
    }

    @GetMapping("/{id}")
    public Vendedor buscarVendedorPorId(@PathVariable Long id) {
        return service.buscarVendedorPorId(id);
    }

    @PutMapping("/{id}")
    public Vendedor atualizarVendedor(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        return service.atualizarVendedor(id, vendedor);
    }

    @DeleteMapping("/{id}")
    public void deletarVendedor(@PathVariable Long id) {
        service.deletarVendedor(id);
    }
}
