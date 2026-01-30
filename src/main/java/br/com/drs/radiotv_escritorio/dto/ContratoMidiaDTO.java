package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Contrato;
import br.com.drs.radiotv_escritorio.model.enuns.DiasSemana;
import br.com.drs.radiotv_escritorio.model.enuns.Horarios;
import br.com.drs.radiotv_escritorio.model.enuns.TipoMidia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContratoMidiaDTO {

    private Contrato contrato;

    private DiasSemana diasSemana;

    private TipoMidia tipoMidia;

    private Horarios horarios;

    private List<LocalTime> determinadosHorarios;

    private Integer tempoSegundos;

    private Integer quantidade;
}
