package br.com.drs.radiotv_escritorio.repository;

import br.com.drs.radiotv_escritorio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
