package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Endereco;
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
public class ClienteDTO {

    private String razaoSocial;

    private String nomeFantasia;

    private Endereco endereco;

    private String cnpj;

    private String inscricaoEstadual;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate inauguracao;

    private String site;

    private String email;

    private String proprietario;

    private String telefone;

    private String celular;

    private int contratosAtivos;

    private  Boolean primeiroContrato;
}