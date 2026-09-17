package com.autobots.automanager.controles;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.DTO.Request.CriarClienteDTo;
import com.autobots.automanager.DTO.Request.atualizarClienteDTO;
import com.autobots.automanager.DTO.Response.ClienteDTO;
import com.autobots.automanager.Mappers.MapperCliente;
import com.autobots.automanager.Servicos.ClienteService;

@RestController
public class ClienteControle {
	@Autowired
     private  ClienteService servicoCliente;
    
	@Autowired 
	private  MapperCliente mapperCli;
	@GetMapping("/clientes/{id}")
	public ClienteDTO obterCliente(@PathVariable long id) {
		return mapperCli.clienteParaClienteDTO(servicoCliente.acharUmCliente(id));
	}

	@GetMapping("/clientes")
	public List<ClienteDTO> obterClientes() {
		return servicoCliente.listarClientes().stream().map(cliente->mapperCli.clienteParaClienteDTO(cliente)).collect(Collectors.toList());
	}

	@PostMapping("/clientes")
	public void cadastrarCliente(@RequestBody @Valid CriarClienteDTo cliente) {
		servicoCliente.salvarCliente(cliente);
	}

	@PutMapping("/clientes")
	public void atualizarCliente(@RequestBody @Valid atualizarClienteDTO atualizacao) {
		servicoCliente.atualizarCliente(atualizacao);
	}

	@DeleteMapping("/clientes/{id}")
	public void excluirCliente(@PathVariable Long id) {
		servicoCliente.deletarCLiente(id);
	}
}
