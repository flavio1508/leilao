package br.com.analise.leilaoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.analise.leilaoapi.dtos.LoteRequestDTO;
import br.com.analise.leilaoapi.dtos.LoteResponseDTO;
import br.com.analise.leilaoapi.service.LoteService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/lotes")
public class LoteController {

    private final LoteService loteService;

    @Autowired
    public LoteController(LoteService loteService) {
        this.loteService = loteService;
    }

    @GetMapping
    public ResponseEntity<List<LoteResponseDTO>> buscarTodosLotes() {
        List<LoteResponseDTO> lotes = loteService.buscarTodosLotes();
        return ResponseEntity.ok(lotes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoteResponseDTO> buscarLoteById(@PathVariable Long id) {
        LoteResponseDTO lote = loteService.buscarLoteById(id);
        if (lote != null) {
            return ResponseEntity.ok(lote);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<LoteResponseDTO> criarLote(@RequestBody LoteRequestDTO loteRequestDTO) {
        LoteResponseDTO createdLote = loteService.criarteLote(loteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoteResponseDTO> atualizarLote(
            @PathVariable Long id, @RequestBody LoteRequestDTO loteRequestDTO) {
        LoteResponseDTO updatedLote = loteService.atualizarLote(id, loteRequestDTO);
        if (updatedLote != null) {
            return ResponseEntity.ok(updatedLote);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLote(@PathVariable Long id) {
        loteService.deleteLote(id);
        return ResponseEntity.noContent().build();
    }
}
