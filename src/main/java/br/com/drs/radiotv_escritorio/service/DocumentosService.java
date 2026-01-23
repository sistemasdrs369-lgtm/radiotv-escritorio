package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.model.Documentos;
import br.com.drs.radiotv_escritorio.repository.DocumentosRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentosService {

    private final DocumentosRepository documentosRepository;

    public Documentos salvarDocumentos(@RequestBody Documentos documentos) {
        documentosRepository.save(documentos);
        return documentos;
    }

    public List<Documentos> listarDocumentos() {
        return documentosRepository.findAll();
    }

    public Optional<Documentos> buscarPorCpf(String cpf) {
        return documentosRepository.findByCpf(cpf);
    }

    public Documentos atualizarDocumentos(@PathVariable Long id, @RequestBody Documentos documentos) {
        if(documentos.getId() == null) {
            throw new EntityNotFoundException("Documento não cadastrado");
        }
        return documentosRepository.save(documentos);
    }
}
