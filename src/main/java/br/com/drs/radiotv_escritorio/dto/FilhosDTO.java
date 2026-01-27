package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Documento;
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
public class FilhosDTO {

    private String nome;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private LocalDate dataNascimento;

    private int idade;

    @OneToOne(cascade = CascadeType.ALL)
    private Documento documento;
}
