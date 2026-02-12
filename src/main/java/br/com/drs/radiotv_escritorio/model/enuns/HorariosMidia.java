package br.com.drs.radiotv_escritorio.model.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HorariosMidia {

    DETERMINADO("Determinado"),
    INDETERMINADO("Indeterminado"),
    ROTATIVO_00_AS_24("Rotativo 00h às 24h"),
    ROTATIVO_06_AS_24("Rotativo 06h às 24h"),
    ROTATIVO_12_AS_24("Rotativo 12h às 24h"),
    ROTATIVO_18_AS_24("Rotativo 18h às 24h"),
    ROTATIVO_00_AS_06("Rotativo 00h às 06h"),
    ROTATIVO_00_AS_12("Rotativo 00h às 12h"),
    ROTATIVO_00_AS_18("Rotativo 00h às 18h"),
    ROTATIVO_06_AS_12("Rotativo 06h às 12h"),
    ROTATIVO_06_AS_18("Rotativo 06h às 18h"),
    ROTATIVO_12_AS_18("Rotativo 12h às 18h"),
    ROTATIVO_18_AS_06("Rotativo 18h às 06h"),
    ROTATIVO_12_AS_06("Rotativo 12h às 06h"),
    ROTATIVO_18_AS_12("Rotativo 18h às 12h");

    private final String descricao;
}
