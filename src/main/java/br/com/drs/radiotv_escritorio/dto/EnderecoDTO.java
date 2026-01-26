package br.com.drs.radiotv_escritorio.dto;

import br.com.drs.radiotv_escritorio.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private Funcionario funcionario;

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;
}
