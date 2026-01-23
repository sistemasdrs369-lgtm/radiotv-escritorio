package br.com.drs.radiotv_escritorio.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "documentos_db")
public class Documentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    private String rg;

    private String cnh;

    private LocalDate validade;

    private String categoria;

    private String reservista;
}
