package Views;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Dao.CarrinhoDao;
import Dao.ProdutoDao;
import Dao.VendaDao;
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
								 + "[ 1 ] - Iniciar nova venda\n\n");
				
				opcao = leitor.nextInt();
				leitor.nextLine();
				
				switch(opcao) {	
				
					case 0:
						exec = false;
						break;
				
					case 1:
						Controladora.realizarVenda();
				}
				
			}while(exec);
		}
	
	
	

}
