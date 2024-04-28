package br.com.analise.leilaoapi.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Leilao extends EntidadeBase {

    private Integer codigo;
    @Column(nullable = false, length = 60)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Empresa vendedor;

    @Column(nullable = false)
    private Timestamp inicioPrevisto;

    @OneToMany(mappedBy = "leilao")
    private List<Lote> lotes;

   

  
}
