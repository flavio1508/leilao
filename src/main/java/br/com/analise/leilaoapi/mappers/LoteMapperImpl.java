package br.com.analise.leilaoapi.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.analise.leilaoapi.dtos.LoteRequestDTO;
import br.com.analise.leilaoapi.dtos.LoteResponseDTO;
import br.com.analise.leilaoapi.entity.Lote;

@Component
public class LoteMapperImpl implements LoteMapper {
    @Override
    public LoteResponseDTO loteParaLoteResponseDTO(Lote lote) {
        return new LoteResponseDTO(
                lote.getId(),
                lote.getNumeroLote(),
                lote.getDescricao(),
                lote.getQuantidade(),
                lote.getValorInicial(),
                lote.getUnidade(),
                lote.getLeilao().getId());
    }

    @Override
    public Lote loteRequestDTOParaLote(LoteRequestDTO loteRequestDTO) {
        Lote lote = new Lote();
        lote.setNumeroLote(loteRequestDTO.getNumeroLote());
        lote.setDescricao(loteRequestDTO.getDescricao());
        lote.setQuantidade(loteRequestDTO.getQuantidade());
        lote.setValorInicial(loteRequestDTO.getValorInicial());
        lote.setUnidade(loteRequestDTO.getUnidade());
        return lote;
    }

    @Override
    public List<LoteResponseDTO> lotesParaLoteResponseDTOs(List<Lote> lotes) {
        List<LoteResponseDTO> loteResponseDTOs = new ArrayList<>();
        for (Lote lote : lotes) {
            loteResponseDTOs.add(loteParaLoteResponseDTO(lote));
        }
        return loteResponseDTOs;
    }
}
