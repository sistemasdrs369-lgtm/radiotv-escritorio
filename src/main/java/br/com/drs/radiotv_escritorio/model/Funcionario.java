package br.com.drs.radiotv_escritorio.model;

import br.com.drs.radiotv_escritorio.model.enuns.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "funcionario_db")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFuncionario;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private String email;

    private String telefone;

    private String celular;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private BigDecimal salario;

    private Boolean ativo;
}
