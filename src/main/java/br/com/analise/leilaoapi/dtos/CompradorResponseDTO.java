package br.com.analise.leilaoapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompradorResponseDTO {
    private Integer empresaId;
    private Integer leilaoId;
}
