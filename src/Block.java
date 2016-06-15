public class Block extends Figure {
	public Block(int startX, int startY) {
		super(startX, startY);
	}
	
	@Override
	public Cell mkAliveCellAt(int x, int y) {
		x = x - startX; // calcola lo spostamento rispetto all’angolo in alto a sinistra della figura
		y = y - startY;
		// le cellule vive sono in coordinate tra 0 e 1, sia ascissa che ordinata
		return 0 <= x && x <= 1 && 0 <= y && y <= 1 ? new Cell(true) : null;
	}
}