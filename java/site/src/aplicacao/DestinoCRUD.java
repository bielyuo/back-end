package aplicacao;

import dao.DestinoDAO;
import java.util.Scanner;

import modelos.Destino;


public class DestinoCRUD {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		DestinoDAO destinoDAO = new DestinoDAO();
		
		int opcao = 0, id_destino = 0; 
		
		String nome = "";
		
		do {
			
			System.out.println("\n============================== COMPRAS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o Nome do destino:");
				nome = s.nextLine();
				
				
				Destino destino = new Destino(nome);
				
				destinoDAO.create(destino);
				break;
			case 2:
				
				for (Destino u : destinoDAO.read()) {
					
					System.out.println(u.toString());
					
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id_destino = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				
				
				Destino destino2 = new Destino(id_destino, nome);
				
				destinoDAO.update(destino2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id_destino = s.nextInt();
				s.nextLine();
				
				destinoDAO.delete(id_destino);
				break;
			case 5:
				System.out.println("Digite um id:");
				id_destino = s.nextInt();
				s.nextLine();
				
				Destino destino3 = destinoDAO.readById(id_destino);
				
				System.out.println(destino3.toString());
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

}
