import java.util.ArrayList;

public class EmptyMold extends Cell {

	public EmptyMold(int x, int y, int sizeX, int sizeY, String color, String shape) {
		super(x, y, sizeX, sizeY, color, shape);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkForMove(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		if(this.getMyValue()>0){
			this.setMyColor("GREEN");
		}
		ArrayList<Cell> emptyspots = this.getSurroundingCells(myGrid);
		
		if(this.getMyValue()>1){
			for(int j = 0; j<emptyspots.size(); j++){
				emptyspots.get(j).setMyValue(emptyspots.get(j).getMyValue() +1);
			}
		}
		if(this.getMyValue()>0){
			this.setMyValue(this.getMyValue() -1);
		}
		if(this.getMyValue() == 0 ){
			this.setMyColor("BLACK");
		}
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
