package com.autobots.automanager.Servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.DTO.Request.CriarClienteDTo;
import com.autobots.automanager.DTO.Request.atualizarClienteDTO;
import com.autobots.automanager.Mappers.MapperCliente;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.exceptions.tipos.NaoexistenoBanco;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@Service 
public class ClienteService {
    @Autowired 
    private ClienteRepositorio repositorio;

    @Autowired 
    private MapperCliente mapperCliente;

    public List<Cliente> listarClientes(){
        return this.repositorio.findAll();
    }

    public Cliente acharUmCliente(Long id){
        Cliente cli=this.repositorio.findById(id).orElseThrow(()->new NaoexistenoBanco("Erro ao procurar Cliente", "Elemento não existe"));
      
          return cli;
    }

    public void salvarCliente(CriarClienteDTo cliente){
        this.repositorio.save(mapperCliente.CriarClienteDTOParaCLiente(cliente));
    }

    public void atualizarCliente(atualizarClienteDTO cliente){
        Cliente cli=this.repositorio.findById(cliente.getId()).orElseThrow(()->new NaoexistenoBanco("Erro ao atualizar Cliente", "Elemento não existe"));
        
        mapperCliente.AtualizarClienteDTOParaCLiente(cliente,cli);
        this.repositorio.save(cli);
        
        
    }

    public void deletarCLiente(Long id){
        Cliente cli=this.repositorio.findById(id).orElseThrow(()->new NaoexistenoBanco("Erro ao deletar Cliente", "Elemento não existe"));
        this.repositorio.deleteById(id);
    }
}
