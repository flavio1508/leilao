package br.com.analise.leilaoapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

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
public class Unidade extends EntidadeBase {
    @Column(nullable = false, length = 128, unique = true)
    private String nome;

}
