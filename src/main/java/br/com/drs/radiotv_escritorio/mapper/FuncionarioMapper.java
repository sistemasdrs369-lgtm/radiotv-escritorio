package br.com.drs.radiotv_escritorio.mapper;

import br.com.drs.radiotv_escritorio.dto.FuncionarioDTO;
import br.com.drs.radiotv_escritorio.model.Funcionario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    FuncionarioDTO toDTO(Funcionario funcionario);

    Funcionario toEntity(FuncionarioDTO funcionarioDTO);
}
