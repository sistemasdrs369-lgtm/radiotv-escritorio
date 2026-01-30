package br.com.drs.radiotv_escritorio.mapper;

import br.com.drs.radiotv_escritorio.dto.AgenciasDTO;
import br.com.drs.radiotv_escritorio.model.Agencias;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgenciasMapper {

    Agencias toEntity(AgenciasDTO agenciasDTO);

    AgenciasDTO toDTO(Agencias agencias);
}
