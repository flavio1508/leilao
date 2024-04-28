package br.com.analise.leilaoapi.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.analise.leilaoapi.dtos.UnidadeRequestDTO;
import br.com.analise.leilaoapi.dtos.UnidadeResponseDTO;
import br.com.analise.leilaoapi.entity.Unidade;
import br.com.analise.leilaoapi.mappers.UnidadeMapper;
import br.com.analise.leilaoapi.repository.UnidadeRepository;

@Service
public class UnidadeService {

    @Autowired
    private final UnidadeRepository unidadeRepository;

    @Autowired
    private final UnidadeMapper unidadeMapper;

    @Autowired
    public UnidadeService(UnidadeRepository unidadeRepository, UnidadeMapper unidadeMapper) {
        this.unidadeRepository = unidadeRepository;
        this.unidadeMapper = unidadeMapper;
    }

    public UnidadeResponseDTO criar(@Valid UnidadeRequestDTO unidadeRequestDTO) {
        Unidade unidade = unidadeMapper.unidadeRequestDTOToUnidade(unidadeRequestDTO);
        unidade = unidadeRepository.save(unidade);
        return unidadeMapper.unidadeToUnidadeResponseDTO(unidade);
    }

    public UnidadeResponseDTO atualizar(Long id, @Valid UnidadeRequestDTO unidadeRequestDTO) {
        Unidade existingUnidade = unidadeRepository.findById(id).orElse(null);
        if (existingUnidade != null) {
            Unidade updatedUnidade = unidadeMapper.unidadeRequestDTOToUnidade(unidadeRequestDTO);
            updatedUnidade.setId(existingUnidade.getId());
            updatedUnidade = unidadeRepository.save(updatedUnidade);
            return unidadeMapper.unidadeToUnidadeResponseDTO(updatedUnidade);
        }
        return null;
    }

    public void deletar(Long id) {
        unidadeRepository.deleteById(id);
    }

    public UnidadeResponseDTO buscarUnidadePorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUnidadePorId'");
    }

    public List<List> buscarTodasUnidades() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodasUnidades'");
    }

}
