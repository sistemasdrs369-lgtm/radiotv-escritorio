package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Documentos;
import br.com.drs.radiotv_escritorio.model.Endereco;
import br.com.drs.radiotv_escritorio.model.enuns.Sexo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
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

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @OneToOne(cascade = CascadeType.ALL)
    private Documentos documentos;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private String email;

    private String telefone;

    private String celular;

    private LocalDate dataNascimento;

    private Boolean ativo;
}
