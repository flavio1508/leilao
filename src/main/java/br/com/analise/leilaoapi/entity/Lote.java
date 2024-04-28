package br.com.analise.leilaoapi.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.analise.leilaoapi.util.EntidadeBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lote extends EntidadeBase {
    @Column(nullable = false)
    private Integer numeroLote;
    @Column(nullable = false, length = 60)
    private String descricao;
    @Column(nullable = false)
    private BigDecimal quantidade;
    private BigDecimal valorInicial;
    @Column(nullable = false, length = 128)
    private String unidade;
    @ManyToOne
    @JoinColumn(name = "leilao_id", nullable = false)
    private Leilao leilao;

}
