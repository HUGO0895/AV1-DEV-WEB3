package com.autobots.automanager.DTO.Response;

public class DocumentoDtO {
    private Long id;

    private String tipo;

    private String numero;

    private Long cliente_id;

    public String getNumero() {
        return numero;
    } 

    public void setCliente(Long cliente) {
        this.cliente_id = cliente;
    }

    public Long getCliente() {
        return cliente_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
