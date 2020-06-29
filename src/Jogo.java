/*RPG
 Gabriel Oliveira
 Matheus Oliveira
 Ot�vio Lage dos Santos
 AC2 da mat�ria Constru��o de Algoritmos
 */
import java.util.Scanner;
public class Jogo {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		boolean teleport = true;
		Repeats repeats = new Repeats();
		Repeats nome = new Repeats();
		Vida vida = new Vida();
		
		System.out.println("\n==========================================");
		System.out.println("Castelo RPG");
		System.out.println("==========================================\n");

		System.out.print("Digite o nome do seu jogador: ");
		nome.setNome(ler.next());
		System.out.println("Ol� " + nome.getNome() + ", bem-vindo ao incr�vel Castelo RPG");
		System.out.println("Voc� foi aprisionado em um castelo");
		System.out.println("Para sair, voc� precisa encontrar a chave e chegar at� o port�o");
		System.out.println("Mas cuidado, com os perigos que voc� poder� encontrar\n\n");

		while (teleport) {
			System.out.println("Voc� acordou em um quarto, com tr�s portas diferentes");
			System.out.println("Escolha uma das 3. Se escolher a certa, nem tudo estar� perdido\n");
			
			String a = "escolher a porta";
			repeats.acoes(a, a, a, true);


			int porta;
			do {
				porta = ler.nextInt();

				switch (porta) {
				case 1:
					System.out.println("Aqui tinha um Le�o, voc� foi atacado! Perdeu 30 de vida");
					vida.dano(-30);
					System.out.printf("Sua vida: %d \n", vida.getVida());
					System.out.println("Escolha outra porta");
					System.out.print("- ");
					break;
				case 2:
					System.out.println("Voc� caiu em um ninho de cobras! Perdeu 20 de vida");
					vida.dano(-20);
					System.out.printf("Sua vida: %d \n", vida.getVida());
					System.out.println("Escolha outra porta");
					System.out.print("- ");
					break;
				case 3:
					System.out.println("Parab�ns, voc� chegou no corredor principal");
					break;
				default:
					System.out.println("Voc� n�o escolheu nenhuma porta, digite novamente");
					System.out.print("- ");
					break;
				}
			} while (porta != 3);

			vida.suaVida();
			// PR�XIMO DESAFIO
			System.out.println("No corredor, voc� encontrou um estranho homem\n");
			System.out.println("Homem Estranho - Ol�! Voc� parece perdido. Eu sei o caminho correto, � s� me seguir");
			
			String b = "seguir o homem";
			String c = "passar direto por ele";
			String d = "atacar o homem";
			repeats.acoes(b, c, d, false);

			int homem;
			do {
				

				homem = ler.nextInt();

				switch (homem) {
				case 1:
					System.out.println("O homem te levou at� uma sala, mas te atacou quando voc� estava desatento");
					System.out.println("Perde 50 de vida!");
					vida.dano(-50);
					System.out.printf("Sua vida: %d \n", vida.getVida());
					System.out.println("Mesmo assim, voc� conseguiu fugir para o sal�o principal");
					break;
				case 2:
					System.out.println("Voc� j� chegou a �rea externa do castelo! A porta est� logo ali");
					System.out.println("Digite 1 para ir at� a porta");
					System.out.println("Digite 2 para retornar ao homem");
					System.out.print("- ");
					int porta2 = ler.nextInt();
					switch (porta2) {
					case 1:
						System.out.println("O homem deixou uma armadilha na porta");
						System.out.println("Voc� perdeu 200 de vida");
						vida.dano(-200);
						break;
					case 2:
						repeats.acoes(b, c, d, false);
						break;
					default:
						System.out.println("Voc� n�o escolheu um op��o poss�vel, digite novamente");
						break;
					}

					break;
				case 3:
					System.out.println("Voc� matou o homem e ele tinha uma po��o no bolso");
					System.out.println("Ganha 40 de vida!");

					if (vida.getVida() <= 60) {
						vida.dano(40);;
					} else {
						vida.setVida(100);
					}

					System.out.printf("Sua vida: %d \n", vida.getVida());
					System.out.println("Agora, voc� seguiu para o sal�o principal");
					break;
				default:
					System.out.println("Voc� n�o escolheu um op��o poss�vel, digite novamente");
					System.out.print("- ");
					break;
				}
			} while (homem != 1 && homem != 3);

			// PR�XIMO DESAFIO
			System.out.println("No sal�o principal, voc� encontra 3 ba�s\n");
			System.out.println("Escolha um dos 3 e voc� poder� achar uma surpresa agrad�vel ... (ou n�o)");

			String e = "escolher o ba� ";
			repeats.acoes(e, e, e, true);
			
			int bau;
			do {
				bau = ler.nextInt();

				switch (bau) {
				case 1:
					System.out.println("Aqui tinha um rato com peste negra, que te atacou na hora. Perdeu 40 de vida");
					vida.dano(-40);;
					System.out.printf("Sua vida: %d \n", vida.getVida());
					System.out.println("Escolha outro ba�");
					System.out.print("- ");
					break;
				case 2:
					System.out.println("Parab�ns, voc� encontrou a chave! Siga para a parte externa do castelo");
					break;
				case 3:
					System.out.println("Voc� encontrou um grande tesouro");
					System.out.println("Mas voc� n�o liga para bens materiais");
					System.out.println("Escolha outro ba�");
					System.out.print("- ");
					break;
				default:
					System.out.println("Voc� n�o escolheu nenhum ba�, digite novamente");
					System.out.print("- ");
					break;
				}
			} while (bau != 2);

			// PR�XIMO DESAFIO
			System.out.println("Na �rea externa, voc� encontra tr�s portas de sa�da");
			System.out.println("Escolha uma das 3");

			repeats.acoes(a, a, a, true);

			int portaFinal;
			do {
				portaFinal = ler.nextInt();

				switch (portaFinal) {
				case 1:
					System.out.println("Parab�ns, voc� encontrou a porta correta e fugiu do castelo!");
					teleport = false;
					break;
				case 2:
					System.out.println("Essa porta tinha um portal que te puxou para o in�cio do jogo");
					System.out.println("Eu sei, ruim isso, n�? Mas � o jogo... \n\n\n");
					System.out.printf("Sua vida: %d \n", vida.getVida());
					teleport = true;
					break;
				case 3:
					System.out.println("Essa porta tinha espinhos, que pularam em voc� na hora que a abriu. Perde 30 de vida!");
					vida.dano(-30);
					System.out.printf("Sua vida: %d \n", vida.getVida());
					System.out.println("Escolha outra porta");
					System.out.print("- ");
					break;
				default:
					System.out.println("Voc� n�o escolheu nenhuma porta, digite novamente");
					System.out.print("- ");
					break;
				}
			} while (portaFinal != 1 && portaFinal != 2);
		}
		System.out.println("\n");
		System.out.println("Parab�ns " + nome.getNome() + "! Voc� conseguiu fugir do castelo!!!");
		
		System.out.println("\n==========================================");
		System.out.println("Cr�ditos:");
		System.out.println("==========================================");
		System.out.println("Ot�vio Lage dos Santos");
		System.out.println("==========================================\n");
		System.out.println("Obrigado por jogar");
	}
}