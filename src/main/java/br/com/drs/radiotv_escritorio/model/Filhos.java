package br.com.drs.radiotv_escritorio.model;

import br.com.drs.radiotv_escritorio.model.enuns.Sexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "filhos_db")
public class Filhos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    private Documento documento;
}
