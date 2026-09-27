package com.autobots.automanager.DTO.Response;

public class EnderecoDTO {
 
    private Long id;

    private String estado;
    

     private String cidade;
    
   
     private String bairro;
   
     private String rua;
     
  
     private String numero;

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

     public Long getId() {
         return id;
     }

     public void setId(Long id) {
         this.id = id;
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