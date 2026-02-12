package br.com.drs.radiotv_escritorio.model.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TempoMidia {

    CINCO_SEGUNDOS("5 segundos"),
    DEZ_SEGUNDOS("10 segundos"),
    QUINZE_SEGUNDOS("15 segundos"),
    TRINTA_SEGUNDOS("30 segundos"),
    QUARENTA_E_CINCO_SEGUNDOS("45 segundos"),
    UM_MINUTO("1 minuto"),
    UM_MITUTO_E_MEIO("1 minuto e meio"),
    DOIS_MINUTOS("2 minutos");

    private String descricao;
}
