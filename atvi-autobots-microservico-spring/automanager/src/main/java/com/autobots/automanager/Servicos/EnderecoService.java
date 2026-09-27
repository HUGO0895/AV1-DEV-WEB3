package com.autobots.automanager.Servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.DTO.Request.CriarEnderecoDTO;
import com.autobots.automanager.DTO.Request.atualizarEndereciDTO;
import com.autobots.automanager.Mappers.MapperEndereco;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.exceptions.tipos.NaoexistenoBanco;
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
          Endereco ende=enderecoRepositorio.findById(id).orElseThrow(()->new NaoexistenoBanco("Erro ao procurar Endereco", "Elemento não existe"));
        return ende;
    }

    public void criarEndereco(CriarEnderecoDTO ende){
       Endereco endereco=mapperEnd.CriarEnderecoDtoParaEndereco(ende);
       this.enderecoRepositorio.save(endereco);
    }

    public void deletarEndereco(Long id){
         Endereco ende=enderecoRepositorio.findById(id).orElseThrow(()->new NaoexistenoBanco("Erro ao deletar Endereco", "Elemento não existe"));
        enderecoRepositorio.deleteById(id);
    }

    
    public void atualizarEndereco(atualizarEndereciDTO ende){
         Endereco endereco=enderecoRepositorio.findById(ende.getId()).orElseThrow(()->new NaoexistenoBanco("Erro ao atualizar Endereco", "Elemento não existe"));
        mapperEnd.AtualizarEnderecoParaEndereco(ende, endereco);
        this.enderecoRepositorio.save(endereco);
    }



}
