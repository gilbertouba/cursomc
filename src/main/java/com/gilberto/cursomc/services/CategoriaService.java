package com.gilberto.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilberto.cursomc.domain.Categoria;
import com.gilberto.cursomc.repositories.CategoriaRepository;
import com.gilberto.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		
		 Optional<Categoria> obj = repo.findById(id);

		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + Categoria.class.getName()));

		
	}

}
