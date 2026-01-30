package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Contrato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContratoPagamentoDTO {

    private Contrato contrato;

    private BigDecimal valor;

    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    private LocalDate dataFaturamento;

    private BigDecimal valorPago;
}
