package com.autobots.automanager.Mappers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autobots.automanager.DTO.Request.CriarClienteDTo;
import com.autobots.automanager.DTO.Request.atualizarClienteDTO;
import com.autobots.automanager.DTO.Response.ClienteDTO;
import com.autobots.automanager.entidades.Cliente;

@Component 
public class MapperCliente {
    @Autowired 
    MapperTelefone mapperTel;
    @Autowired 
    MapperEndereco mapperEnd;

    @Autowired 
    MapperDicumento mapperDoc;
    public Cliente CriarClienteDTOParaCLiente(CriarClienteDTo clientedto){
        Cliente cliente=new Cliente();
        cliente.setNome(clientedto.getNome());
        cliente.setDataCadastro(clientedto.getDataCadastro());
        cliente.setDataNascimento(clientedto.getDataNascimento());
        cliente.setNomeSocial(clientedto.getNomeSocial());
        
        if(clientedto.getTelefones()!=null){
        cliente.setTelefones(clientedto.getTelefones().stream().map(t->mapperTel.CriarTelefoneParaTelefone(t)).collect(Collectors.toList()));
        cliente.setTelefones(cliente.getTelefones().stream().map(tel->{tel.setCliente(cliente);return tel;}).collect(Collectors.toList()));
        }
        if(clientedto.getDocumento()!=null)
        cliente.setEndereco(mapperEnd.CriarEnderecoDtoParaEndereco(clientedto.getEndereco()));

        if(clientedto.getDocumento()!=null){
        cliente.setDocumentos(clientedto.getDocumento().stream().map(doc->mapperDoc.criarDtoParaDocumento(doc)).collect(Collectors.toList()));
        cliente.setDocumentos(cliente.getDocumentos().stream().map(doc->{doc.setCliente(cliente); return doc;}).collect(Collectors.toList()));
        }

        return cliente;

    }
   

     public void AtualizarClienteDTOParaCLiente(atualizarClienteDTO clientedto,Cliente cliente){
        if(clientedto.getNome()!=null && !clientedto.getNome().isEmpty())
        cliente.setNome(clientedto.getNome());
         if(clientedto.getDataCadastro()!=null && !clientedto.getDataCadastro().toString().isEmpty())
        cliente.setDataCadastro(clientedto.getDataCadastro());
     if(clientedto.getDataNascimento()!=null && !clientedto.getDataNascimento().toString().isEmpty())
        cliente.setDataNascimento(clientedto.getDataNascimento());
     if(clientedto.getNomeSocial()!=null && !clientedto.getNomeSocial().isEmpty())
        cliente.setNomeSocial(clientedto.getNomeSocial());
        cliente.setId(clientedto.getId());

    }


    public ClienteDTO clienteParaClienteDTO(Cliente cliente){
          ClienteDTO clienteDto=new ClienteDTO();
          clienteDto.setId(cliente.getId());
          clienteDto.setNome(cliente.getNome());
          clienteDto.setNomeSocial(cliente.getNomeSocial());
          clienteDto.setDataCadastro(cliente.getDataCadastro());
          clienteDto.setDataNascimento(cliente.getDataNascimento());
          if(cliente.getTelefones()!=null)
          clienteDto.setTelefones(cliente.getTelefones().stream().map(t->mapperTel.TelefoneParaTelefoneDTO(t)).collect(Collectors.toList()));
          clienteDto.setEndereco(mapperEnd.enderecoParaDTO(cliente.getEndereco()));
          if(cliente.getDocumentos()!=null)
          clienteDto.setDocumento(cliente.getDocumentos().stream().map(doc->mapperDoc.DocumentoParaDTo(doc)).collect(Collectors.toList()));

          return clienteDto;
    }




}
