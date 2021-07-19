package com.gilberto.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gilberto.cursomc.domain.Cliente;
import com.gilberto.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
    
	@Autowired	
	private ClienteService sevico;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity find(@PathVariable Integer id) {
		
		Cliente  cli1 = sevico.buscar(id);
		return ResponseEntity.ok().body(cli1);
		
				
	}
}
