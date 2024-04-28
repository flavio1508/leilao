package br.com.analise.leilaoapi.mappers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.analise.leilaoapi.dtos.CompradorRequestDTO;
import br.com.analise.leilaoapi.dtos.CompradorResponseDTO;
import br.com.analise.leilaoapi.entity.Comprador;

@Component
public class CompradorMapperImpl implements CompradorMapper {
    @Override
    public CompradorResponseDTO compradorParaCompradorResponseDTO(Comprador comprador) {
        return new CompradorResponseDTO(
                comprador.getId().getEmpresaId(),
                comprador.getId().getLeilaoId());
    }

    @Override
    public Comprador compradorRequestDTOToComprador(CompradorRequestDTO compradorRequestDTO) {
        Comprador comprador = new Comprador();
        comprador.getId().setEmpresaId(compradorRequestDTO.getEmpresaId());
        comprador.getId().setLeilaoId(compradorRequestDTO.getLeilaoId());
        return comprador;
    }

    @Override
    public List<CompradorResponseDTO> compradorParaCompradorResponseDTOs(Collection<Comprador> compradores) {
        return compradores.stream()
                .map(this::compradorParaCompradorResponseDTO)
                .collect(Collectors.toList());
    }
}
