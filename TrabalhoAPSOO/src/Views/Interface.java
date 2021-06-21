package Views;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Dao.CarrinhoDao;
import Dao.ProdutoDao;
import Dao.VendaDao;
import Enum.OperacaoEnum;
import Main.Controladora;
import Models.Carrinho;
import Models.Produto;
import Models.Venda;

public class Interface {
	
		public void run() {
			
			Scanner leitor = new Scanner(System.in);
			boolean exec = true;
			int opcao;
			do {
				
				System.out.println("\n[ 0 ] - Encerrar execução\n"
								 + "[ 1 ] - Iniciar nova venda\n"
								 + "[ 2 ] - Gerar pedido de compra de insumos\n");
				
				opcao = leitor.nextInt();
				leitor.nextLine();
				
				switch(opcao) {	
				
					case 0:
						exec = false;
						break;
				
					case OperacaoEnum.REALIZAR_VENDA:
						 Venda venda = Controladora.realizarVenda();
						
						if(venda != null) {
							Controladora.finalizarVenda(venda);
						}
						
						break;
					case OperacaoEnum.GERAR_PEDIDO_DE_INSUMOS: 
						Controladora.checarEstoque();
						Controladora.gerarPedidoDeCompraDeInsumos();
						break;
				}
				
			}while(exec);
		}
	
	
	

}
