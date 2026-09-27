package com.autobots.automanager.controles;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.DTO.Request.CriarEnderecoDTO;
import com.autobots.automanager.DTO.Request.atualizarEndereciDTO;
import com.autobots.automanager.DTO.Response.EnderecoDTO;
import com.autobots.automanager.Mappers.MapperEndereco;
import com.autobots.automanager.Servicos.EnderecoService;

@RestController 
public class EnderecoControle {
    @Autowired 
     private EnderecoService endeServ;

     @Autowired 
     private  MapperEndereco mapperEnde;
     
     @GetMapping("/enderecos")
     public List<EnderecoDTO> listarEnderecos(){
        return endeServ.listarOsEnderecos().stream().map(endereco->mapperEnde.enderecoParaDTO(endereco)).collect(Collectors.toList());

     }
     
     @GetMapping("/enderecos/{id}")
     public EnderecoDTO pegarEndereco(@PathVariable Long id){
         return mapperEnde.enderecoParaDTO(endeServ.acharEnderecoPorId(id));
     }

     @DeleteMapping("/enderecos/{id}")
     public void deletarEndereco(@PathVariable  Long id){
          endeServ.deletarEndereco(id);
     }


     @PostMapping ("/enderecos")
     public void criarEndereco(@RequestBody CriarEnderecoDTO  endereco){
          this.endeServ.criarEndereco(endereco);
     }

     @PutMapping("/enderecos")
     public void atualizarEndereco(@RequestBody atualizarEndereciDTO endereco){
        endeServ.atualizarEndereco(endereco);
     }

     
}
