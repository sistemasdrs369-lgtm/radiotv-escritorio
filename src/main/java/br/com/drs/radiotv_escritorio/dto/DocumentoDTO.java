package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Funcionario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoDTO {

    private Funcionario funcionario;

    private String cpf;

    private String rg;

    private String cnh;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate validade;

    private String categoria;

    private String reservista;
}
