package com.autobots.automanager.DTO.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CriarDocumento {
    @NotBlank(message = "tipo precisa existir")
    private String tipo;

    @NotBlank (message = "numero precisa existir")
    private String numero;
    
    @NotNull(message = "O id do cliente precisa existir")
    private Long cliente;

    public Long getCliente() {
        return cliente;
    } 
    public String getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
