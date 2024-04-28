package br.com.analise.leilaoapi.mappers;

import br.com.analise.leilaoapi.dtos.UnidadeRequestDTO;
import br.com.analise.leilaoapi.dtos.UnidadeResponseDTO;
import br.com.analise.leilaoapi.entity.Unidade;

public interface UnidadeMapper {

    Unidade unidadeRequestDTOToUnidade(UnidadeRequestDTO unidadeRequestDTO);

    UnidadeResponseDTO unidadeToUnidadeResponseDTO(Unidade unidade);
}
