package projeto;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PosPago extends Assinante {
	private float assinatura;

	public PosPago(long cpf, String nome, int numero, float assinatura) {
		super(cpf, nome, numero);
		this.assinatura = assinatura;
	}

	public void fazerChamada(GregorianCalendar data, int duracao) {

		if (numChamadas < Chamadas.length) {
			Chamada Novachamada = new Chamada(data, duracao);
			Chamadas[numChamadas] = Novachamada;
			numChamadas++;
		} else {
			System.out.println("Não há possibilidade de efetuar uma nova chamada.");
		}

	}

	public void ImprimirFatura(int mes) {
		System.out.println("FATURA DO MÊS ");
		System.out.println("CPF: " + getCpf());
		System.out.println(toString());

		// for-each para percorrer o "chamadas"
		for (int i = 0; numChamadas < i; i++) {
			Chamada chamada = Chamadas[i];
			if (chamada.getData().get(Calendar.MONTH) + 1 == mes) {
				System.out.println("Data: " + chamada.getData());
				System.out.println("Duração da chamada: " + chamada.getDuracao());
				float valorChamada = 1.04f * chamada.getDuracao();
				System.out.println("Valor da chamada: " + valorChamada);
			}
		}

		int totalFaturaMes = (int) assinatura;
		for (int i = 0; i < numChamadas; i++) {
			Chamada chamada = Chamadas[i];
			if (chamada.getData().get(Calendar.MONTH) + 1 == mes) {
				totalFaturaMes += (1.04f * chamada.getDuracao());
			}
		}
		System.out.println("O valor total da fatura é igual a: " + totalFaturaMes);
	}

}