package com.autobots.automanager.DTO.Request;
import java.util.Date;


import javax.validation.constraints.NotNull;
public class atualizarClienteDTO {
    @NotNull (message = "ID é necessario")
    private Long id;
    private String nome;
    private String nomeSocial;
    
    private Date dataNascimento;

     private Date dataCadastro;
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

     public Long getId() {
         return id;
     }

     public void setId(Long id) {
         this.id = id;
     }
     
}
