package br.com.analise.leilaoapi.repository;

import br.com.analise.leilaoapi.entity.Leilao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeilaoRepository extends CrudRepository<Leilao, Long> {
    
}
