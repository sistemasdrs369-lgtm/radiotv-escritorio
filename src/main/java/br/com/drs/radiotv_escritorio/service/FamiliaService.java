package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.model.Familia;
import br.com.drs.radiotv_escritorio.repository.FamiliaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamiliaService {

    private final FamiliaRepository repository;

    public Familia salvarFamilia(@RequestBody Familia familia) {
        return repository.save(familia);
    }

    public List<Familia> listarFamilias() {
        return repository.findAll();
    }

    public Familia buscarFamiliaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Familia atualizarFamilia(Long id, @RequestBody Familia familiaAtualizada) {
        return repository.findById(id).map(familia -> {
            familia.setNome(familiaAtualizada.getNome());
            return repository.save(familia);
        }).orElse(null);
    }

    public void deletarFamilia(Long id) {
        repository.deleteById(id);
    }
}
