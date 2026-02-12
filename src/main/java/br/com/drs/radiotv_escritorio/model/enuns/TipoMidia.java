package br.com.drs.radiotv_escritorio.model.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoMidia {

    GRAVADO("Gravado"),
    AO_VIVO("Ao Vivo"),
    TESTEMUNHAL("Testemunhal"),
    FLASH_TELEFONE("Flash Telefone"),
    FALSH_AO_VIVO("Flash Ao Vivo"),
    PATROCINIO("Patrocínio"),
    PATROCINIO_HORA("Patrocínio Hora"),
    PATROCINO_TEMPERATURA("Patrocínio Temperatura"),
    PATROCINI0_PROGRAMA("Patrocínio Programa"),
    PATROCINIO_QUADRO("Patrocínio Quadro"),
    BLITZ_LOJA("Blitz Loja"),
    BLITS_LOJA_MODELOS("Blitz Loja Modelos"),;

    private String descricao;
}
