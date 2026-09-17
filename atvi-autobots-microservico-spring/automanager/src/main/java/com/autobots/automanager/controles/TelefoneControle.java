package com.autobots.automanager.controles;

import java.util.stream.Collectors;

import javax.validation.Valid;

import java.util.List;
import com.autobots.automanager.DTO.Request.atualizarTelefone;
import com.autobots.automanager.DTO.Request.CriarTelefone;
import com.autobots.automanager.DTO.Response.TelefoneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.Mappers.MapperTelefone;
import com.autobots.automanager.Servicos.TelefoneService;

@RestController 
public class TelefoneControle {
    @Autowired 
    TelefoneService telServ;

    @Autowired 
    MapperTelefone mapperTel;

    @GetMapping("/telefones")
   public List<TelefoneDto> obterTelefones() {
        return  telServ.listarTelefones().stream().map(tel-> mapperTel.TelefoneParaTelefoneDTO(tel)).collect(Collectors.toList());
    }
    

    @GetMapping("/telefones/{id}")
    public TelefoneDto obterTelefone(@PathVariable Long id){
        return mapperTel.TelefoneParaTelefoneDTO(telServ.acharUmTelefone(id));
    }

    @PostMapping("/telefones")
    public void criarTelefone(@RequestBody  @Valid CriarTelefone telefone){
         telServ.criarTelefone(telefone);
    }

    @PutMapping("/telefones")
    public void atualizarTelefone(@RequestBody @Valid atualizarTelefone tel){
        telServ.atualizarTelefone(tel);
    }

    @DeleteMapping("/telefones/{id}")
    public void deletarTelefone(@PathVariable Long id ){
       telServ.deletarTelefone(id);
    }


}
