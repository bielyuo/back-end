package modelos;

public class Viagem{
	private Destino destino; 
	private Estadia estadia;
	private float valor;
	private String nome;
	public Viagem(String nome, float valor, Destino destino,Estadia estadia) {
		this.destino = destino;
		this.estadia = estadia;
		this.nome = nome;
		this.valor = valor;
		
	}
	public Viagem(int id_viagem,String nome, float valor, Destino destino,Estadia estadia) {
		this.id_viagem = id_viagem;
		this.destino = destino;
		this.estadia = estadia;
		this.nome = nome;
		this.valor = valor;
		
	}
	
	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId_viagem() {
		return id_viagem;
	}

	public void setId_viagem(int id_viagem) {
		this.id_viagem = id_viagem;
	}









	private int id_viagem;
	
	

	
	public Viagem() {
	}

	public String toString() {
		return "Compras [id_viagem=" + id_viagem + ", nome=" + nome + ", valor=" + valor + "]";
	}
	

	
}
