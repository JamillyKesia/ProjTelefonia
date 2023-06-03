package projeto;
import java.util.Scanner;

public class Telefonia {
	private PrePago[] prePago;
	private PosPago[] posPago;
	private int numPrePago;
	private int numPosPago;
	
		
	  public Telefonia() {

	        this.prePago = new PrePago[4];   
	        this.posPago = new PosPago[4];   
	        this.numPosPago = 0;
	        this.numPrePago = 0;
	    };


	public static void main (String[] args) {
		Telefonia telefonia = new Telefonia();
		Scanner leitor = new Scanner(System.in); 
		int opcaoMenu;
			
			do {
				System.out.println("Menu de Opções: \n1. Cadastrar assinante\n2. Listar assinantes\n3. Fazer chamada\n4. Fazer recarga\n5. Imprimir faturas\n6. Sair");
			    System.out.print("Escolha uma opção: ");
			   
			    opcaoMenu = leitor.nextInt();
			    System.out.println("\n");
			    
			    switch(opcaoMenu) {
			    	case 1:
			    		telefonia.cadastrarAssinante();
			    		break;
			    	case 2:
			    		telefonia.listarAssinantes();
			    		break;
			    	case 3:
			    		telefonia.fazerChamada();
			    		break;
			    	case 4:
			    		telefonia.fazerRecarga();
			    		break;
			    	case 5:
			    		telefonia.imprimirFaturas();
			    		break;
			    	case 6:
			    		System.out.println("Programa encerrado!");
			    		break;
			    	default:
			    		System.out.println("Opção inválida. Tente novamente.");
			            break;
			    }
			} while (opcaoMenu != 6);
		};
	
	
	public void cadastrarAssinante() {
		
		Scanner leitor = new Scanner(System.in); 

			System.out.println("Por favor, inserir qual tipo de assinante: \n1. Assinante PréPago \n2. Assinante PósPago \n3.Voltar \n4.Sair ");
			int TipoPacote = leitor.nextInt();
		
			if(TipoPacote == 1) {
					if (numPrePago < prePago.length) {
						System.out.println("Informe o CPF:");
						long cpf = leitor.nextLong();
												
						System.out.println("Informa o seu nome:");
						String nome = leitor.next();			
						
						System.out.println("Informe o número de telefone:");
						int numero = leitor.nextInt();
						
						PrePago assinante = new PrePago(cpf, nome, numero);
						
						prePago[numPrePago] = assinante;
						numPrePago++;
						System.out.println("Assinante cadastrado com sucesso!!!!");
						return;
					}
					else {
						System.out.println("Não é possivel fazer mais pacotes Pré Pago");
					}	
					
			}else if(TipoPacote == 2){
					if (numPosPago < posPago.length) {
						System.out.println("Informe o CPF:");
						long cpf = leitor.nextLong();
						
						System.out.println("Informa o seu nome:");
						String nome = leitor.next();
						
						System.out.println("Informe o número de telefone:");
						int numero = leitor.nextInt();
						
						System.out.println("Informe o valor da assinatura: ");
						float assinatura = leitor.nextFloat();
						
						PosPago assinante = new PosPago(cpf,nome, numero, assinatura);
						
						posPago[numPosPago] = assinante;
						numPosPago++;
						System.out.println("Assinante cadastrado com sucesso!!!!\n");
						return;
					}
					else {
						System.out.println("Não é possivel fazer mais pacotes Pós Pago");
					}
			}else {
				System.out.println("Opção invalida!");
			}
			
};
		
	public void listarAssinantes() {
			
		System.out.println("ASSINATES CADASTRADOS\n");
		System.out.println("Assinantes Pós Pago\n");
		for(PosPago assinantesPosPago : posPago) {
			if (assinantesPosPago != null) {
			System.out.println("CPF: " + assinantesPosPago.getCpf());
			System.out.println(assinantesPosPago.toString());
			}else {
				System.out.println("Não há assinantes cadastrados\n");
				break;
			}
		}
		System.out.println("Assinantes Pré Pago\n");
		for(PrePago assinantesPrePago : prePago) {
			if (assinantesPrePago != null) {
			System.out.println("CPF: " + assinantesPrePago.getCpf());
			System.out.println(assinantesPrePago.toString());
			}else {
				System.out.println("Não há assinantes cadastrados\n");
				break;
			}
		}
		
	};
	
	
	public void fazerChamada() {};
	public void fazerRecarga() {};
	private PrePago localizarPrePago(long cpf) {
		return null;};
	private PosPago localizarPosPago(long cpf) {
		return null;};	
	public void imprimirFaturas() {};
	
	
}
