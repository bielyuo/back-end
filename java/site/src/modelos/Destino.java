package modelos;

public class Destino {

	private int id_destino;
	private String nome;
	
	
	

	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}
	
	public int getId_destino() {
		return id_destino;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	


	public String getNome() {
		return nome;
	}


	
	
	public Destino() {
	}

	

	public Destino(String nome) {
		this.nome = nome;
		
	}
	public Destino(int id_destino, String nome) {
		this.nome = nome;
		this.id_destino = id_destino;
		
	}

	

	@Override
	public String toString() {
		return "Destino [id_destino=" + id_destino + ", nome=" + nome + "]";
	}

	

}
