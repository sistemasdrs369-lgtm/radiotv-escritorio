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

    // CREATE
    public FuncionarioDTO salvar(FuncionarioDTO dto) {
        Funcionario funcionario = mapper.toEntity(dto);
        funcionario = repository.save(funcionario);
        return mapper.toDTO(funcionario);
    }

    // READ (Todos)
    public List<FuncionarioDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    // READ (Por ID)
    public FuncionarioDTO buscarPorId(Long id) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        return mapper.toDTO(funcionario);
    }

    // UPDATE
    public FuncionarioDTO atualizar(Long id, FuncionarioDTO dto) {
        Funcionario funcionarioExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        // Atualiza os campos da entidade com os dados do DTO
        Funcionario funcionarioAtualizado = mapper.toEntity(dto);
        funcionarioAtualizado.setId(funcionarioExistente.getId()); // Garante que o ID permaneça o mesmo

        return mapper.toDTO(repository.save(funcionarioAtualizado));
    }

    // DELETE
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Não é possível deletar: Funcionário não encontrado");
        }
        repository.deleteById(id);
    }
}