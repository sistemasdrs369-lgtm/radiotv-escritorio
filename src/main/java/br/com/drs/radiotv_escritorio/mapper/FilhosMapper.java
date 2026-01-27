package br.com.drs.radiotv_escritorio.mapper;

import br.com.drs.radiotv_escritorio.dto.FilhosDTO;
import br.com.drs.radiotv_escritorio.model.Filhos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilhosMapper {

    Filhos toEntity(FilhosDTO dto);

    FilhosDTO toDTO(Filhos filhos);
}
