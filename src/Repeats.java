
public class Repeats {

	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public static void acoes(String text1, String text2, String text3, boolean numeracao) {
		String text[] = {text1, text2, text3};
		for (int j = 1; j <= 3; j++) {
			System.out.print("Digite " + j +  " para " + text[j-1]);
			if(numeracao){
				System.out.println(" " + j);
			} else {
				System.out.println();
			}
		}
		System.out.print("- ");
	}
}
