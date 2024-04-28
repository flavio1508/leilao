package br.com.analise.leilaoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.analise.leilaoapi.dtos.UnidadeResponseDTO;
import br.com.analise.leilaoapi.service.UnidadeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "/api/v1/unidades" }, produces = { "application/json" })
public class UnidadeController {
    private final UnidadeService unidadeService;

    @Autowired
    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @GetMapping
    public ResponseEntity <List> buscarTodasUnidades() {
        List <List> unidades = unidadeService.buscarTodasUnidades();
        return ResponseEntity.ok(unidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeResponseDTO> buscarUnidadePorId(@PathVariable Long id) {
        UnidadeResponseDTO unidade = unidadeService.buscarUnidadePorId(id);
        if (unidade != null) {
            return ResponseEntity.ok(unidade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
