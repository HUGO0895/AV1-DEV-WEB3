package com.autobots.automanager.DTO.Request;

import javax.validation.constraints.NotNull;

public class atualizarDocumento {
    @NotNull(message = "Id precisa existir")
    private Long id;

    private String tipo;


    private String numero;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
