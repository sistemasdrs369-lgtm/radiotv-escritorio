package br.com.drs.radiotv_escritorio.mapper;

import br.com.drs.radiotv_escritorio.dto.FamiliaDTO;
import br.com.drs.radiotv_escritorio.model.Familia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FamiliaMapper {

    Familia toEntity(FamiliaDTO dto);

    FamiliaDTO toDto(Familia familia);
}
