
public class Food extends Cell{

	public Food(int x, int y, int sizeX, int sizeY, String value, String shape) {
		super(x, y, sizeX, sizeY, value, shape);
		setMyfPher(10000);
	}

	@Override
	public boolean checkForMove(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void moveCell(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkIfBlockedIn(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void changeCellType(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateIfBlocked(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		
	}

}
