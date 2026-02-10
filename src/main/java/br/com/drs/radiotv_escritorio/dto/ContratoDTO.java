package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Agenciador;
import br.com.drs.radiotv_escritorio.model.Agencias;
import br.com.drs.radiotv_escritorio.model.Cliente;
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

    private Agencias agencias_id;

    private Agenciador agenciador_id;

    private Cliente cliente_id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate inicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate termino;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate assinatura;

    private BigDecimal valorContrato;
}
