package br.com.drs.radiotv_escritorio.model;

import br.com.drs.radiotv_escritorio.model.enuns.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "familia_db")
public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    private String conjugue;

    @OneToOne()
    @JoinColumn(name = "documento_id", unique = true)
    private Documento documento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dataNascimento;

    private Boolean temFilhos;
}
