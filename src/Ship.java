
public class Ship extends Figure{

	protected Ship(int startX, int startY) {
		super(startX, startY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cell mkAliveCellAt(int x, int y) {
		x = x - startX; // calcola lo spostamento rispetto all’angolo in alto a sinistra della figura
		y = y - startY;
		if(y==0&&x>=0&&x<=1){
			return new Cell(true);
		}
		if(y==1&&x>=0&&x<=2&&x!=1){
			return new Cell(true);
		}
		if(y==2&&x==1){
			return new Cell(true);
		}
		return null;
	}
	
}
