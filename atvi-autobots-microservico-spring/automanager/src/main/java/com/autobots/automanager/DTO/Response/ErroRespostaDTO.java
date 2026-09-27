package com.autobots.automanager.DTO.Response;

public class ErroRespostaDTO {
    private String titulo;
    private String message;
   


    public ErroRespostaDTO(String titulo,String message){
        this.message=message;
        this.titulo=titulo;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
