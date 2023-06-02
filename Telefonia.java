package projeto;
import java.util.Scanner;

public class Telefonia {
	private PrePago prePago;
	private PosPago posPago;
	private int numPrePago;
	private int numPosPago;
	
		
	public Telefonia() {};


	public static void main (String[] args) {
		Telefonia telefonia = new Telefonia();
		try (Scanner scanner = new Scanner(System.in)) {
			int opcaoMenu;
			
			do {
				System.out.println("Menu de Opções: \n1. Cadastrar assinante\n2. Listar assinantes\n3. Fazer chamada\n4. Fazer recarga\n5. Imprimir faturas\n6. Sair");
			    System.out.print("Escolha uma opção: ");
			   
			    opcaoMenu = scanner.nextInt();
			    System.out.println("\n");
			    
			    switch(opcaoMenu) {
			    	case 1:
			    		telefonia.cadastrarAssinante();
			    		System.out.println("cadastrar assinate");
			    		break;
			    	case 2:
			    		telefonia.listarAssinantes();
			    		System.out.println("listarAssinantes");
			    		break;
			    	case 3:
			    		telefonia.fazerChamada();
			    		System.out.println("fazer chamada");
			    		break;
			    	case 4:
			    		telefonia.fazerRecarga();
			    		System.out.println("fazer recarga");
			    		break;
			    	case 5:
			    		telefonia.imprimirFaturas();
			    		System.out.println("imprimir faturas");
			    		break;
			    	case 6:
			    		System.out.println("Programa encerrado!");
			    		break;
			    	default:
			    		System.out.println("Opção inválida. Tente novamente.");
			            break;
			    }
			} while (opcaoMenu != 6);
		}
	};
	
	
	public void cadastrarAssinante() {};
	public void listarAssinantes() {};
	public void fazerChamada() {};
	public void fazerRecarga() {};
	private PrePago localizarPrePago(long cpf) {
		return null;};
	private PosPago localizarPosPago(long cpf) {
		return null;};	
	public void imprimirFaturas() {};
	
	
}
