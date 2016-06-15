import java.util.Iterator;

public class Cell {
	private final boolean alive; 
	public Cell(boolean alive) {
		this.alive=alive;
	} // costruisce una cellula, specificando se viva o morta
	
	public String toString() {  
		if(this.alive){
			return "*";
		}
		return " ";
	} // stringa di un solo carattere, asterisco o spazio
	
	public Cell next(Iterable<Cell> neighbors) {  
		Iterator p = neighbors.iterator();
		int i=0;
		for(Cell a : neighbors){
			if(a.alive){
				i++;
			}
		}
		if(this.alive){
			if(i==2||i==3){
				return new Cell(true);
			}else{
				return new Cell(false);
			}
		}else{
			if(i==3){
				return new Cell(true);
			}else{
				return new Cell(false);
			}
		}
	}
}
