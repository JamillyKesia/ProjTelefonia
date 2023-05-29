package projeto;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Chamada {
	private GregorianCalendar data;
	private int duracao;


	public Chamada(GregorianCalendar data, int duracao) {
		this.data = data;
		this.duracao = duracao;
	}
	
	public GregorianCalendar getData() {
		return data;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	@Override
	public String toString() {		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String dtFormatada = sdf.format(data.getTime());
		
		return "Data da chamada: " + dtFormatada + "\nDuração: " + duracao;
	}
}