
public class Vida {
	
	private int vida = 100;
	
	public void setVida(int vida) {
		this.vida = vida;
		if(vida <= 0);
	}
	public int getVida() {
		return vida;
	}
	public void dano(int dano){
		this.vida += dano;
		if (this.vida <= 0) {
			System.out.println("- GAME OVER -");
			System.exit(0);
		}
	}
	public void suaVida() {
		System.out.printf("Sua vida: %d \n", this.vida);
	}

}
