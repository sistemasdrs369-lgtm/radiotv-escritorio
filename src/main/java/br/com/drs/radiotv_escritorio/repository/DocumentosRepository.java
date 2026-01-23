package br.com.drs.radiotv_escritorio.repository;

import br.com.drs.radiotv_escritorio.model.Documentos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentosRepository extends JpaRepository<Documentos, Long> {

    Optional<Documentos> findByCpf(String cpf);
}
