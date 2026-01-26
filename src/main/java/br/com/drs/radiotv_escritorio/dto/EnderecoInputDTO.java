package br.com.drs.radiotv_escritorio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoInputDTO extends EnderecoDTO {

    private Long funcionarioId;
    private String cep;
    private String numero;
    private String complemento;
}
