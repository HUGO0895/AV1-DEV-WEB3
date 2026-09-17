package com.autobots.automanager.DTO.Request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
public class CriarClienteDTo{
    @NotBlank(message = "Nome precisa ter valor")
    private String nome;
    private String nomeSocial;
    @NotNull(message = "Data de nascimento é obrigatória")
    @Past(message = "Data de nascimento deve ser no passado")
    private Date dataNascimento;
   @NotNull(message = "Data de cadastro é obrigatória")
   @Past(message = "Data de cadastro deve ser no passado")
     private Date dataCadastro;
     private List<CriarTelefone> telefones;
     private CriarEnderecoDTO endereco;
     private List<CriarDocumento>  documento;

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

     public List<CriarTelefone> getTelefones() {
         return telefones;
     }

     public void addTelefone(CriarTelefone telefone) {
         this.telefones.add(telefone);
     }

     public void setTelefones(List<CriarTelefone> telefones) {
         this.telefones = telefones;
     }

     public CriarEnderecoDTO getEndereco() {
         return endereco;
     }

     public void setEndereco(CriarEnderecoDTO endereco) {
         this.endereco = endereco;
     }

     public List<CriarDocumento> getDocumento() {
         return documento;
     }

     public void setDocumento(List<CriarDocumento> documento) {
         this.documento = documento;
     }


}
