package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Funcionario;
import br.com.drs.radiotv_escritorio.model.enuns.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FamiliaDTO {

    private Funcionario funcionario;

    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private String cpf;

    private String rg;

    private String email;
}
