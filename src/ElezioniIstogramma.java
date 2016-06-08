import java.util.Random;

public class ElezioniIstogramma extends Elezioni{
	
	@Override
	public String toString() {
		String temp = super.toString() +"\n";
		int n=1;
		int a=0;
		for(Partito partito : Partito.elementi()){
			for(int i=0; i< Math.rint((100.0*this.votiPer(partito)/this.numeroVotiEspressi())/2);i++){
				temp+=n;
				a++;
			}
			n++;
		}
		System.out.println("L = "+a);
		return temp;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		Partito[] partiti = Partito.values();
		ElezioniIstogramma elezioni = new ElezioniIstogramma();

		for (Partito partito: partiti) {
			int voti = random.nextInt(10000);
			for (int i = 0; i < voti; i++)
				elezioni.vota(partito);
		}

		System.out.println(elezioni);
	}
}
