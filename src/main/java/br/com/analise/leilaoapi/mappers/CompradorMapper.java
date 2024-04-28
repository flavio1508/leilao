package br.com.analise.leilaoapi.mappers;

import java.util.Collection;
import java.util.List;

import br.com.analise.leilaoapi.dtos.CompradorRequestDTO;
import br.com.analise.leilaoapi.dtos.CompradorResponseDTO;
import br.com.analise.leilaoapi.entity.Comprador;

public interface CompradorMapper {
    CompradorResponseDTO compradorParaCompradorResponseDTO(Comprador comprador);

    Comprador compradorRequestDTOToComprador(CompradorRequestDTO compradorRequestDTO);

    List<CompradorResponseDTO> compradorParaCompradorResponseDTOs(Collection<Comprador> compradores);

}
