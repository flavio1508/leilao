package br.com.analise.leilaoapi.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoteResponseDTO {
     private Integer id;
    private Integer numeroLote;
    private String descricao;
    private BigDecimal quantidade;
    private BigDecimal valorInicial;
    private String unidade;
    private Integer leilaoId;
}
