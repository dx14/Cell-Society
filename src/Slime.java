import java.util.ArrayList;
import java.util.Random;

public class Slime extends Cell{

	public Slime(int x, int y, int sizeX, int sizeY, String color, String shape) {
		super(x, y, sizeX, sizeY, color, shape);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkForMove(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		return !this.checkIfBlockedIn(myGrid);
	}

	@Override
	public void moveCell(Cell[][] myGrid) {
		ArrayList<Cell> moves = this.getSurroundingCells(myGrid);
		int j = 0;
		while(j< moves.size()){
			if(moves.get(j).getMyValue() >=10){
				moves.remove(j);
			}
			j++;
		}
		Random ran = new Random();
		int val = ran.nextInt(moves.size());
		Cell go = moves.get(val);
		for(int k = 0; k<moves.size(); k++){
			if(go.getMyValue() < moves.get(k).getMyValue()){
				go = moves.get(k);
			}
			
		}
		int x = go.getMyLocation()[0];
		int y = go.getMyLocation()[1];
		int a = this.getMyLocation()[0];
		int b = this.getMyLocation()[1];
		int cellX = this.getMyWidth();
		int cellY = this.getMyHeight();
		String shape = this.getMyShape();
		myGrid[x][y] = new Slime(x,y,cellX, cellY, "RED", shape);
		
		
	}

	@Override
	public boolean checkIfBlockedIn(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		ArrayList<Cell> nbs = this.getSurroundingCells(myGrid);
		for(int i = 0; i< nbs.size(); i++){
			if(!nbs.get(i).getMyColor().equals("RED")){
				return false;
			}
		}
		return true;
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
