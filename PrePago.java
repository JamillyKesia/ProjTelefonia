package projeto;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class PrePago extends Assinante {
	private Recarga[] recargas;
	private int creditos;
	private int numRecargas;
	
	public PrePago(long cpf, String nome, int numero, int[] recargas, int creditos, int numRecargas) {
		super(cpf, nome, numero);
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
				creditos = (int) (creditos - Gasto);
				System.out.println("Chamada pode ser realizada");
		    }else{
				System.out.println("Não há possibilidade de efetuar uma nova chamada.");
			}
			return duracao;
		    }
		return duracao;
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
	
	public void imprimirFatura(int mes, GregorianCalendar data, float valor) {
		System.out.println("=========Fatura=========");
		System.out.println("CPF: " + getCpf());
		toString();
	    
		float totalChamadas = 0.0f;
        for (int i = 0; i < numChamadas; i++) {
            Chamada chamada = Chamadas[i];
            if (chamada.getData().get(GregorianCalendar.MONTH) == mes) {
                chamada.toString(); //classe chamada data e duração
                recargas.toString();
                Recarga recarga = new Recarga(data,valor);
                totalChamadas += recarga.getValor();
            }
        }
        System.out.println("Valor total de chamadas: R$ " + totalChamadas);

        System.out.println("Recargas feitas no mês " + mes + ":");
        
        float totalRecargas = 0.0f;
        for (int i = 0; i < numRecargas; i++) {
            Recarga recarga = recargas[i];
            if (recarga.getData().get(GregorianCalendar.MONTH) == mes) { //vê se a recargar ocorreu no mês desejado
                System.out.println("Data: " + recarga.getData().getTime());
                System.out.println("Valor: R$ " + recarga.getValor());
                totalRecargas += recarga.getValor(); //valor da recarga é add
                System.out.println("Valor total de recargas: R$ " + totalRecargas);
                float saldo = totalRecargas - totalChamadas;
                System.out.println("Saldo de créditos: R$ " + saldo);
            }
        }
	}
}
