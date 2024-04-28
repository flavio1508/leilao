package br.com.analise.leilaoapi.mappers;

import br.com.analise.leilaoapi.dtos.LeilaoRequestDTO;
import br.com.analise.leilaoapi.dtos.LeilaoResponseDTO;
import br.com.analise.leilaoapi.entity.Leilao;

public interface LeilaoMapper {
    Leilao leilaoRequestDTOToLeilao(LeilaoRequestDTO leilaoRequestDTO);

    LeilaoResponseDTO leilaoToLeilaoResponseDTO(Leilao leilao);
}
