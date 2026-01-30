package br.com.drs.radiotv_escritorio.mapper;

import br.com.drs.radiotv_escritorio.dto.AgenciadorDTO;
import br.com.drs.radiotv_escritorio.model.Agenciador;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgenciadorMapper {

    Agenciador toEntity(AgenciadorDTO dto);

    AgenciadorDTO toDto(Agenciador agenciador);
}
