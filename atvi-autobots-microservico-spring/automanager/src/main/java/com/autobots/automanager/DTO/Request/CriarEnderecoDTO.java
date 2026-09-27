package com.autobots.automanager.DTO.Request;
import javax.validation.constraints.NotBlank;
public class CriarEnderecoDTO {


    @NotBlank(message = "O estado é obrigatorio")
    private String estado;
    
    @NotBlank(message = "A cidade é obrigatoria")
     private String cidade;
    
    @NotBlank (message = "O bairro é obrigatorio")
     private String bairro;
    
     @NotBlank (message = "A rua é obrigatoria")
     private String rua;
     
     @NotBlank(message="O numero é obrigatorio")
     private String numero;

     @NotBlank(message = "O codigo postal é obrigatorio")
     private String codigoPostal;

     private String informacoesAdicionais;

    


       public String getBairro() {
         return bairro;
     }
     public void setBairro(String bairro) {
         this.bairro = bairro;
     }
     public String getCidade() {
         return cidade;
     }
     public void setCidade(String cidade) {
         this.cidade = cidade;
     }
     public String getCodigoPostal() {
         return codigoPostal;
     }

     public void setCodigoPostal(String codigoPostal) {
         this.codigoPostal = codigoPostal;
     }

     public String getEstado() {
         return estado;
     }

     public void setEstado(String estado) {
         this.estado = estado;
     }

     public String getInformacoesAdicionais() {
         return informacoesAdicionais;
     }

     public void setInformacoesAdicionais(String informacoesAdicionais) {
         this.informacoesAdicionais = informacoesAdicionais;
     }
     public String getNumero() {
         return numero;
     }

     public void setNumero(String numero) {
         this.numero = numero;
     }
     public String getRua() {
         return rua;
     }
     public void setRua(String rua) {
         this.rua = rua;
     }



}
