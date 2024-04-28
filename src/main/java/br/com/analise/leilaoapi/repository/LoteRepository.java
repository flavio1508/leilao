package br.com.analise.leilaoapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analise.leilaoapi.entity.Lote;

@Repository
public interface LoteRepository extends CrudRepository<Lote, Long> {
    
}
