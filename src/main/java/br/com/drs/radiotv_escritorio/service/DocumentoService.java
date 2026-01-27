package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.DocumentoDTO;
import br.com.drs.radiotv_escritorio.mapper.DocumentoMapper;
import br.com.drs.radiotv_escritorio.model.Documento;
import br.com.drs.radiotv_escritorio.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentoService {

    private final DocumentoRepository repository;

    private final DocumentoMapper mapper;

    public DocumentoDTO salvarDocumento(DocumentoDTO dto) {
        Documento documento = mapper.toEntity(dto);
        documento = repository.save(documento);
        return mapper.toDTO(documento);
    }

    public List<DocumentoDTO> listarDocumentos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public DocumentoDTO buscarPorDocumento(String cpf) {
        Documento doc = (Documento) repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado com o valor: " + cpf));
        return mapper.toDTO(doc);
    }

    public DocumentoDTO atualizar(@PathVariable Long id,  DocumentoDTO dto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Documento não encontrado");
        }
        Documento documento = mapper.toEntity(dto);
        documento.setId(id);
        documento = repository.save(documento);
        return mapper.toDTO(documento);
    }

    public void deletarPorDocumento(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Documento não encontrado");
        }
       repository.deleteById(id);
    }
}
