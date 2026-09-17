package com.autobots.automanager.exceptions.tipos;

public class NaoexistenoBanco extends RuntimeException {
    private  String mensagem;

    public  NaoexistenoBanco(String titulo,String mensagem){
        super(titulo);
        this.mensagem=mensagem;
    }
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
