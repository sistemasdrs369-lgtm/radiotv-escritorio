package br.com.drs.radiotv_escritorio.repository;

import br.com.drs.radiotv_escritorio.model.Filho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilhoRepository extends JpaRepository<Filho, Long> {
}
