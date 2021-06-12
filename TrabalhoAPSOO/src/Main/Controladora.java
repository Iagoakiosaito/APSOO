package Main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Dao.CarrinhoDao;
import Dao.ProdutoDao;
import Dao.VendaDao;
import Models.Carrinho;
import Models.Produto;
import Models.Venda;

public class Controladora {
	
	public static Venda realizarVenda() {
		Scanner leitor = new Scanner(System.in);
		Carrinho carrinho = new Carrinho();
		boolean insertProd = true;
		int codProduto;
		
		//Listar produtos
		System.out.println("\n/-------------------Produtos disponiveis-------------------/\n");
		ArrayList<Produto> produtos = ProdutoDao.index();
		produtos.forEach((produto) -> produto.listarProduto());
		System.out.println("\n/-------------------------------/");
		//Adicionando produtos no carrinho
		do{
			System.out.println("\nInsira o código de produto para ser adicionado\n");
			System.out.println("[ 0 ] - finalizar adições\n\n");
			
			codProduto = leitor.nextInt();
			leitor.nextLine();
			
			
			if(codProduto == 0) {
				insertProd = false;
			}
			else {
				Produto produto = ProdutoDao.findProdByCod(codProduto);
				
				if(produto == null) {
					System.out.println("Produto não encontrado!\n\n");
				} else {
					carrinho.addProduto(produto);
				}	
			}
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			
			
		}while (insertProd);

		
		carrinho.calcularValorTotal();
		//TODO integrar com controle de cliente(desconto de fregues) 
		
		System.out.println("\nValor total da compra: R$ " + carrinho.getValorVenda());
		
		System.out.println("/*********************************/\n");
		
		System.out.println("Qual será a forma de pagamento?\n"
						 + "[ 1 ] - Dinheiro\n"
						 + "[ 2 ] - Cartão de crédito/débito\n"
						 + "[ 3 ] - Cancelar venda!\n\n");

		
		int formaPagamento = leitor.nextInt();
		leitor.nextLine();
		
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		
		carrinho.addFormaPagamento(formaPagamento);
		
		System.out.println("Cliente vai informar o CPF?\n"
				 + "[ 1 ] - Sim\n"
				 + "[ 2 ] - Não\n");
		
		int opcaoCpf = leitor.nextInt();
		leitor.nextLine();
		
		if(opcaoCpf == 1) {
			System.out.println("Insira o cpf");
			String cpf = leitor.nextLine();
			//TODO integrar com controle de cliente (elegibilidade de desconto)
		}
														
		Venda venda = new Venda(java.time.LocalDate.now().toString(), java.time.LocalTime.now().toString(), carrinho);
		
		
		if(formaPagamento != 3) {
			if(formaPagamento == 1) {
				System.out.println("\n/*********************************/\n");
				System.out.println("Qual o valor pago?\n\n");
				
				double dinheiroCliente = leitor.nextDouble();
				leitor.nextLine();
				
				double troco = carrinho.troco(dinheiroCliente);
				
				System.out.println("\nValor do troco a ser dado: R$ " + troco + "\n");
			}
			
			carrinho = CarrinhoDao.store(carrinho);
			
			venda.addCarrinho(carrinho);
			
			return venda;
		}
		
		return null;
	}
	
	public static void finalizarVenda(Venda venda) {
		VendaDao.store(venda);
		venda.getCarrinho().getProdutos().forEach((produto) -> ProdutoDao.delete(produto));
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		venda.listarVenda();
	}
	
	
}
