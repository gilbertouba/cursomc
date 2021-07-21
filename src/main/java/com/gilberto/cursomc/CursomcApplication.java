package com.gilberto.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gilberto.cursomc.domain.Categoria;
import com.gilberto.cursomc.domain.Cidade;
import com.gilberto.cursomc.domain.Cliente;
import com.gilberto.cursomc.domain.Endereco;
import com.gilberto.cursomc.domain.Estado;
import com.gilberto.cursomc.domain.ItemPedido;
import com.gilberto.cursomc.domain.Pagamento;
import com.gilberto.cursomc.domain.PagamentoComBoleto;
import com.gilberto.cursomc.domain.PagamentoComCartao;
import com.gilberto.cursomc.domain.Pedido;
import com.gilberto.cursomc.domain.Produto;
import com.gilberto.cursomc.domain.enums.EstadoPagamento;
import com.gilberto.cursomc.domain.enums.TipoCliente;
import com.gilberto.cursomc.repositories.CategoriaRepository;
import com.gilberto.cursomc.repositories.CidadeRepository;
import com.gilberto.cursomc.repositories.ClienteRepository;
import com.gilberto.cursomc.repositories.EnderecoRepository;
import com.gilberto.cursomc.repositories.EstadoRepository;
import com.gilberto.cursomc.repositories.ItemPedidoRepository;
import com.gilberto.cursomc.repositories.PagamentoRepository;
import com.gilberto.cursomc.repositories.PedidoRepository;
import com.gilberto.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository ItemPedidoRepository;

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
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade cid1 = new Cidade(null,"Uberlândia",est1);
		Cidade cid2 = new Cidade(null,"São Paulo",est2);
		Cidade cid3 = new Cidade(null,"Campinas",est2);
		
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2,cid3));		
		
		Cliente cli1 = new Cliente(null,"Gilberto","gilbertouba@gmail.com","04008220674",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("991544824","33130015"));
		
		Endereco e1 = new Endereco(null, "Rua Nair borges bento","504" ,"-", "Manuel Mendes", "38082167", cli1, cid1);
		
		Endereco e2 = new Endereco(null, "Rua Nair borges bento2","5041" ,"-", "Manuel Mendes2", "38082168", cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		//public Pedido(Integer id, Date instace, Cliente cliente, Endereco enderecoDeEntrega, Pagamento pagamento) {
	    
		 Pedido ped1 = new Pedido(null,sdf.parse("21/07/2021 10:00"),cli1,e1);		
			
		 Pedido ped2 = new Pedido(null,sdf.parse("21/07/2021 10:00"),cli1,e2);
		 
		 Pagamento pag1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
		 ped1.setPagamento(pag1);
		 
		 Pagamento pag2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2017 00:00"),null);
		 ped2.setPagamento(pag2);
		 
		 
		 cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));

		 
		 ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,200.00);
		 ItemPedido ip2 = new ItemPedido(ped1,p3,0.00,2,080.00);
		 ItemPedido ip3 = new ItemPedido(ped2,p2,0.00,2,160.00);
		 
		 ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		 ped2.getItens().addAll(Arrays.asList(ip3));
		 
		 p1.getItens().addAll(Arrays.asList(ip1));
		 p2.getItens().addAll(Arrays.asList(ip3));
		 p3.getItens().addAll(Arrays.asList(ip2));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		
		pagamentoRepository.saveAll(Arrays.asList(pag1,pag2));
	
 
		 ItemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
		
	}

}
