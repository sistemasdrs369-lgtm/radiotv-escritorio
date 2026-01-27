package br.com.drs.radiotv_escritorio.mapper;

import br.com.drs.radiotv_escritorio.dto.EnderecoDTO;
import br.com.drs.radiotv_escritorio.model.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    Endereco toEntity(EnderecoDTO dto);

    EnderecoDTO toDto(Endereco entity);
}
