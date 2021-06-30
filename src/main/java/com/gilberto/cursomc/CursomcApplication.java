package com.gilberto.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gilberto.cursomc.domain.Categoria;
import com.gilberto.cursomc.domain.Produto;
import com.gilberto.cursomc.repositories.CategoriaRepository;
import com.gilberto.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1=new Categoria(0,"Informática");
		Categoria cat2=new Categoria(0,"Escritorio");
		
		Produto p1 =new Produto(0,"Computador",2000);
		Produto p2 =new Produto(0,"Impressora",800);
		Produto p3 =new Produto(0,"Mouse",80);
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
					
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
	}

}
