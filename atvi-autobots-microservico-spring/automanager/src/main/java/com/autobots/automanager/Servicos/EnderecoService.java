package com.autobots.automanager.Servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.DTO.Request.CriarEnderecoDTO;
import com.autobots.automanager.DTO.Request.atualizarEndereciDTO;
import com.autobots.automanager.Mappers.MapperEndereco;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.repositorios.EnderecoRepositorio;

@Service 
public class EnderecoService {
    @Autowired 
    EnderecoRepositorio enderecoRepositorio;

    @Autowired 
    MapperEndereco mapperEnd;
    public List<Endereco> listarOsEnderecos(){
      return enderecoRepositorio.findAll();
    }

    public Endereco acharEnderecoPorId(Long id){
        Endereco ende=enderecoRepositorio.findById(id).get();
        if (ende==null){
        throw new Error("Bixis");
        }
        return ende;
    }

    public void criarEndereco(CriarEnderecoDTO ende){
       Endereco endereco=mapperEnd.CriarEnderecoDtoParaEndereco(ende);
       this.enderecoRepositorio.save(endereco);
    }

    public void deletarEndereco(Long id){
        Endereco ende=enderecoRepositorio.findById(id).get();
        if(ende==null){
            throw new Error("matriz");
        }
        enderecoRepositorio.deleteById(id);
    }

    
    public void atualizarEndereco(atualizarEndereciDTO ende){
        Endereco endereco=enderecoRepositorio.findById(ende.getId()).get();
        mapperEnd.AtualizarEnderecoParaEndereco(ende, endereco);
        this.enderecoRepositorio.save(endereco);
    }



}
