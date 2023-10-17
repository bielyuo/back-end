package aplicacao;

import dao.EstadiaDAO;

import java.util.Scanner;


import modelos.Estadia;


public class EstadiaCRUD {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		EstadiaDAO estadiaDAO = new EstadiaDAO();
		
		int opcao = 0, id_estadia = 0;
		float preco = 0; 
		
		String nome = "";
		
		do {
			
			System.out.println("\n============================== EStadia =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o Nome do destino:");
				nome = s.nextLine();
				System.out.println("Digite o Valor:");
				preco = s.nextFloat();
				
				
				Estadia estadia = new Estadia(nome, preco);
				
				estadiaDAO.create(estadia);
				break;
			case 2:
				
				for (Estadia u : estadiaDAO.read()) {
					
					System.out.println(u.toString());
					
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id_estadia = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("valor:");
				preco = s.nextFloat();
				
				
				
				Estadia estadia2 = new Estadia(id_estadia, nome, preco);
				
				estadiaDAO.update(estadia2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id_estadia = s.nextInt();
				s.nextLine();
				
				estadiaDAO.delete(id_estadia);
				break;
			case 5:
				System.out.println("Digite um id:");
				id_estadia = s.nextInt();
				s.nextLine();
				
				Estadia estadia3 = estadiaDAO.readById(id_estadia);
				
				System.out.println(estadia3.toString());
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

}

