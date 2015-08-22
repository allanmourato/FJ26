package br.com.caelum.notasfiscais.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	Produto produto = new Produto();
	
	List<Produto> produtos;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void grava() {
		ProdutoDao dao = new ProdutoDao();
		dao.adiciona(produto);
		this.produto = new Produto();
		this.produtos = dao.listaTodos();
		System.out.println("Produto Gravado com sucesso!");	
	}
	
	public List<Produto> getlista(){
		if (produtos == null) {
			produtos = new ProdutoDao().listaTodos();
		}
		return produtos;
	}
	
	public void remove() {
		ProdutoDao dao = new ProdutoDao();
		dao.remove(produto);
	}

}
