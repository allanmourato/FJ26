package br.com.caelum.notasfiscais.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@Named
@RequestScoped
public class ProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private Produto produto;
	
	@Inject
	private ProdutoDao dao;
	
	List<Produto> produtos;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void grava() {
			
			
			if (produto.getId() == null) {
				dao.adiciona(this.produto);
				this.produtos = dao.listaTodos();
				System.out.println("Produto Gravado com sucesso!");
			} else {
				dao.atualiza(produto);
				System.out.println("Produto atualizado com sucesso !");
			}
			
			produtos = dao.listaTodos();
			this.produto = new Produto();
					
	}
	
	public List<Produto> getlista(){
		if (produtos == null) {
			produtos =  dao.listaTodos();
		}
		return produtos;
	}
	
	public void remove(Produto produto) {
		
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}

}
