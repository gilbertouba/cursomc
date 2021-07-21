package com.gilberto.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gilberto.cursomc.domain.Pedido;
import com.gilberto.cursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
    
	@Autowired	
	private PedidoService sevico;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity find(@PathVariable Integer id) {
		
		Pedido  cat1 = sevico.buscar(id);
		return ResponseEntity.ok().body(cat1);
		
				
	}
}
