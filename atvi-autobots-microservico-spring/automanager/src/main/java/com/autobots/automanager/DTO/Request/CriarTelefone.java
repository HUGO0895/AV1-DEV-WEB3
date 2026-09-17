package com.autobots.automanager.DTO.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CriarTelefone {
    @NotBlank(message = "ddd é obrigatorio")
    private String ddd;
    @NotBlank(message = "numero é obrigatorio")
    private String numero;
    @NotNull (message="cliente_id é obrigatorio")
    private Long cliente_id;

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }
    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

}
