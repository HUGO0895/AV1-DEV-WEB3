package com.autobots.automanager.DTO.Response;

import java.util.Date;
import java.util.List;

public class ClienteDTO {
     private Long id ;
     private String nome;
     private String nomeSocial;
     private Date dataNascimento;
     private Date dataCadastro;
     private List<TelefoneDto> telefones;
     private EnderecoDTO endereco;
     private List<DocumentoDtO> documento;

     public Date getDataCadastro() {
         return dataCadastro;
     }
     public void setDataCadastro(Date dataCadastro) {
         this.dataCadastro = dataCadastro;
     }
     public Date getDataNascimento() {
         return dataNascimento;
     }
     public void setDataNascimento(Date dataNascimento) {
         this.dataNascimento = dataNascimento;
     }
     public Long getId() {
         return id;
     }

     public void setId(Long id) {
         this.id = id;
     }

     public String getNome() {
         return nome;
     }

     public void setNome(String nome) {
         this.nome = nome;
     }

     public String getNomeSocial() {
         return nomeSocial;
     }

     public void setNomeSocial(String nomeSocial) {
         this.nomeSocial = nomeSocial;
     }

     public List<TelefoneDto> getTelefones() {
         return telefones;
     }


     public void setTelefones(List<TelefoneDto> telefones) {
         this.telefones = telefones;
     }
  

     public EnderecoDTO getEndereco() {
         return endereco;
     }

     public void setEndereco(EnderecoDTO endereco) {
         this.endereco = endereco;
     }
     
     public List<DocumentoDtO> getDocumento() {
         return documento;
     }

     public void setDocumento(List<DocumentoDtO> documento) {
         this.documento = documento;
     }


     
}
