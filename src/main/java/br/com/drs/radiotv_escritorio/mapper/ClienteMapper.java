package br.com.drs.radiotv_escritorio.mapper;

import br.com.drs.radiotv_escritorio.dto.ClienteDTO;
import br.com.drs.radiotv_escritorio.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteDTO clienteDTO);

    ClienteDTO toDTO(Cliente cliente);
}
