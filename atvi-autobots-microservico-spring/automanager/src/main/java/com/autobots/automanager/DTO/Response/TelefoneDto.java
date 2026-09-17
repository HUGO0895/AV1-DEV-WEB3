package com.autobots.automanager.DTO.Response;

public class TelefoneDto {
    private Long id;
    private String ddd;
    private String numero;
    private Long cliente;
    public Long getCliente() {
        return cliente;
    }
    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }
    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
}
