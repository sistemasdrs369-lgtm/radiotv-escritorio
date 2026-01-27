package br.com.drs.radiotv_escritorio.model.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoCivil {

    SOLTEIRO("Solteiro(a)"),
    CASADO("Casado(a)"),
    SEPARADO("Separado(a)"),
    DIVORCIADO("Divosrciado(a)"),
    AMIGADO("Amigado(a)"),
    VIUVO("Viuvo(a)"),
    OUTROS("Outros(a)");

    private String descricao;
}
