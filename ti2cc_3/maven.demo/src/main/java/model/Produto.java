package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import dao.ProdutoDAO;

public class Produto {
	private static ProdutoDAO pDAO = new ProdutoDAO();
	private int id;
	private String descricao;
	private float preco;
	private String cor;
	private static int nextID = pDAO.getLastCode() + 1;
	
	public Produto() {
		id = -1;
		descricao = "";
		preco = 0.00F;
		quantidade = 0;
		cor = "rosa"; //default
	}

	public Produto(int id, String descricao, float preco, String cor) {
		setId(id);
		setDescricao(descricao);
		setPreco(preco);
		setCor(cor)
	}		
	
	public static int getNext() {
		return nextID;
	}
	
	public static void increment() {
		nextID++;
	}
	
	
	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getCor() {
		return quantidade;
	}
	
	public void setCor(int cor) {
		this.cor = cor;
	}


	@Override
	public String toString() {
		return "Produto: " + descricao + "   Preço: R$" + preco + "   Cor: " + core;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getID() == ((Produto) obj).getID());
	}	
}