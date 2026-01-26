package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.DocumentoDTO;
import br.com.drs.radiotv_escritorio.mapper.DocumentoMapper;
import br.com.drs.radiotv_escritorio.model.Documento;
import br.com.drs.radiotv_escritorio.model.Funcionario;
import br.com.drs.radiotv_escritorio.repository.DocumentoRepository;
import br.com.drs.radiotv_escritorio.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentoService {

    private final DocumentoRepository repository;

    private final DocumentoMapper mapper;

    private final FuncionarioRepository funcionarioRepository;

    public DocumentoDTO salvar(DocumentoDTO dto) {
        Documento documento = mapper.toEntity(dto);
        Long funcionarioId = dto.getFuncionario().getId();
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        documento.setFuncionario(funcionario);
        Documento salvo = repository.save(documento);
        return mapper.toDto(salvo);
    }

    // READ (Todos)
    public List<DocumentoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    // READ (Por ID)
    public DocumentoDTO buscarPorId(Long id) {
        Documento documento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado"));
        return mapper.toDto(documento);
    }

    // UPDATE
    public DocumentoDTO atualizar(Long id, DocumentoDTO dto) {
        Documento documentoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado"));

        // Atualiza os campos da entidade com os dados do DTO
        Documento documentoAtualizado = mapper.toEntity(dto);
        documentoAtualizado.setId(documentoExistente.getId()); // Garante que o ID permaneça o mesmo

        return mapper.toDto(repository.save(documentoAtualizado));
    }

    // DELETE
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Não é possível deletar: Documento não encontrado");
        }
        repository.deleteById(id);
    }
}
