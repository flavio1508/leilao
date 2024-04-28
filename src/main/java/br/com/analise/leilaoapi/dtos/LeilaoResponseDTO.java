package br.com.analise.leilaoapi.dtos;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeilaoResponseDTO {
    private Integer id;
    private Integer codigo;
    private String descricao;
    private Integer vendedorId;
    private Timestamp inicioPrevisto;
}
