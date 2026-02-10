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
@Table(name = "agencias_db")
public class Agencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razaoSocial;

    private String nomeFantasia;

    @OneToOne()
    @JoinColumn(name = "documento_id", unique = true)
    private Documento documento;

    @OneToOne()
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataInauguracao;

    private String nomeProprietario;

    private String nomeContato;
}
