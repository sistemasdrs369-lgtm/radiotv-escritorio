package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Agencia;
import br.com.drs.radiotv_escritorio.model.Cliente;
import br.com.drs.radiotv_escritorio.model.Vendedor;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ContratoDTO {

    private Cliente cliente;

    private Vendedor vendedor;

    private Agencia agencia;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate assinaturaContrato;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate inicioVigencia;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate terminoVigencia;

    private BigDecimal valorTotalContrato;

    private Boolean ativo;
}
