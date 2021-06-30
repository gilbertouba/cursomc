package com.gilberto.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gilberto.cursomc.domain.Categoria;
import com.gilberto.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
    
	@Autowired	
	private CategoriaService sevico;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity find(@PathVariable Integer id) {
		
		Categoria  cat1 = sevico.buscar(id);
		return ResponseEntity.ok().body(cat1);
		
				
	}
}
