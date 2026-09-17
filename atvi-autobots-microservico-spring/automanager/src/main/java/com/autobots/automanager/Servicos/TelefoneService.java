package com.autobots.automanager.Servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.DTO.Request.atualizarTelefone;
import com.autobots.automanager.DTO.Request.CriarTelefone;
import com.autobots.automanager.Mappers.MapperTelefone;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.repositorios.TelefoneRepositorio;
@Service 
public class TelefoneService {
    @Autowired 
     private TelefoneRepositorio repositorio;
     @Autowired 
     private MapperTelefone mapperTelefone;

     @Autowired 
     private ClienteService cliServ;

     public List<Telefone> listarTelefones(){
        List<Telefone> telefones=repositorio.findAll();
        return  telefones;
     }

     public Telefone acharUmTelefone(Long id){
         Telefone tel=repositorio.findById(id).get();
         if(tel==null){
            throw new Error("Salve mito");
         }
         return tel;
     }

     public void criarTelefone(CriarTelefone tel){
        Cliente cliente=cliServ.acharUmCliente(tel.getCliente_id());
        System.out.println(cliente);
        Telefone telefone=mapperTelefone.CriarTelefoneParaTelefone(tel);
        telefone.setCliente(cliente);
        repositorio.save(telefone);
     }
    
     public void atualizarTelefone(atualizarTelefone tel){
            Telefone telefone=acharUmTelefone(tel.getId());
            mapperTelefone.AtualizarTelefoneParaTelefone(tel, telefone);
            repositorio.save(telefone);
     }

     public void deletarTelefone(Long id){
        Telefone tel= repositorio.findById(id).get();
        if (tel==null){
         throw new Error();
        }
        repositorio.delete(tel);
     }

}
