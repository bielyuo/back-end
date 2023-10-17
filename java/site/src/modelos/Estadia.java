package modelos;

public class Estadia {

	// atributos
	private int id_estadia;
	private String nome;
	private float preco;
	
	public Estadia(int id_estadia, String nome, float preco) {
		super();
		this.id_estadia = id_estadia;
		this.nome = nome;
		this.preco = preco;
	}
	public Estadia(String nome,float preco) {
		this.nome = nome;
		this.preco = preco;
	}
	public Estadia() {
		
	}

	public int getId_estadia() {
		return id_estadia;
	}



	public void setId_estadia(int id_estadia) {
		this.id_estadia = id_estadia;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public float getPreco() {
		return preco;
	}



	public void setPreco(float preco) {
		this.preco = preco;
	}



	
	// construtor

	

	// tostring
	
	@Override
	public String toString() {
		return "Compras [id_estadia=" + id_estadia + ", nome=" + nome + ", preco=" + preco + "]";
	}

	

}
