package projeto;

public class Assinante {
	private long cpf;
	private String nome;
	private int numero;
	protected Chamada[] Chamadas;
	protected int numChamadas;
	
	public Assinante(long cpf, String nome, int numero) {
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero;
		this.numChamadas = 0;
			
		//instanciar o vetor chamadas -> talvez use ArrayList
		Chamada[] Chamadas = new Chamada[8];
	}
	
	public long getCpf() {
		return cpf;
		
	}
	
	public String toString() {
		return "Nome: " + nome + "\nNúmero de telefone: " + numero;  // adicione os outros atributos conforme necessário
	}
	
	
	
}
