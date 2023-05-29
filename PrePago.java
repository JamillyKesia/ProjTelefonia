package projeto;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class PrePago extends Assinante {
	private int[] recargas;
	private int creditos;
	private int numRecargas;
	
	public PrePago(long cpf, String nome, int numero, int[] recargas, int creditos, int numRecargas) {
		super(cpf, nome, numero, numRecargas);
		recargas = new int[8];
		this.creditos = creditos;
		this.numRecargas = numRecargas;
	}
	
	public void fazerChamada(GregorianCalendar data, int duracao) {
		if(Chamadas.length < 8) {
			System.out.println("O vetor tem espaço");
			
			if(creditos >= 1.45) {
				System.out.println("Possui créditos suficientes para fazer chamadas");
				//Chamadas[numChamadas] = 8;
		        numChamadas++;
		        //creditos -= custoChamada;
			}
			else {
				System.out.println("Créditos insuficientes para fazer chamadas");
			}
		}else {
			System.out.println("O vetor está cheio");
		}
		
	}
	
	public void recarregar(GregorianCalendar data, float valor) {
		if(recargas.length < 8) {
			System.out.println("É possível realizar recarga");
			numChamadas++;
			creditos++;
		}else {
			System.out.println("Não é possivel realizar nova recarga");
		}
	}
	
	public void imprimirFatura(int mes) {
		System.out.println();
	}
}