package br.com.analise.leilaoapi.mappers;

import org.springframework.stereotype.Component;

import br.com.analise.leilaoapi.dtos.UnidadeRequestDTO;
import br.com.analise.leilaoapi.dtos.UnidadeResponseDTO;
import br.com.analise.leilaoapi.entity.Unidade;

@Component
public class UnidadeMapperImpl {
    public Unidade unidadeRequestDTOToUnidade(UnidadeRequestDTO unidadeRequestDTO) {
        Unidade unidade = new Unidade();
        unidade.setNome(unidadeRequestDTO.getNome());
        return unidade;
    }

    public UnidadeResponseDTO unidadeToUnidadeResponseDTO(Unidade unidade) {
        UnidadeResponseDTO responseDTO = new UnidadeResponseDTO();
        responseDTO.setId(unidade.getId());
        responseDTO.setNome(unidade.getNome());
        return responseDTO;
    }
}
