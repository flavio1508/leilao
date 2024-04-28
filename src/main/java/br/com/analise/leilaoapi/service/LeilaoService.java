package br.com.analise.leilaoapi.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.analise.leilaoapi.dtos.LeilaoRequestDTO;
import br.com.analise.leilaoapi.dtos.LeilaoResponseDTO;
import br.com.analise.leilaoapi.entity.Leilao;
import br.com.analise.leilaoapi.mappers.LeilaoMapper;
import br.com.analise.leilaoapi.repository.LeilaoRepository;

@Service
public class LeilaoService {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Autowired
    private LeilaoMapper leilaoMapper;

    @Autowired
    public LeilaoService(LeilaoRepository leilaoRepository, LeilaoMapper leilaoMapper) {
        this.leilaoRepository = leilaoRepository;
        this.leilaoMapper = leilaoMapper;
    }

    public LeilaoResponseDTO criar(@Valid LeilaoRequestDTO leilaoRequestDTO) {
        Leilao leilao = leilaoMapper.leilaoRequestDTOToLeilao(leilaoRequestDTO);
        leilao = leilaoRepository.save(leilao);
        return leilaoMapper.leilaoToLeilaoResponseDTO(leilao);
    }

    public LeilaoResponseDTO atualizar(Long id, @Valid LeilaoRequestDTO leilaoRequestDTO) {
        Optional<Leilao> existingLeilao = Optional.ofNullable(leilaoRepository.findById(id).orElse(null));
        if (existingLeilao != null) {
            Leilao updatedLeilao = leilaoMapper.leilaoRequestDTOToLeilao(leilaoRequestDTO);
            updatedLeilao.setId(existingLeilao.get().getId());
            updatedLeilao = leilaoRepository.save(updatedLeilao);
            return leilaoMapper.leilaoToLeilaoResponseDTO(updatedLeilao);
        }
        return null;
    }

    public void deletar(Long id) {
        leilaoRepository.deleteById(id);
    }

    public LeilaoResponseDTO buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }
}
