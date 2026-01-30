package br.com.drs.radiotv_escritorio.model.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoMidia {

    GRAVADO("Gravado"),
    AO_VIVO("Ao Vivo"),
    TESTEMUNHAL("Testemunhal"),
    PATROCINIO("Patrocínio"),
    PATROCINIO_PROGRAMADO("Patrocínio Programado"),
    PATROCINIO_TEMPERATURA("Patrocínio Temporal"),
    PATROCINIO_HORACERTA("Patrocínio Horacerta"),
    FLASH_TELEFONE("Flash Telefone"),
    FLASH_LOJA("Flash Loja"),
    VIATURA_LOJA("Viatura Loja"),
    VIATURA_LOJA_MODELOS("Viatura Loja Modelos"),
    OUTROS("Outros");

    private final String descricao;
}
