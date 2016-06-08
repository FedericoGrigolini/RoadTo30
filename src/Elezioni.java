import java.util.Iterator;
import java.util.Random;

public class Elezioni implements Iterable<VotiPerPartito> {
	private int[] votiPartiti = new int[Partito.NUMERO_PARTITI];
		
	public void vota(Partito partito){
		this.votiPartiti[ partito.indice()]++;
	}
	
	@Override
	public String toString(){
		String temp="Risultati elezioni:\n\n";
		int nvoti = this.numeroVotiEspressi();
		int n= 1;
		for(Partito partito: Partito.elementi()){
			temp+= String.format("%d %15s: %5d voti(%.2f%%)\n",
					n++,
					partito,
					this.votiPer(partito),
					100.0*this.votiPer(partito)/nvoti);
		}
		
		return temp;
	}
	
	protected final int numeroVotiEspressi(){
		int sum=0;
		for(Partito part : Partito.elementi()){
			sum+=this.votiPer(part);
		}
		return sum;
	}
	
	protected final int votiPer(Partito partito){
		return this.votiPartiti[partito.indice()];
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		Partito[] partiti = Partito.values();
		Elezioni elezioni = new Elezioni();//new ElezioniIstogramma();

		for (Partito partito: partiti) {
			int voti = random.nextInt(10000);
			for (int i = 0; i < voti; i++)
				elezioni.vota(partito);
		}

		System.out.println(elezioni);
	}

	@Override
	public final Iterator<VotiPerPartito> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator();
		
	}
	
	private class MyIterator implements Iterator<VotiPerPartito>{
		private int n;
		@Override
		public boolean hasNext() {
			return n < Partito.NUMERO_PARTITI;
		}

		@Override
		public VotiPerPartito next() {
			Partito prox = Partito.elementi()[n++]; 
			return new VotiPerPartito(prox, votiPer(prox));
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub	
		}
		
	}

}
