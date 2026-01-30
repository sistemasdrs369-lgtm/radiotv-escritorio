package br.com.drs.radiotv_escritorio.mapper;

import br.com.drs.radiotv_escritorio.dto.ContratoDTO;
import br.com.drs.radiotv_escritorio.model.Contrato;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContratoMapper {

    Contrato toEntity(ContratoDTO dto);
    ContratoDTO toDto(Contrato contrato);
}
