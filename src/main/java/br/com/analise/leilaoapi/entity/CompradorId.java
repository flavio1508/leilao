package br.com.analise.leilaoapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompradorId implements Serializable {
    @Column(name = "empresa_id")
    private Integer empresaId;
    @Column(name = "leilao_id")
    private Integer leilaoId;
}
