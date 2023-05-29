package projeto;

public class Assinante {
	private long cpf;
	private String nome;
	private int numero;
	protected Chamada[] Chamadas;
	protected int numChamadas;
	
	public Assinante(long cpf, String nome, int numero, int numChamadas) {
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero;
		this.numChamadas = numChamadas;
			
		//instanciar o vetor chamadas -> talvez use ArrayList
		Chamada[] Chamadas = new Chamada[8];
	}
	
	public long getCpf() {
		return this.cpf;
		
	}
	
	public String toString() {
		return "Nome: " + nome + "\nCPF: " + cpf + "\nNúmero: " + numero + "\nnumChamadas: "+ numChamadas; // adicione os outros atributos conforme necessário
	}
	
	
	
}
