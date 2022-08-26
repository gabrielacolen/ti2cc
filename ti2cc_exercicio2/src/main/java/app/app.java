package app;

import java.util.List;
import java.util.Scanner;

import dao.DAO;
import dao.Produto;
import model.Produto;

public class Aplicacao {
	public static Scanner input = new Scanner(System.in);

	public static int menu() {
		int op;
		
		System.out.println("\n\t\tMENU ");
		System.out.println("1 - Listar produto\n");
		System.out.println("2 - Inserir produto\n");
		System.out.println("3 - Excluir produto\n");
		System.out.println("4 - Atualizar produto\n");
		System.out.println("5 - Sair do menu\n");
		System.out.print("Sua opcao: [1-5] ");
		op = input.nextInt();
		
		return op;
	}
	
	public static void main(String[] args) throws Exception {
		int op;
		Produto produto = new Produto();
			
		do {
			op = menu();
			
			switch(op){
				case 1:
					listarProd(produto);
					break;
				case 2:
					inserirProd(produto);
					break;
				case 3:
					excluirProd(produto);
					break;
				case 4:
					atualizarProd(produto);
					break;
				case 5:
					System.out.print("Saindo");
			}
		} while(op != 5);
	}
	
	public static void listarProd(Produto produto) {
		System.out.println("\n\n==== Mostrar produtos ordenados por código === ");
		List<Produto> produtos = produto.getOrderByCodigo();
		for (Produto u: produtos) {
			System.out.println(u.toString());
		}
	}

	public static Produto criarProduto() {
		int codigo;
		String nome;
		String tipo;
		
		System.out.print("Codigo: ");
		codigo = input.nextInt();
		clearBuffer();
		System.out.print("Nome: ");
		nome = input.nextLine();
		System.out.print("Tipo: ");
		tipo = input.nextLine();
		
		Produto produto = new Produto(codigo, nome, tipo);
		
		return produto;
	}
	
	public static void inserirProd(Produto produto) {
		System.out.println("\n\n==== Inserir produto === ");
		
		Produto produto = criarProduto();
		if(produto.insert(produto) == true) {
			System.out.println("Inserção com sucesso -> " + produto.toString());
		}
	}
	
	public static void excluirProd(Produto produto) {
		System.out.println("\n\n==== Excluir produto === ");
		System.out.println("Codigo: ");
		int codigo = input.nextInt();
	
		Produto produto = produto.get(codigo);
		
		System.out.println("\nExcluindo produto (código " + produto.getCodigo() + ")");
		produto.delete(produto.getCodigo());
	}
	
	public static void atualizarProd(Produto produto) {
		System.out.println("\n\n==== Atualizar produto === ");
		System.out.println("Codigo: ");
		int codigo = input.nextInt();
	
		Produto produto = produto.get(codigo);
		
		System.out.println("\nAtualizar produto (código " + produto.getCodigo() + ")");
		Produto novo = criarProduto();
		
		if(produto.insert(novo) == true) {
			produto.delete(produto.getCodigo());
			System.out.println("Atualização com sucesso -> " + novo.toString());
		}
	}
	
	private static void clearBuffer() {
        if (input.hasNextLine()) {
            input.nextLine();
        }
    }
	
	
}
