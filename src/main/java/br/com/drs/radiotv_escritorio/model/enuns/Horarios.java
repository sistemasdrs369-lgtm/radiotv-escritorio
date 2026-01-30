package br.com.drs.radiotv_escritorio.model.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Horarios {

    ROTATIVO_00_24("Rotativo 00:00 às 24:00"),
    ROTATIVO_06_24("Rotativo 06:00 às 24:00"),
    ROTATIVO_06_18("Rotativo 06:00 às 18:00"),
    ROTATIVO_MANHA("Rotativo Manhã 06:00 às 12:00"),
    ROTATIVO_TARDE("Rotativo Tarde 12:00 às 18:00"),
    ROTATIVO_NOITE("Rotativo Noite 18:00 às 24:00"),
    DETERMINADO("Determinado");

    private final String descricao;
}
