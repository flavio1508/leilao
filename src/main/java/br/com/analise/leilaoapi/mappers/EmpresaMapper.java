package br.com.analise.leilaoapi.mappers;

import java.util.Collection;
import java.util.List;

import br.com.analise.leilaoapi.dtos.EmpresaRequestDTO;
import br.com.analise.leilaoapi.dtos.EmpresaResponseDTO;
import br.com.analise.leilaoapi.entity.Empresa;

public interface EmpresaMapper {
    EmpresaResponseDTO empresaParaEmpresaResponseDTO(Empresa empresa);

    Empresa empresaRequestParaEmpresa(EmpresaRequestDTO empresaRequestDTO);

    void updateEmpresaFromRequestDTO(Empresa empresa, EmpresaRequestDTO empresaRequestDTO);

    List<EmpresaResponseDTO> empresasParaEmpresaResponseDTOs(Collection<Empresa> empresas);
}
