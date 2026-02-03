package br.com.drs.radiotv_escritorio.repository;

import br.com.drs.radiotv_escritorio.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContratoRepository extends JpaRepository<Contrato,Long> {

    Optional<Contrato> findByCliente(Long clienteId);
}
