import java.util.ArrayList;
import java.util.List;

public class Board {
	private final int width;
	private final int height;
	private final Cell[][] cells;
	
	// costruisce una tabella delle dimensioni indicate e in cui sono posizionate
	// le figure indicate. Altrove le cellule devono essere inizialmente morte
	public Board(int width, int height, Figure... figures) { 
		this.height=height;
		this.width=width;
		this.cells= new Cell[this.width][this.height];
		for(int x=0; x < this.width;x++){
			for(int y=0; y < this.height; y++){
				cells[x][y]=auxilia(x,y,figures);
			}
		}
	}
	
	private Cell auxilia(int x, int y, Figure... figures){
		for(Figure figura:figures){
			Cell temp = figura.mkAliveCellAt(x, y);
			if(temp!=null){
				return temp;
			}
		}
		return new Cell(false);
	}
	
	// fa passare le cellule della tabella alla loro configurazione successiva
	public void recomputeCells() {  
		Cell[][] temp=this.cells;
		for(int y=0; y<this.height; y++){
			for(int x=0; x<this.width; x++){
				temp[x][y].next(this.getVicini(x, y));
			}
		}
		for(int y=0; y<this.height; y++){
			for(int x=0; x<this.width; x++){
				this.cells[x][y]=temp[x][y];
			}
		}
	}
	
	private Iterable<Cell> getVicini(int x, int y){
		List<Cell> temp = new ArrayList<Cell>();
		for(int dx=-1; dx<=1; dx++){
			for(int dy=-1; dy<=1; dy++){
				if((x+dx)<this.width && (x+dx)>=0 && (y+dy)>=0 && (y+dy)<=this.height){
					if(dx!=0 && dy!=0){
						temp.add(this.cells[x+dx][y+dy]);
					}
				}
			}
		}
		return temp;
		
	}
	
	// restituisce una descrizione della tabella, fatta da spazi e asterischi,
	// come quella mostrata all’inizio del compito
	public String toString() {
		String result="";
		for(int y=0; y<this.height; y++){
			for(int x=0; x<this.width; x++){
				result+=this.cells[x][y].toString();
			}
			result+="/n";
		}
		return result;
	}
}
