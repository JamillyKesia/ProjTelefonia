package projeto;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PrePago extends Assinante {
	private float creditos;
	private int numRecargas;
	private Recarga[] recargas;
	private static final float custo_chamada = 1.45f;

	public PrePago(long cpf, String nome, int numero) {
		super(cpf, nome, numero);
		this.creditos = 0.0f;
		this.numRecargas = 0;
		this.recargas = new Recarga[8];
	}

	public float fazerChamada(GregorianCalendar data, int duracao) {
		if (numChamadas < Chamadas.length) {
			float gasto = (float) (custo_chamada * duracao);
			if (creditos >= gasto) {
				Chamada novaChamada = new Chamada(data, duracao);
				Chamadas[numChamadas] = novaChamada;
				creditos -= gasto;
				System.out.println("Chamada realizada!");
			} else {
				System.out.println("Não há créditos para realizar a chamada, recarregue!.");
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
		recargas[numRecargas] = recarga; //atribui a nova recarga na posição do vetor
		numRecargas++;
		creditos += valor;
		System.out.println("Recarga realizada com sucesso!");
	}

	public void imprimirFatura(int mes) {
		System.out.println("FATURA");
		System.out.println("Dados:");
		System.out.println("CPF:" + getCpf());

		System.out.println("Chamadas feitas no mês " + mes + ":");
		float totalChamadas = 0;
		for (int i = 0; i < numChamadas; i++) { //loop no array Chamadas
			Chamada chamada = Chamadas[i];
			if (chamada.getData().get(GregorianCalendar.MONTH) + 1 == mes) { //verifica se a chamada foi feita no mês desejado e soma 1
				System.out.println("Data: " + chamada.getData().getTime());
				System.out.println("Duração: " + chamada.getDuracao() + " minutos");
				double custoChamada = chamada.getDuracao() * custo_chamada; // Custo por minuto
				totalChamadas += custoChamada; //valor do custo da chamada é add ao total de chamadas
				System.out.println("Custo: R$" + custoChamada);
			}
		}

		System.out.println("Recargas feitas no mês:");
		float totalRecargas = 0.0f;
		for (int i = 0; i < numRecargas; i++) {
			Recarga recarga = recargas[i];
			if (recarga.getData().get(GregorianCalendar.MONTH) + 1 == mes) {
				System.out.println("Data da recarga: " + recarga.getData().getTime());
				System.out.println("Valor da recarga: R$" + recarga.getValor());
				double custoRecarga = recarga.getValor();
				totalRecargas += custoRecarga;
				System.out.println("Custo recarga: " + custoRecarga);

			}
		}

		System.out.println("========= Total de Chamadas e Recargas do Mês =========");
		System.out.println("Valor total de chamadas: R$" + totalChamadas);
		System.out.println("Valor total de recargas: R$" + totalRecargas);

		float creditos = totalRecargas - totalChamadas;
		System.out.println("Créditos: R$" + creditos);
	}
}
