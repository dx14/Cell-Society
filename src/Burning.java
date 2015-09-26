import java.util.Random;

public class Burning extends Cell{

	public Burning(int x, int y, int sizeX, int sizeY, String value, String shape) {
		super(x, y, sizeX, sizeY, value, shape);
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public boolean checkForMove(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		double randomValue = rand.nextDouble();
		double probCatch = .2;
		if (randomValue < probCatch) return true;
		return false;
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
