package projeto;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class PrePago extends Assinante{
    private float creditos;
    private int numRecargas;
    private Recarga[] recargas;
    private static final float custo_chamada = 1.45f;
    
    public PrePago(long cpf, String nome, int numero){
        super(cpf, nome, numero);
        this.creditos = 0.0f;
        this.numRecargas = 0;
        Recarga[] recargas = new Recarga[8];
    }
	
	public float fazerChamada(GregorianCalendar data, int duracao) {
    	if (numChamadas < Chamadas.length) {
    		float gasto = (float)(custo_chamada * duracao);
    		if (creditos >= gasto) {
    			Chamada novaChamada = new Chamada(data, duracao);
        		Chamadas[numChamadas] = novaChamada;
                creditos -= gasto;
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
	
	public void imprimirFatura(int mes) {
		System.out.println("=========Fatura=========");
		System.out.println("CPF: " + getCpf());
		toString();//mostra nome e número de telefone
		
		 System.out.println("========= Chamadas no Mês =========");
		    float totalChamadas = 0.0f;
		    for (Chamada chamada : Chamadas) {
		        if (chamada.getData().get(Calendar.MONTH) + 1 == mes) {
		            System.out.println("Data: " + chamada.getData());
		            System.out.println("Duração da chamada: " + chamada.getDuracao());
		            float valorChamada = custo_chamada * chamada.getDuracao();
		            System.out.println("Valor da chamada: " + valorChamada);
		            totalChamadas += valorChamada;
		        }
		    }		
		
		    System.out.println("========= Recargas no Mês =========");
		    float totalRecargas = 0.0f;
		    for (Recarga recarga : recargas) {
		        if (recarga.getData().get(Calendar.MONTH) + 1 == mes) {
		            System.out.println("Data: " + recarga.getData());
		            System.out.println("Valor da recarga: " + recarga.getValor());
		            totalRecargas += recarga.getValor();
		        }
		    }

		    System.out.println("========= Total de Chamadas e Recargas do Mês =========");
		    System.out.println("Valor total de chamadas: R$" + totalChamadas);
		    System.out.println("Valor total de recargas: R$" + totalRecargas);

		    float creditos = totalRecargas - totalChamadas;
		    System.out.println("Créditos: R$" + creditos);
		}
}
