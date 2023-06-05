package projeto;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Recarga {
	private GregorianCalendar data;
	private float valor;

	public Recarga(GregorianCalendar data, float valor) {
		this.data = data;
		this.valor = valor;
	}

	public GregorianCalendar getData() {
		return data;
	};

	public float getValor() {
		return valor;
	};

	public String toString() {
		SimpleDateFormat FormatarData = new SimpleDateFormat("dd/MM/yyyy");
		String DataFormatada = FormatarData.format(data.getTimeZone());
		return "DATA: " + DataFormatada + "\n VALOR: " + valor;
	};

}