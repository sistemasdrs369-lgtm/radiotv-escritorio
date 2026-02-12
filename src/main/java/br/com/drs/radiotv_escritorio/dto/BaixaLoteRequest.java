package br.com.drs.radiotv_escritorio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaixaLoteRequest {

    private List<Long> pagamentosIds;

    private LocalDate dataPagamento;

    private BigDecimal valorTotalRecebido;
}
