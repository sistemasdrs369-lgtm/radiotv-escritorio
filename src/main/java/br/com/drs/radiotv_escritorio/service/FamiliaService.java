package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.FamiliaDTO;
import br.com.drs.radiotv_escritorio.mapper.FamiliaMapper;
import br.com.drs.radiotv_escritorio.model.Familia;
import br.com.drs.radiotv_escritorio.repository.FamiliaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FamiliaService {

    private final FamiliaRepository repository;

    private final FamiliaMapper mapper;

    public FamiliaDTO save(FamiliaDTO dto) {
        Familia familia = mapper.toEntity(dto);
        familia = repository.save(familia);
        return mapper.toDto(familia);
    }

    public List<FamiliaDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public FamiliaDTO buscarPorConjugue(String conjugue) {
        Familia familia = (Familia) repository.findByConjugue(conjugue)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado com o valor: " + conjugue));
        return mapper.toDto(familia);
    }

    public FamiliaDTO atualizar(@PathVariable Long id, FamiliaDTO dto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Familia não encontrado");
        }
        Familia familia = mapper.toEntity(dto);
        familia.setId(id);
        familia = repository.save(familia);
        return mapper.toDto(familia);
    }

    public void deletarFamilia(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Familia não encontrado");
        }
        repository.deleteById(id);
    }
}
