package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.FuncionarioDTO;
import br.com.drs.radiotv_escritorio.mapper.FuncionarioMapper;
import br.com.drs.radiotv_escritorio.model.Funcionario;
import br.com.drs.radiotv_escritorio.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;

    public FuncionarioDTO salvar(FuncionarioDTO dto) {
        Funcionario funcionario = mapper.toEntity(dto);
        funcionario = repository.save(funcionario);
        return mapper.toDto(funcionario);
    }

    public List<FuncionarioDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public FuncionarioDTO buscarPorId(Long id) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + id));
        return mapper.toDto(funcionario);
    }

    public FuncionarioDTO atualizar(Long id, FuncionarioDTO dto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado");
        }
        Funcionario funcionario = mapper.toEntity(dto);
        funcionario.setId(id); // Garante que vai atualizar o registro correto
        funcionario = repository.save(funcionario);
        return mapper.toDto(funcionario);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado");
        }
        repository.deleteById(id);
    }
}
