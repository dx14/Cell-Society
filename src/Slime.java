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
		return true;
	}

	@Override
	public void moveCell(Cell[][] myGrid) {
		ArrayList<Cell> moves = this.getSurroundingCells(myGrid);
		ArrayList<Cell> spots = this.getSurroundingCells(myGrid);
		
		int j = 0;
		while(j< moves.size()){
			if(moves.get(j).getMyColor().equals("RED")){
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
		for(int n = 0; n<spots.size();n++){
			spots.get(n).setMyValue(spots.get(n).getMyValue()+1);
		}
		int x = go.getMyLocation()[0];
		int y = go.getMyLocation()[1];
		int a = this.getMyLocation()[0];
		int b = this.getMyLocation()[1];
		int cellX = this.getMyWidth();
		int cellY = this.getMyHeight();
		int currentval = this.getMyValue();
		String shape = this.getMyShape();
		myGrid[x][y] = new Slime(x,y,cellX, cellY, "RED", shape);
		myGrid[a][b] = new EmptyMold(a,b,cellX,cellY, "GREEN", shape);
		myGrid[x][y].setMyValue(0);
		myGrid[a][b].setMyValue(1);
		
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
