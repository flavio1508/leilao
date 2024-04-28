package br.com.analise.leilaoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.analise.leilaoapi.dtos.EmpresaRequestDTO;
import br.com.analise.leilaoapi.dtos.EmpresaResponseDTO;
import br.com.analise.leilaoapi.entity.Empresa;
import br.com.analise.leilaoapi.mappers.EmpresaMapper;
import br.com.analise.leilaoapi.repository.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaMapper empresaMapper;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository, EmpresaMapper empresaMapper) {
        this.empresaRepository = empresaRepository;
        this.empresaMapper = empresaMapper;
    }

    public List<EmpresaResponseDTO> getAllEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        return empresaMapper.empresasParaEmpresaResponseDTOs(empresas);
    }

    public EmpresaResponseDTO getEmpresaById(Long id) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        return empresaOptional.map(empresaMapper::empresaParaEmpresaResponseDTO).orElse(null);
    }

    public EmpresaResponseDTO createEmpresa(EmpresaRequestDTO empresaRequestDTO) {
        Empresa empresa = empresaMapper.empresaRequestParaEmpresa(empresaRequestDTO);
        empresa = empresaRepository.save(empresa);
        return empresaMapper.empresaParaEmpresaResponseDTO(empresa);
    }

    public EmpresaResponseDTO updateEmpresa(Long id, EmpresaRequestDTO empresaRequestDTO) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        if (empresaOptional.isPresent()) {
            Empresa empresa = empresaOptional.get();
            empresaMapper.updateEmpresaFromRequestDTO(empresa, empresaRequestDTO);
            empresa = empresaRepository.save(empresa);
            return empresaMapper.empresaParaEmpresaResponseDTO(empresa);
        }
        return null;
    }

    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
