package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Documento;
import br.com.drs.radiotv_escritorio.model.Endereco;
import br.com.drs.radiotv_escritorio.model.enuns.Sexo;
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
public class FuncionarioDTO {

    private String nomeFuncionario;

    private Sexo sexo;

    private Documento documento;

    private Endereco endereco;

    private String email;

    private String telefone;

    private String celular;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private Boolean ativo;
}
