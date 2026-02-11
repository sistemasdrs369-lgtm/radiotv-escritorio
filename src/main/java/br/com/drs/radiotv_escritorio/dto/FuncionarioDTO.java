package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Endereco;
import br.com.drs.radiotv_escritorio.model.enuns.Sexo;
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
public class FuncionarioDTO {

    private String nome;

    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private String cpf;

    private String rg;

    private String cnh;

    private LocalDate dataVencimento;

    private String categoria;

    private String reservista;

    private Endereco endereco;

    private String email;
}
