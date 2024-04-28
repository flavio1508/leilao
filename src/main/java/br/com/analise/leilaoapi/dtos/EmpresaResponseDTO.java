package br.com.analise.leilaoapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpresaResponseDTO {
    private Integer id;
    private String razaoSocial;
    private String cnpj;
    private String logradouro;
    private String municipio;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String telefone;
    private String email;
    private String site;
    private String usuario;
}
