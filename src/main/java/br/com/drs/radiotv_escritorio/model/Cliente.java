package br.com.drs.radiotv_escritorio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "clientes_db")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
