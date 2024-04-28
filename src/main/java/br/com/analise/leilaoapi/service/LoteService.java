package br.com.analise.leilaoapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.analise.leilaoapi.dtos.LoteRequestDTO;
import br.com.analise.leilaoapi.dtos.LoteResponseDTO;
import br.com.analise.leilaoapi.entity.Lote;
import br.com.analise.leilaoapi.mappers.LoteMapper;
import br.com.analise.leilaoapi.repository.LoteRepository;

@Service
public class LoteService {

    @Autowired
    private LoteRepository loteRepository;

    @Autowired
    private LoteMapper loteMapper;

    public LoteService(LoteRepository loteRepository, LoteMapper loteMapper) {
        this.loteRepository = loteRepository;
        this.loteMapper = loteMapper;
    }

    public List<LoteResponseDTO> buscarTodosLotes() {
        Iterable<Lote> lotes = loteRepository.findAll();
        return loteMapper.lotesParaLoteResponseDTOs(convertIterableToList(lotes));
    }

    private List<Lote> convertIterableToList(Iterable<Lote> iterable) {
        List<Lote> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    public LoteResponseDTO atualizarLote(Long id, LoteRequestDTO loteRequestDTO) {
        Lote existingLote = loteRepository.findById(id).orElse(null);
        if (existingLote != null) {
            Lote updatedLote = loteMapper.loteRequestDTOParaLote(loteRequestDTO);
            updatedLote.setId(existingLote.getId());
            updatedLote = loteRepository.save(updatedLote);
            return loteMapper.loteParaLoteResponseDTO(updatedLote);
        }
        return null;
    }

    public LoteResponseDTO buscarLoteById(Long id) {
        Lote lote = loteRepository.findById(id).orElse(null);
        if (lote != null) {
            return loteMapper.loteParaLoteResponseDTO(lote);
        }
        return null;
    }

    public LoteResponseDTO criarteLote(LoteRequestDTO loteRequestDTO) {
        Lote lote = loteMapper.loteRequestDTOParaLote(loteRequestDTO);
        lote = loteRepository.save(lote);
        return loteMapper.loteParaLoteResponseDTO(lote);
    }

    public void deleteLote(Long id) {
        loteRepository.deleteById(id);
    }
}
