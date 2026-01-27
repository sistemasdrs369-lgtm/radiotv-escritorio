package br.com.drs.radiotv_escritorio.repository;

import br.com.drs.radiotv_escritorio.model.Filhos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilhosRepository extends JpaRepository<Filhos,Long> {
    Optional<Object> findByNome(String nome);
}
