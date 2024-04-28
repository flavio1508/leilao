package br.com.analise.leilaoapi.mappers;

import org.springframework.stereotype.Component;

import br.com.analise.leilaoapi.dtos.LeilaoRequestDTO;
import br.com.analise.leilaoapi.dtos.LeilaoResponseDTO;
import br.com.analise.leilaoapi.entity.Leilao;

@Component
public class LeilaoMapperImpl implements LeilaoMapper {
    @Override
    public Leilao leilaoRequestDTOToLeilao(LeilaoRequestDTO leilaoRequestDTO) {
        Leilao leilao = new Leilao();
        leilao.setDescricao(leilaoRequestDTO.getDescricao());
        return leilao;
    }

    @Override
    public LeilaoResponseDTO leilaoToLeilaoResponseDTO(Leilao leilao) {
        LeilaoResponseDTO responseDTO = new LeilaoResponseDTO();
        responseDTO.setId(leilao.getId());
        responseDTO.setDescricao(leilao.getDescricao());
        return responseDTO;
    }
}
