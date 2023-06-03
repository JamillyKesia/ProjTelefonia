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
	
	public float fazerChamada(GregorianCalendar data, int duracao) {
		if (numChamadas < Chamadas.length) {
			float Gasto = (float)(1.45 * duracao);
			if (creditos >= Gasto) {
				Chamada novaChamada = new Chamada(data, duracao);
				Chamadas[numChamadas] = novaChamada;
				creditos = creditos - Gasto;
				System.out.println("foi feito fi");
		    }else{
				System.out.println("Não há possibilidade de efetuar uma nova chamada.");
			}
			return duracao;
		    }
		return duracao;
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
