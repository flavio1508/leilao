package br.com.analise.leilaoapi.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoteRequestDTO {
    private Integer numeroLote;
    private String descricao;
    private BigDecimal quantidade;
    private BigDecimal valorInicial;
    private String unidade;
    private Integer leilaoId;
}
