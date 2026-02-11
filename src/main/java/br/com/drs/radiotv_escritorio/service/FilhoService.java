package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.model.Filho;
import br.com.drs.radiotv_escritorio.repository.FilhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilhoService {

    private final FilhoRepository repository;

    public Filho salvarFilho(@RequestBody Filho filho){
        return repository.save(filho);
    }

    public List<Filho> listarFilho(){
        return repository.findAll();
    }

    public Filho buscarFilhoPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Filho não encontrado"));
    }

    public Filho atualizarFilho(Long id, @RequestBody Filho filhoAtualizado){
        Filho filhoExistente = repository.findById(id).orElseThrow(() -> new RuntimeException("Filho não encontrado"));
        filhoExistente.setNome(filhoAtualizado.getNome());
        return repository.save(filhoExistente);
    }

    public void deletarFilho(Long id){
        Filho filhoExistente = repository.findById(id).orElseThrow(() -> new RuntimeException("Filho não encontrado"));
        repository.delete(filhoExistente);
    }
}
