package br.com.drs.radiotv_escritorio.repository;

import br.com.drs.radiotv_escritorio.model.Agencias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgenciasRepository extends JpaRepository<Agencias,Long> {
    Optional<Agencias> findByNomeFantasia(String nomeFantasia);
}
