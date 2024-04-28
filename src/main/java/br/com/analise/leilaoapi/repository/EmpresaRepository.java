package br.com.analise.leilaoapi.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.analise.leilaoapi.entity.Comprador;
import br.com.analise.leilaoapi.entity.CompradorId;
import br.com.analise.leilaoapi.entity.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
    //  List<Empresa> findByNomeContainingIgnoreCase(String nome);

    Optional<Empresa> findById(Long id);

    public List<Empresa> findAll();
}
