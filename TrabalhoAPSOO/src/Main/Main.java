/**
 * 
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Controllers.ProdutoController;
import Models.Carrinho;
import Models.Produto;
import Models.Venda;
import database.ConnectionFactory;

public class Main {

	
	public static void main(String[] args) {
		
		
		Scanner leitor = new Scanner(System.in);
		boolean exec = true;
		int opcao;
		do {
			
			System.out.println("[ 0 ] - encerrar execucao\n"
							 + "[ 1 ] - iniciar nova venda");
			
			
			opcao = leitor.nextInt();
			leitor.nextLine();
			
			switch(opcao) {	
			
				case 0:
					exec = false;
					
					break;
			
				case 1:
					Carrinho carrinho = new Carrinho();
					boolean insertProd = true;
					int codProduto;
					
					//Adicionando produtos no carrinho
					do{
						System.out.println("Insira o codigo de produto para ser adicionado");
						System.out.println("[ 0 ] - finalizar adicoes");
						
						codProduto = leitor.nextInt();
						leitor.nextLine();
						
						
						if(codProduto == 0) {
							insertProd = false;
						}
						else {
							Produto produto = ProdutoController.findProdByCod(codProduto);
							carrinho.addProduto(produto);
						}
						
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}	
						
						
					}while (insertProd);

					
					double valorTotal = carrinho.calcularValorTotal();
					System.out.println("Valor total da compra: R$ " + valorTotal);
					
					System.out.println("/*********************************/");
					
					System.out.println("Qual será a forma de pagamento?\n"
									 + "[ 1 ] - Dinheiro\n"
									 + "[ 2 ] - Cartão de crédito/débito");

					
					int formaPagamento = leitor.nextInt();
					leitor.nextLine();
					
					
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
					
					
					carrinho.addFormaPagamento(formaPagamento);
					Venda venda = new Venda(java.time.LocalDate.now().toString(), java.time.LocalTime.now().toString(), carrinho);
					
					if(formaPagamento == 1) {
						System.out.println("/*********************************/");
						System.out.println("Qual o valor pago?");
						
						double dinheiroCliente = leitor.nextDouble();
						leitor.nextLine();
						
						double troco = carrinho.troco(dinheiroCliente);
						
						System.out.println("Valor do troco a ser dado: R$ " + troco);
					}
					
					
					//bd
					venda.postVenda();
					carrinho.descontarProdutosEstoque();
					
					break;
			}
			
		}while(exec);
		
		System.out.println("Bye!");
		
	}

}
