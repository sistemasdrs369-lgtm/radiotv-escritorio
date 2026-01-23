package br.com.drs.radiotv_escritorio.mapper;

import br.com.drs.radiotv_escritorio.dto.DocumentosDTO;
import br.com.drs.radiotv_escritorio.model.Documentos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {

    DocumentosDTO toDTO(Documentos documentos);

    Documentos toEntity(DocumentosDTO documentosDTO);
}
