import java.util.ArrayList;
import java.util.Random;

public class Home extends Cell{

	public Home(int x, int y, int sizeX, int sizeY, String value, String shape) {
		super(x, y, sizeX, sizeY, value, shape);
		setMyhPher(10000);
	}

	@Override
	public boolean checkForMove(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void moveCell(Cell[][] myGrid) {
		ArrayList<Cell> spots = getSurroundingCells(myGrid);
		Random ran = new Random();
		int i = ran.nextInt(spots.size());
		int j = ran.nextInt(spots.size());
		Cell c1 = spots.get(i);
		Cell c2 = spots.get(j);
		int v1 = c1.getMyValue();
		int v2 = c2.getMyValue();
		myGrid[c1.getMyLocation()[0]][c1.getMyLocation()[1]].setMyValue(v1 +1);
		myGrid[c2.getMyLocation()[0]][c2.getMyLocation()[1]].setMyValue(v2 +1);
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
