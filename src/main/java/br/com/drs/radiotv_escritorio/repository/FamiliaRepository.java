package br.com.drs.radiotv_escritorio.repository;

import br.com.drs.radiotv_escritorio.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FamiliaRepository extends JpaRepository<Familia, Long> {
    Optional<Object> findByConjugue(String conjugue);
}
