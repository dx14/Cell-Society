
public class EmptyFire extends Cell{

	public EmptyFire(int x, int y, int sizeX, int sizeY, String value, String shape) {
		super(x, y, sizeX, sizeY, value, shape);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void moveCell(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkForMove(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		return false;
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

}
