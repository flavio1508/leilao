package br.com.analise.leilaoapi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import br.com.analise.leilaoapi.util.EntidadeBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empresa extends EntidadeBase {

    @Column(nullable = false, length = 64)
    private String razaoSocial;

    @Column(nullable = false, length = 32, unique = true)
    private String cnpj;

    @Column(length = 64)
    private String logradouro;

    @Column(length = 64)
    private String municipio;

    @Column(length = 10)
    private String numero;

    @Column(length = 64)
    private String complemento;

    @Column(length = 64)
    private String bairro;

    @Column(length = 16)
    private String cep;

    @Column(length = 32)
    private String telefone;

    @Email
    @Column(nullable = false, length = 254, unique = true)
    private String email;

    @Column(length = 254)
    private String site;

    @Column(nullable = false, length = 20, unique = true)
    private String usuario;

    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "empresa")
    private List<Comprador> compradores;

    public Empresa(String razaoSocial, String cnpj, String logradouro, String municipio, String numero,
            String complemento, String bairro, String cep, String telefone, String email, String site,
            String usuario, String senha) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.logradouro = logradouro;
        this.municipio = municipio;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
        this.usuario = usuario;
        this.senha = senha;
    }

}
