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
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private Funcionario funcionario;

    private BigDecimal vendasMes;

    private Integer comissaoPercentual;

    private BigDecimal comissaoValorMes;

    private BigDecimal vendasProximoMes;
}
