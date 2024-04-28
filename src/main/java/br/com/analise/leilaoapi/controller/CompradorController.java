package br.com.analise.leilaoapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.analise.leilaoapi.dtos.CompradorRequestDTO;
import br.com.analise.leilaoapi.dtos.CompradorResponseDTO;
import br.com.analise.leilaoapi.service.CompradorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "api/v1/compradores" }, produces = { "application/json" })
public class CompradorController {

    private final CompradorService compradorService;

    @Autowired
    public CompradorController(CompradorService compradorService) {
        this.compradorService = compradorService;
    }

    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<CompradorResponseDTO> cadastrarComprador(
            @RequestBody @Valid CompradorRequestDTO compradorRequestDTO) {
        CompradorResponseDTO compradorSalva = compradorService.criarComprador(compradorRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(compradorSalva);
    }

    @GetMapping
    public ResponseEntity<List<CompradorResponseDTO>> buscarTodosCompradores() {
        List<CompradorResponseDTO> compradores = compradorService.buscarTodosCompradores();
        return ResponseEntity.ok(compradores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompradorResponseDTO> buscarCompradorPorId(@PathVariable Long id) {
        CompradorResponseDTO comprador = compradorService.getCompradorById(id, id);
        if (comprador != null) {
            return ResponseEntity.ok(comprador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompradorResponseDTO> atualizarEmpresa(@PathVariable Long id,
            @RequestBody @Valid CompradorRequestDTO compradorRequestDTO) {
        CompradorResponseDTO compradorAtualizada = compradorService.atualizar(id, compradorRequestDTO);
        if (compradorAtualizada != null) {
            return ResponseEntity.ok(compradorAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarComprador(@PathVariable Long id) {
        compradorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
