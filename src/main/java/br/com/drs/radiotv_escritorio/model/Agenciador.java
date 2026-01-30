package br.com.drs.radiotv_escritorio.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "agenciador_db")
public class Agenciador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Funcionario funcionario;

    private BigDecimal vendasMes;

    private BigDecimal vendasFatura;

    private BigDecimal vendasProximoMes;

    private int comissao;

    private BigDecimal comissaoVendasMes;

    private BigDecimal metaMes;

}
