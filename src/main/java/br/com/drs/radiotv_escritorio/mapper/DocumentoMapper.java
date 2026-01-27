package br.com.drs.radiotv_escritorio.mapper;

import br.com.drs.radiotv_escritorio.dto.DocumentoDTO;
import br.com.drs.radiotv_escritorio.model.Documento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {

    Documento toEntity(DocumentoDTO dto);

    DocumentoDTO toDTO(Documento documento);

}
