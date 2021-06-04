/**
 * 
 */
package Main;

import Models.Carrinho;
import Models.Venda;

public class Main {

	
	public static void main(String[] args) {
		
		
		while(true) {
			
			//scanner op
			System.out.println("[ 1 ] - iniciar nova venda");
			
			switch(op) {
				case 1:
					Venda venda = new Venda();
					java.time.LocalDate.now();
					java.time.LocalTime.now();
					Carrinho carrinho = new carrinho();
					
					while(true) {
						codProduto = scaner
						produto = produtocontroller.findbycod(codprodu)
						carrinho.addProduto(produto);
						
						break
					}
					
					
					valortola = carrinho.calcularValorTotal()
					system.out.println("Valor total da compra: " + valortotal)
					
					
					//metodos de pagamento
					
					carrinho.addFormaPagamento(null);
					venda.addCarrinho(carrinho);
					
					//bd
					
					
					//
					carrinho.descontarProdutosEstoque();
			}
			
		}
		
		
	}

}
