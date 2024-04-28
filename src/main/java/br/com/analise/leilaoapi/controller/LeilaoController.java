package br.com.analise.leilaoapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.analise.leilaoapi.dtos.LeilaoRequestDTO;
import br.com.analise.leilaoapi.dtos.LeilaoResponseDTO;
import br.com.analise.leilaoapi.service.LeilaoService;

@RestController
@RequestMapping("/leiloes")
public class LeilaoController {
    private final LeilaoService leilaoService;

    @Autowired
    public LeilaoController(LeilaoService leilaoService) {
        this.leilaoService = leilaoService;
    }

    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<LeilaoResponseDTO> criarLeilao(@RequestBody @Valid LeilaoRequestDTO leilaoRequestDTO) {
        LeilaoResponseDTO leilaoResponseDTO = leilaoService.criar(leilaoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(leilaoResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeilaoResponseDTO> buscarLeilaoPorId(@PathVariable Long id) {
        LeilaoResponseDTO leilao = leilaoService.buscarPorId(id);
        if (leilao != null) {
            return ResponseEntity.ok(leilao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeilaoResponseDTO> atualizarLeilao(@PathVariable Long id,
            @RequestBody @Valid LeilaoRequestDTO leilaoRequestDTO) {
        LeilaoResponseDTO leilao = leilaoService.atualizar(id, leilaoRequestDTO);
        if (leilao != null) {
            return ResponseEntity.ok(leilao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLeilao(@PathVariable Long id) {
        leilaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
