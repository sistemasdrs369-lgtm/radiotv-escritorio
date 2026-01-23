package br.com.drs.radiotv_escritorio.model.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sexo {

    FEMININO("Feminino"),
    MASCULINO("Masculino"),
    NAOINFORMADO("Não Infomado");

    private String descricao;
}
