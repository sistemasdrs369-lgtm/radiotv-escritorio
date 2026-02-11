package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.model.Agencia;
import br.com.drs.radiotv_escritorio.repository.AgenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenciaService {

    private final AgenciaRepository repository;

    public Agencia salvarAgencia(@RequestBody Agencia agencia){
        return repository.save(agencia);
    }

    public List<Agencia> listarAgencias(){
        return repository.findAll();
    }

    public Agencia buscarAgenciaPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Agencia atualizarAgencia(Long id, @RequestBody Agencia agenciaAtualizada) {
        return repository.findById(id)
                .map(agencia -> {
                    return repository.save(agencia);
                })
                .orElse(null);
    }

    public void deletarAgencia(Long id){
        repository.deleteById(id);
    }
}