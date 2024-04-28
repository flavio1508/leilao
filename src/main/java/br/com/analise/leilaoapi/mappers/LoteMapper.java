package br.com.analise.leilaoapi.mappers;

import java.util.List;



import br.com.analise.leilaoapi.dtos.LoteRequestDTO;
import br.com.analise.leilaoapi.dtos.LoteResponseDTO;
import br.com.analise.leilaoapi.entity.Lote;

public interface LoteMapper {
    LoteResponseDTO loteParaLoteResponseDTO(Lote lote);

    Lote loteRequestDTOParaLote(LoteRequestDTO loteRequestDTO);

    List<LoteResponseDTO> lotesParaLoteResponseDTOs(List<Lote> lotes);

}
