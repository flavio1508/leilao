package br.com.analise.leilaoapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompradorRequestDTO {
    private Integer empresaId;
    private Integer leilaoId;
}
