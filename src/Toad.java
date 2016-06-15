
public class Toad extends Figure{

	protected Toad(int startX, int startY) {
		super(startX, startY);
	}

	@Override
	public Cell mkAliveCellAt(int x, int y) {
		x = x - startX; 
		y = y - startY;
		return y==0 && x>=1 && x<=3 || y==1 && x>=0 &&x <=2 ? new Cell(true):null;
	}

}
