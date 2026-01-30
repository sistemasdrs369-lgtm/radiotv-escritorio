package br.com.drs.radiotv_escritorio.mapper;

import br.com.drs.radiotv_escritorio.dto.ContratoMidiaDTO;
import br.com.drs.radiotv_escritorio.model.ContratoMidia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContratoMidiaMapper {

    ContratoMidia toEntity(ContratoMidiaDTO dto);

    ContratoMidiaDTO toDto(ContratoMidia contratoMidia);
}
