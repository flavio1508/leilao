package br.com.analise.leilaoapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.analise.leilaoapi.dtos.CompradorRequestDTO;
import br.com.analise.leilaoapi.dtos.CompradorResponseDTO;
import br.com.analise.leilaoapi.entity.Comprador;
import br.com.analise.leilaoapi.entity.CompradorId;
import br.com.analise.leilaoapi.mappers.CompradorMapper;
import br.com.analise.leilaoapi.repository.CompradorRepository;

@Service
public class CompradorService {

    @Autowired
    private CompradorRepository compradorRepository;

    @Autowired
    private CompradorMapper compradorMapper;

    @Autowired
    public CompradorService(CompradorRepository compradorRepository, CompradorMapper compradorMapper) {
        this.compradorRepository = compradorRepository;
        this.compradorMapper = compradorMapper;
    }

    public List<CompradorResponseDTO> buscarTodosCompradores() {
        Iterable<Comprador> compradores = compradorRepository.findAll();
        return StreamSupport.stream(compradores.spliterator(), false)
                .map(compradorMapper::compradorParaCompradorResponseDTO)
                .collect(Collectors.toList());
    }

    public CompradorResponseDTO getCompradorById(Long id, Long id2) {
        Optional<Comprador> comprador = compradorRepository.findById(new CompradorId());
        return comprador.map(compradorMapper::compradorParaCompradorResponseDTO).orElse(null);
    }

    public CompradorResponseDTO criarComprador(CompradorRequestDTO compradorRequestDTO) {
        Comprador comprador = compradorMapper.compradorRequestDTOToComprador(compradorRequestDTO);
        Comprador savedComprador = compradorRepository.save(comprador);
        return compradorMapper.compradorParaCompradorResponseDTO(savedComprador);
    }

    public CompradorResponseDTO atualizar(Long Id, @Valid CompradorRequestDTO compradorRequestDTO) {
        Comprador existingComprador = (Comprador) compradorRepository.findAll();
        if (existingComprador != null) {
            Comprador updatedComprador = compradorMapper.compradorRequestDTOToComprador(compradorRequestDTO);
            updatedComprador.setId(existingComprador.getId());
            updatedComprador = compradorRepository.save(updatedComprador);
            return compradorMapper.compradorParaCompradorResponseDTO(updatedComprador);
        }
        return null;
    }

    public void deletar(Long id) {
        compradorRepository.deleteById(new CompradorId());
    }

}
