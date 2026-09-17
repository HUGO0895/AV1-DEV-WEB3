package com.autobots.automanager.Mappers;

import org.springframework.stereotype.Component;

import com.autobots.automanager.DTO.Request.CriarTelefone;
import com.autobots.automanager.DTO.Request.atualizarTelefone;
import com.autobots.automanager.DTO.Response.TelefoneDto;
import com.autobots.automanager.entidades.Telefone;

@Component 
public class MapperTelefone {
    public Telefone  CriarTelefoneParaTelefone(CriarTelefone telefone){
         Telefone tel=new Telefone();
         tel.setDdd(telefone.getDdd());
         tel.setNumero(telefone.getNumero());
         return tel;
    }

    public void AtualizarTelefoneParaTelefone(atualizarTelefone telefone,Telefone tel){
         if(telefone.getDdd()!=null && !telefone.getDdd().isEmpty()){
            tel.setDdd(telefone.getDdd());
        }
         if(telefone.getNumero()!=null && !telefone.getNumero().isEmpty()){

         tel.setNumero(telefone.getNumero());
         }
    }

    public TelefoneDto TelefoneParaTelefoneDTO(Telefone tel){
            TelefoneDto telefone=new TelefoneDto();
            if(tel.getCliente()!=null)
            telefone.setCliente(tel.getCliente().getId());
            telefone.setDdd(tel.getDdd());
            telefone.setId(tel.getId());
            telefone.setNumero(tel.getNumero());
            return telefone;

    }

    
}
