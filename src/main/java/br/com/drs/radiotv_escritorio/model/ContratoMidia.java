package br.com.drs.radiotv_escritorio.model;

import br.com.drs.radiotv_escritorio.model.enuns.DiasSemana;
import br.com.drs.radiotv_escritorio.model.enuns.Horarios;
import br.com.drs.radiotv_escritorio.model.enuns.TipoMidia;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "contratoMidia_db")
public class ContratoMidia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrato_id", nullable = false)
    private Contrato contrato;

    @Enumerated(EnumType.STRING)
    private DiasSemana diasSemana;

    @Enumerated(EnumType.STRING)
    private TipoMidia tipoMidia;

    @Enumerated(EnumType.STRING)
    private Horarios horarios;

    private List<LocalTime> determinadosHorarios;

    private Integer tempoSegundos;

    private Integer quantidade;
}
