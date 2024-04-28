package br.com.analise.leilaoapi.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comprador {
    @EmbeddedId
    private CompradorId id;

    @ManyToOne
    @MapsId("empresa")
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne
    @MapsId("leilao")
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;
    

    
    
}
