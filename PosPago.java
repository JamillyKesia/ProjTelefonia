package projeto;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class PosPago extends Assinante{
    private float assinatura;
    private static final float custo_chamada = 1.04f;

    public PosPago(long cpf, String nome, int numero, float assinatura){
        super(cpf, nome, numero);
        this.assinatura = assinatura;
    }

    public void fazerChamada(GregorianCalendar data, int duracao){

        if(numChamadas < Chamadas.length){
            Chamada Novachamada = new Chamada(data, duracao);
            Chamadas[numChamadas] = Novachamada;
            numChamadas ++;
            System.out.println("foi feito fi");
        }else{
            System.out.println("Não há possibilidade de efetuar uma nova chamada.");
        }

    }

    public void ImprimirFatura(int mes){  
    	System.out.println("FATURA DO MÊS ");
        System.out.println("CPF: " + getCpf());
        System.out.println(toString()); 
        
        //for-each para percorrer o "chamadas" 
        for (Chamada chamada : Chamadas) {
        	if (chamada.getData().get(Calendar.MONTH)== mes) {
        		System.out.println("Data: " + chamada.getData());
        		System.out.println("Duração da chamada: " + chamada.getDuracao());
        		float valorChamada = custo_chamada * chamada.getDuracao();
        		System.out.println("Valor da chamada: " + valorChamada);
        	}
        }
    }
	
}
