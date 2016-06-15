
public class Blinker extends Figure{

	protected Blinker(int startX, int startY) {
		super(startX, startY);
	}

	@Override
	public Cell mkAliveCellAt(int x, int y) {
		x = x - startX; // calcola lo spostamento rispetto all’angolo in alto a sinistra della figura
		y = y - startY;
		return 0 <= x && x <= 2 && 0 <= y ? new Cell(true) : null;
	}

}
