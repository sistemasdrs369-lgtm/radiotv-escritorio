package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.FilhosDTO;
import br.com.drs.radiotv_escritorio.mapper.FilhosMapper;
import br.com.drs.radiotv_escritorio.model.Filhos;
import br.com.drs.radiotv_escritorio.repository.FilhosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilhosService {

    private final FilhosRepository repository;

    private final FilhosMapper mapper;

    public FilhosDTO create(@RequestBody FilhosDTO filhosDTO) {
        Filhos filhos = mapper.toEntity(filhosDTO);
        filhos = repository.save(filhos);
        return mapper.toDTO(filhos);
    }

    public FilhosDTO listarFilhos() {
        return (FilhosDTO) repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public FilhosDTO listarFilhosPorNome(String nome) {
        Filhos filhos = (Filhos) repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Filho não encontrado: " + nome));
        return mapper.toDTO(filhos);
    }

    public FilhosDTO atualizar(@PathVariable Long id, @RequestBody FilhosDTO filhosDTO) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Filhos não encontrado");
        }
        Filhos filhos = mapper.toEntity(filhosDTO);
        filhos.setId(id);
        filhos = repository.save(filhos);
        return mapper.toDTO(filhos);
    }

    public void apagarFilhos(Long id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Filho não encontrado");
        }
        repository.deleteById(id);
    }
}
