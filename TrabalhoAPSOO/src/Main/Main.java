/**
 * 
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Controllers.CarrinhoController;
import Controllers.ProdutoController;
import Controllers.VendaController;
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
			
			System.out.println("\n[ 0 ] - encerrar execucao\n"
							 + "[ 1 ] - iniciar nova venda\n\n");
			
			
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
					
					//Listar produtos
					System.out.println("\n/-------------------Produtos disponiveis-------------------/\n");
					ArrayList<Produto> produtos = ProdutoController.index();
					produtos.forEach((produto) -> produto.listarProduto());
					System.out.println("\n/-------------------------------/");
					//Adicionando produtos no carrinho
					do{
						System.out.println("\nInsira o codigo de produto para ser adicionado\n");
						System.out.println("[ 0 ] - finalizar adicoes\n\n");
						
						codProduto = leitor.nextInt();
						leitor.nextLine();
						
						
						if(codProduto == 0) {
							insertProd = false;
						}
						else {
							Produto produto = ProdutoController.findProdByCod(codProduto);
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
					}
																	
					Venda venda = new Venda(java.time.LocalDate.now().toString(), java.time.LocalTime.now().toString(), carrinho);
					
					if(formaPagamento == 1) {
						System.out.println("\n/*********************************/\n");
						System.out.println("Qual o valor pago?\n\n");
						
						double dinheiroCliente = leitor.nextDouble();
						leitor.nextLine();
						
						double troco = carrinho.troco(dinheiroCliente);
						
						System.out.println("\nValor do troco a ser dado: R$ " + troco + "\n");
					}else if(formaPagamento == 3) {
						break;
					}
					carrinho = CarrinhoController.store(carrinho);
					
					venda.addCarrinho(carrinho);
					VendaController.store(venda);
					carrinho.getProdutos().forEach((produto) -> ProdutoController.delete(produto));
					
					
					break;
			}
			
		}while(exec);
	}

}
