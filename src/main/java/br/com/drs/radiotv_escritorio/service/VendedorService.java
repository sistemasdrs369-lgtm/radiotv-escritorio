package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.model.Vendedor;
import br.com.drs.radiotv_escritorio.repository.VendedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendedorService {

    private final VendedorRepository repository;

    public Vendedor salvarVendedor(@RequestBody Vendedor vendedor) {
        return repository.save(vendedor);
    }

    public List<Vendedor> listarVendedores() {
        return repository.findAll();
    }

    public Vendedor buscarVendedorPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Vendedor atualizarVendedor(Long id, @RequestBody Vendedor vendedorAtualizado) {
        return repository.findById(id)
                .map(vendedor -> {
                    return repository.save(vendedor);
                })
                .orElse(null);
    }

    public void deletarVendedor(Long id) {
        repository.deleteById(id);
    }
}
