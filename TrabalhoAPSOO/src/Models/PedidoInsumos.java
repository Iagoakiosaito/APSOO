package Models;

import java.util.ArrayList;

public class PedidoInsumos {
	
	private String dataPedido;
	private ArrayList<ProdutoDoPedido> produtosPedido;
	
	public PedidoInsumos() {
		this.setDataPedido(java.time.LocalTime.now().toString());
		produtosPedido = new ArrayList<ProdutoDoPedido>();
	}
	
	public void adicionarProduto(Produto produto, int quantidade) {
		boolean achou = false;
		for(int i = 0; i < this.getProdutosPedido().size(); i++) {
			if(produto.getCodigoProduto() == this.getProdutosPedido().get(i).getCodigoProduto()) {
				this.getProdutosPedido().get(i).setQuantidadeProduto(this.getProdutosPedido().get(i).getQuantidadeProduto() + quantidade);
				achou = true;
			}
		}
		
		if(!achou) {
			ProdutoDoPedido produtoPedido = new ProdutoDoPedido(produto.getNomeProduto(), produto.getCodigoProduto(), quantidade);
			produtosPedido.add(produtoPedido);
		}
		
//		ProdutoDoPedido produtoPedido = new ProdutoDoPedido(produto.getNomeProduto(), produto.getCodigoProduto(), quantidade);
//		produtosPedido.add(produtoPedido);
	}
	
	public void listarPedido() {
		System.out.println("----Dados do pedido----");
		System.out.println("Data do pedido: " + this.getDataPedido());
		System.out.println("Produtos: ");
		this.getProdutosPedido().forEach((produto) -> System.out.println("- " + produto.getQuantidadeProduto() + "x " + produto.getNomeProduto()));
	}

	public ArrayList<ProdutoDoPedido> getProdutosPedido() {
		return produtosPedido;
	}

	public void setProdutosPedido(ArrayList<ProdutoDoPedido> produtosPedido) {
		this.produtosPedido = produtosPedido;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
	
}
