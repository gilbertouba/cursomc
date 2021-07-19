package com.gilberto.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilberto.cursomc.domain.Cliente;
import com.gilberto.cursomc.repositories.ClienteRepository;
import com.gilberto.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		
		 Optional<Cliente> obj = repo.findById(id);

		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + Cliente.class.getName()));

		
	}

}
