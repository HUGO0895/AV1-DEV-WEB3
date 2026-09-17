package com.autobots.automanager.DTO.Request;

import javax.validation.constraints.NotNull;

public class atualizarTelefone {
     private String ddd;
    private String numero;
    @NotNull(message = "id precisa existir")
    private Long id;

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

