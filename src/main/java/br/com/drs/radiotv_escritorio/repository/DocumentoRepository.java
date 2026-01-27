package br.com.drs.radiotv_escritorio.repository;

import br.com.drs.radiotv_escritorio.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    Optional<Documento> findByCpf(String cpf);
}
