package br.com.analise.leilaoapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analise.leilaoapi.entity.Comprador;
import br.com.analise.leilaoapi.entity.CompradorId;
import br.com.analise.leilaoapi.entity.Empresa;

@Repository
public interface CompradorRepository extends CrudRepository<Comprador, CompradorId>{
    
}
