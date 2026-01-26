package br.com.drs.radiotv_escritorio.repository;

import br.com.drs.radiotv_escritorio.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

}
