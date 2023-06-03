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
				System.out.println("Chamada pode ser realizada");
		    }else{
				System.out.println("Não há possibilidade de efetuar uma nova chamada.");
			}
			return duracao;
		    }
		return duracao;
		}
       }
	
	public void recarregar(GregorianCalendar data, float valor) {
	    if (numRecargas >= recargas.length) {
	        System.out.println("Não é possível fazer a recarga. O vetor de recargas está cheio.");
	        return;
	    }
	
	    Recarga recarga = new Recarga(data, valor);
	    recargas[numRecargas] = recarga;
	    numRecargas++;
	    creditos += valor;
	    System.out.println("Recarga realizada com sucesso!");
	}
	
	public void imprimirFatura(int mes) {
		System.out.println();
	}
}
