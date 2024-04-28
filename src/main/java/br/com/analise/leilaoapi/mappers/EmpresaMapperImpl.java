package br.com.analise.leilaoapi.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.analise.leilaoapi.dtos.EmpresaRequestDTO;
import br.com.analise.leilaoapi.dtos.EmpresaResponseDTO;
import br.com.analise.leilaoapi.entity.Empresa;

@Component
public class EmpresaMapperImpl implements EmpresaMapper {
    @Override
    public void updateEmpresaFromRequestDTO(Empresa empresa, EmpresaRequestDTO empresaRequestDTO) {
        empresa.setRazaoSocial(empresaRequestDTO.getRazaoSocial());
        empresa.setCnpj(empresaRequestDTO.getCnpj());
        empresa.setLogradouro(empresaRequestDTO.getLogradouro());
        empresa.setMunicipio(empresaRequestDTO.getMunicipio());
        empresa.setNumero(empresaRequestDTO.getNumero());
        empresa.setComplemento(empresaRequestDTO.getComplemento());
        empresa.setBairro(empresaRequestDTO.getBairro());
        empresa.setCep(empresaRequestDTO.getCep());
        empresa.setTelefone(empresaRequestDTO.getTelefone());
        empresa.setEmail(empresaRequestDTO.getEmail());
        empresa.setSite(empresaRequestDTO.getSite());
        empresa.setUsuario(empresaRequestDTO.getUsuario());
        empresa.setSenha(empresaRequestDTO.getSenha());
    }

    @Override
    public EmpresaResponseDTO empresaParaEmpresaResponseDTO(Empresa empresa) {
        return new EmpresaResponseDTO(
                empresa.getId(),
                empresa.getRazaoSocial(),
                empresa.getCnpj(),
                empresa.getLogradouro(),
                empresa.getMunicipio(),
                empresa.getNumero(),
                empresa.getComplemento(),
                empresa.getBairro(),
                empresa.getCep(),
                empresa.getTelefone(),
                empresa.getEmail(),
                empresa.getSite(),
                empresa.getUsuario());
    }

    @Override
    public Empresa empresaRequestParaEmpresa(EmpresaRequestDTO empresaRequestDTO) {
        return new Empresa(
                empresaRequestDTO.getRazaoSocial(),
                empresaRequestDTO.getCnpj(),
                empresaRequestDTO.getLogradouro(),
                empresaRequestDTO.getMunicipio(),
                empresaRequestDTO.getNumero(),
                empresaRequestDTO.getComplemento(),
                empresaRequestDTO.getBairro(),
                empresaRequestDTO.getCep(),
                empresaRequestDTO.getTelefone(),
                empresaRequestDTO.getEmail(),
                empresaRequestDTO.getSite(),
                empresaRequestDTO.getUsuario(),
                empresaRequestDTO.getSenha());
    }

    @Override
    public List<EmpresaResponseDTO> empresasParaEmpresaResponseDTOs(Collection<Empresa> empresas) {
        List<EmpresaResponseDTO> empresaResponseDTOs = new ArrayList<>();

        for (Empresa empresa : empresas) {
            empresaResponseDTOs.add(empresaParaEmpresaResponseDTO(empresa));
        }

        return empresaResponseDTOs;
    }
}
