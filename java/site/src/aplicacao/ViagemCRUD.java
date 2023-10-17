package aplicacao;

import java.util.Scanner;

import dao.DestinoDAO;
import dao.EstadiaDAO;
import dao.ViagemDAO;
import modelos.Viagem;
import modelos.Estadia;
import modelos.Destino;


public class ViagemCRUD {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		DestinoDAO destinodao = new DestinoDAO();
		EstadiaDAO estadiadao = new EstadiaDAO();
		ViagemDAO viagemDAO = new ViagemDAO();
		
		int opcao = 0, id_viagem = 0, id_destino = 0, id_estadia = 0;
		float valor = 0;
		
		String nome = "";
		
		
		do {
			
			System.out.println("\n============================== Viagem =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
	
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o valor:");
				valor = s.nextFloat();
				System.out.println("Digite o id do destino:");
				id_destino = s.nextInt();
				Destino destino = destinodao.readById(id_destino);
				System.out.println("Digite o id do estadia:");
				id_estadia = s.nextInt();
				Estadia estadia = estadiadao.readById(id_estadia);
				
				Viagem viagem1 = new Viagem(nome, valor, destino, estadia);
				
				viagemDAO.create(viagem1);
				break;
			case 2:
				
				for (Viagem u : viagemDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id-viagem:");
				id_viagem = s.nextInt();
				s.nextLine();
				
				
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o valor:");
				valor = s.nextFloat();
				System.out.println("Digite o id do destino:");
				id_destino = s.nextInt();
				System.out.println("Digite o id do estadia:");
				id_estadia = s.nextInt();				
				Destino destino2 = destinodao.readById(id_destino);
				Estadia estadia2 = estadiadao.readById(id_estadia);
				
				Viagem viagem2 = new Viagem(id_viagem, nome, valor, destino2, estadia2);
			
				viagemDAO.update(viagem2);
				break;
			case 4:
				System.out.println("Digite o id-viagem:");
				id_viagem = s.nextInt();
				s.nextLine();
				
				viagemDAO.delete(id_viagem);
				break;
			case 5:
				System.out.println("Digite um id:");
				id_viagem = s.nextInt();
				s.nextLine();
				Viagem viagem3 = viagemDAO.readById(id_viagem);
				
				System.out.println(viagem3.toString());
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

}