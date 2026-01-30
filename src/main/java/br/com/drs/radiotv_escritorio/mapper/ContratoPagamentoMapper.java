package br.com.drs.radiotv_escritorio.mapper;

import br.com.drs.radiotv_escritorio.dto.ContratoPagamentoDTO;
import br.com.drs.radiotv_escritorio.model.ContratoPagamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContratoPagamentoMapper {

    ContratoPagamento toEntity(ContratoPagamentoDTO dto);

    ContratoPagamentoDTO toDto(ContratoPagamento contratoPagamento);
}
