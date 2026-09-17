package com.autobots.automanager.Mappers;

import org.springframework.stereotype.Component;

import com.autobots.automanager.DTO.Request.CriarEnderecoDTO;
import com.autobots.automanager.DTO.Request.atualizarEndereciDTO;
import com.autobots.automanager.DTO.Response.EnderecoDTO;
import com.autobots.automanager.entidades.Endereco;

@Component 
public class MapperEndereco {
    public Endereco CriarEnderecoDtoParaEndereco(CriarEnderecoDTO enderecoDTO){
        Endereco endereco=new Endereco();
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setCodigoPostal(enderecoDTO.getCodigoPostal());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setInformacoesAdicionais(enderecoDTO.getInformacoesAdicionais());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setRua(enderecoDTO.getRua());
         return endereco;
    }
    
    public void AtualizarEnderecoParaEndereco(atualizarEndereciDTO enderecodDto,Endereco ende){
         if(enderecodDto.getBairro()!=null && !enderecodDto.getBairro().isEmpty())
            ende.setBairro(enderecodDto.getBairro());

         if (enderecodDto.getCidade()!=null && !enderecodDto.getCidade().isEmpty())
            ende.setCidade(enderecodDto.getCidade());

        if(enderecodDto.getCodigoPostal()!=null && !enderecodDto.getCodigoPostal().isEmpty())
            ende.setCodigoPostal(enderecodDto.getCodigoPostal());

        if(enderecodDto.getEstado()!=null &&!enderecodDto.getEstado().isEmpty())
            ende.setEstado(enderecodDto.getEstado());

        if(enderecodDto.getInformacoesAdicionais()!=null && !enderecodDto.getInformacoesAdicionais().isEmpty())
            ende.setInformacoesAdicionais(enderecodDto.getInformacoesAdicionais());

        if (enderecodDto.getNumero()!=null && !enderecodDto.getNumero().isEmpty())
            ende.setNumero(enderecodDto.getNumero());

        if(enderecodDto.getRua()!=null && !enderecodDto.getRua().isEmpty())
            ende.setRua(enderecodDto.getRua());


    }

    public EnderecoDTO enderecoParaDTO(Endereco endereco){
         EnderecoDTO enderecodto=new EnderecoDTO();
        enderecodto.setBairro(endereco.getBairro());
        enderecodto.setCidade(endereco.getCidade());
        enderecodto.setCodigoPostal(endereco.getCodigoPostal());
        enderecodto.setEstado(endereco.getEstado());
        enderecodto.setInformacoesAdicionais(endereco.getInformacoesAdicionais());
        enderecodto.setNumero(endereco.getNumero());
        enderecodto.setRua(endereco.getRua());
        enderecodto.setId(endereco.getId());
         return enderecodto;
    }



}
