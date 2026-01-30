package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Documento;
import br.com.drs.radiotv_escritorio.model.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
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
public class ClienteDTO {

    private String razaoSocial;

    private String nomeFantasia;

    @OneToOne(cascade = CascadeType.ALL)
    private Documento documento;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataInauguracao;

    private String nomeProprietario;

    private String nomeContato;
}

