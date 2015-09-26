import java.util.ArrayList;

public class LifePerson extends Cell{

	public LifePerson(int x, int y, int sizeX, int sizeY, String value, String shape) {
		super(x, y, sizeX, sizeY, value, shape);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkForMove(Cell[][] myGrid) {

		ArrayList<Cell> nbs = this.getSurroundingCells(myGrid);
		
		int alive = 0;
		for (Cell c: nbs){
			if (c.getMyColor().equals("BLACK")){
				alive++;
			}
				
		}
	
		if (alive == 2 || alive == 3){
			return true;
		}
		else{
			
			return false;
		}
		
		
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
