package br.com.analise.leilaoapi.dtos;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeilaoRequestDTO {
    private Integer codigo;
    private String descricao;
    private Integer vendedorId;
    private Timestamp inicioPrevisto;
}
