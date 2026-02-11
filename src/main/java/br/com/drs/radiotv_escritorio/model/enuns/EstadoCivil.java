package br.com.drs.radiotv_escritorio.model.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoCivil {

    SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    DIVORCIADO("Divorciado"),
    VIUVO("Viúvo"),
    SEPARADO("Separado");

    private final String descricao;
}
