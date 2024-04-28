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

import br.com.analise.leilaoapi.dtos.EmpresaRequestDTO;
import br.com.analise.leilaoapi.dtos.EmpresaResponseDTO;
import br.com.analise.leilaoapi.service.EmpresaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "api/v1/empresas" }, produces = { "application/json" })
public class EmpresaController {
    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<EmpresaResponseDTO> cadastrarEmpresa(
            @RequestBody @Valid EmpresaRequestDTO empresaRequestDTO) {
        EmpresaResponseDTO empresaResponseDTO = empresaService.createEmpresa(empresaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponseDTO>> buscarTodasEmpresas() {
        List<EmpresaResponseDTO> empresas = empresaService.getAllEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponseDTO> buscarEmpresaPorId(@PathVariable Long id) {
        EmpresaResponseDTO empresa = empresaService.getEmpresaById(id);
        return ResponseEntity.ok(empresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaResponseDTO> atualizarEmpresa(@PathVariable Long id,
            @RequestBody @Valid EmpresaRequestDTO empresaRequestDTO) {
        EmpresaResponseDTO empresa = empresaService.updateEmpresa(id, empresaRequestDTO);
        if (empresa != null) {
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id) {
        empresaService.deleteEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
