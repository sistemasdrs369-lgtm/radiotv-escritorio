package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgenciadorDTO {

    private Funcionario funcionario;

    private BigDecimal vendasMes;

    private BigDecimal vendasFatura;

    private BigDecimal vendasProximoMes;

    private int comissao;

    private BigDecimal comissaoVendasMes;

    private BigDecimal metaMes;
}
