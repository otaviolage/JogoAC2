/*RPG
 Gabriel Oliveira
 Matheus Oliveira
 Otávio Lage dos Santos
 AC2 da matéria Construção de Algoritmos
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
		System.out.println("Olá " + nome.getNome() + ", bem-vindo ao incrível Castelo RPG");
		System.out.println("Você foi aprisionado em um castelo");
		System.out.println("Para sair, você precisa encontrar a chave e chegar até o portão");
		System.out.println("Mas cuidado, com os perigos que você poderá encontrar\n\n");

		while (teleport) {
			System.out.println("Você acordou em um quarto, com três portas diferentes");
			System.out.println("Escolha uma das 3. Se escolher a certa, nem tudo estará perdido\n");
			
			String a = "escolher a porta";
			repeats.acoes(a, a, a, true);


			int porta;
			do {
				porta = ler.nextInt();

				switch (porta) {
				case 1:
					System.out.println("Aqui tinha um Leão, você foi atacado! Perdeu 30 de vida");
					vida.dano(-30);
					System.out.printf("Sua vida: %d \n", vida.getVida());
					System.out.println("Escolha outra porta");
					System.out.print("- ");
					break;
				case 2:
					System.out.println("Você caiu em um ninho de cobras! Perdeu 20 de vida");
					vida.dano(-20);
					System.out.printf("Sua vida: %d \n", vida.getVida());
					System.out.println("Escolha outra porta");
					System.out.print("- ");
					break;
				case 3:
					System.out.println("Parabéns, você chegou no corredor principal");
					break;
				default:
					System.out.println("Você não escolheu nenhuma porta, digite novamente");
					System.out.print("- ");
					break;
				}
			} while (porta != 3);

			vida.suaVida();
			// PRÓXIMO DESAFIO
			System.out.println("No corredor, você encontrou um estranho homem\n");
			System.out.println("Homem Estranho - Olá! Você parece perdido. Eu sei o caminho correto, é só me seguir");
			
			String b = "seguir o homem";
			String c = "passar direto por ele";
			String d = "atacar o homem";
			repeats.acoes(b, c, d, false);

			int homem;
			do {
				

				homem = ler.nextInt();

				switch (homem) {
				case 1:
					System.out.println("O homem te levou até uma sala, mas te atacou quando você estava desatento");
					System.out.println("Perde 50 de vida!");
					vida.dano(-50);
					System.out.printf("Sua vida: %d \n", vida.getVida());
					System.out.println("Mesmo assim, você conseguiu fugir para o salão principal");
					break;
				case 2:
					System.out.println("Você já chegou a área externa do castelo! A porta está logo ali");
					System.out.println("Digite 1 para ir até a porta");
					System.out.println("Digite 2 para retornar ao homem");
					System.out.print("- ");
					int porta2 = ler.nextInt();
					switch (porta2) {
					case 1:
						System.out.println("O homem deixou uma armadilha na porta");
						System.out.println("Você perdeu 200 de vida");
						vida.dano(-200);
						break;
					case 2:
						repeats.acoes(b, c, d, false);
						break;
					default:
						System.out.println("Você não escolheu um opção possível, digite novamente");
						break;
					}

					break;
				case 3:
					System.out.println("Você matou o homem e ele tinha uma poção no bolso");
					System.out.println("Ganha 40 de vida!");

					if (vida.getVida() <= 60) {
						vida.dano(40);;
					} else {
						vida.setVida(100);
					}

					System.out.printf("Sua vida: %d \n", vida.getVida());
					System.out.println("Agora, você seguiu para o salão principal");
					break;
				default:
					System.out.println("Você não escolheu um opção possível, digite novamente");
					System.out.print("- ");
					break;
				}
			} while (homem != 1 && homem != 3);

			// PRÓXIMO DESAFIO
			System.out.println("No salão principal, você encontra 3 baús\n");
			System.out.println("Escolha um dos 3 e você poderá achar uma surpresa agradável ... (ou não)");

			String e = "escolher o baú ";
			repeats.acoes(e, e, e, true);
			
			int bau;
			do {
				bau = ler.nextInt();

				switch (bau) {
				case 1:
					System.out.println("Aqui tinha um rato com peste negra, que te atacou na hora. Perdeu 40 de vida");
					vida.dano(-40);;
					System.out.printf("Sua vida: %d \n", vida.getVida());
					System.out.println("Escolha outro baú");
					System.out.print("- ");
					break;
				case 2:
					System.out.println("Parabéns, você encontrou a chave! Siga para a parte externa do castelo");
					break;
				case 3:
					System.out.println("Você encontrou um grande tesouro");
					System.out.println("Mas você não liga para bens materiais");
					System.out.println("Escolha outro baú");
					System.out.print("- ");
					break;
				default:
					System.out.println("Você não escolheu nenhum baú, digite novamente");
					System.out.print("- ");
					break;
				}
			} while (bau != 2);

			// PRÓXIMO DESAFIO
			System.out.println("Na área externa, você encontra três portas de saída");
			System.out.println("Escolha uma das 3");

			repeats.acoes(a, a, a, true);

			int portaFinal;
			do {
				portaFinal = ler.nextInt();

				switch (portaFinal) {
				case 1:
					System.out.println("Parabéns, você encontrou a porta correta e fugiu do castelo!");
					teleport = false;
					break;
				case 2:
					System.out.println("Essa porta tinha um portal que te puxou para o início do jogo");
					System.out.println("Eu sei, ruim isso, né? Mas é o jogo... \n\n\n");
					System.out.printf("Sua vida: %d \n", vida.getVida());
					teleport = true;
					break;
				case 3:
					System.out.println("Essa porta tinha espinhos, que pularam em você na hora que a abriu. Perde 30 de vida!");
					vida.dano(-30);
					System.out.printf("Sua vida: %d \n", vida.getVida());
					System.out.println("Escolha outra porta");
					System.out.print("- ");
					break;
				default:
					System.out.println("Você não escolheu nenhuma porta, digite novamente");
					System.out.print("- ");
					break;
				}
			} while (portaFinal != 1 && portaFinal != 2);
		}
		System.out.println("\n");
		System.out.println("Parabéns " + nome.getNome() + "! Você conseguiu fugir do castelo!!!");
		
		System.out.println("\n==========================================");
		System.out.println("Créditos:");
		System.out.println("==========================================");
		System.out.println("Otávio Lage dos Santos");
		System.out.println("==========================================\n");
		System.out.println("Obrigado por jogar");
	}
}