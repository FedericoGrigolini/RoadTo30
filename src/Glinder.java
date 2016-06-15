
public class Glinder extends Figure{

	protected Glinder(int startX, int startY) {
		super(startX, startY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cell mkAliveCellAt(int x, int y) {
		return y==0 && x>=0 && x<=2||
				y==1 && x==0||
				y==2 && x==1 ? new Cell(true) : null;
	}

}
