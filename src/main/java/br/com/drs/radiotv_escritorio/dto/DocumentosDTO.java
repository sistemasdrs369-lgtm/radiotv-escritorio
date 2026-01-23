package br.com.drs.radiotv_escritorio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentosDTO {

    private String cpf;

    private String rg;

    private String cnh;

    private LocalDate validade;

    private String categoria;

    private String reservista;
}
