import java.util.ArrayList;
import java.util.Random;

public class Predator extends Cell{
	private int myValue;
	public Predator(int x, int y, int sizeX, int sizeY, String value, String shape, int count) {
		super(x, y, sizeX, sizeY, value, shape);
		// TODO Auto-generated constructor stub
		myValue = count;
	}

	@Override
	public boolean checkForMove(Cell[][] myGrid) {
		ArrayList<Cell> surroundingCells = removeCorners(this, myGrid);
		
		for(int i = 0; i < surroundingCells.size();i++){
			

				if(surroundingCells.get(i).getMyColor().equals("GREEN")){
					
					return false;
				
			}	
		}
		return true;
	}

	@Override
	public void moveCell(Cell[][] myGrid) {
		Cell emptycell = getNearestEmptyCell(myGrid);
		int x = emptycell.getMyLocation()[0];
		int y = emptycell.getMyLocation()[1];
		int cellX = this.getMyWidth();
		int cellY = this.getMyHeight();
		String color = this.getMyColor();
		String shape = this.getMyShape();
		int count = this.getMyValue() +1;
		
		
		myGrid[this.getMyLocation()[0]][this.getMyLocation()[1]] = new EmptyWator(x,y,cellX, cellY, "BLUE", shape);
		if(count> 5){
			
			myGrid[x][y] = new EmptyWator(x,y,cellX, cellY, "BLUE", shape);
		}
		myGrid[x][y] = new Predator(x, y, cellX, cellY, color, shape,count );
		
	}
	public ArrayList<Cell> removeCorners(Cell c, Cell[][] myGrid){
		ArrayList<Cell> allNeighbors = c.getSurroundingCells(myGrid);
		int xspot = c.getMyLocation()[0];
		int yspot = c.getMyLocation()[1];
		if(c.getMyShape() !=  "Hexagon"){
			for(int i = 0; i <allNeighbors.size(); i++){
				if((xspot != allNeighbors.get(i).getMyLocation()[0]) && (yspot != allNeighbors.get(i).getMyLocation()[1])){
					allNeighbors.remove(i);
				}
			}
		}
		return allNeighbors;
		
	}

	@Override
	public boolean checkIfBlockedIn(Cell[][] myGrid) {

		ArrayList<Cell> possiblemoves = removeCorners(this,myGrid);
		for(int i = 0; i < possiblemoves.size(); i++){
			if(!this.getMyColor().equals(possiblemoves.get(i))){
				return false;
			}
		}
		int count = this.getMyValue() +1;	
		if(count> 5){
			
			int x = this.getMyLocation()[0];
			int y = this.getMyLocation()[1];
			int cellX = this.getMyWidth();
			int cellY = this.getMyHeight();
			String shape = this.getMyShape();
			myGrid[x][y] = new EmptyWator(x,y,cellX,cellY, "BLUE",shape);
			
		}
			
		return true;
	}
	public int getMyValue(){
		return myValue;
	}
	public void setMyValue(int value){
		myValue = value;
	}
	public Cell getNearestEmptyCell(Cell[][] myGrid){
		int x = this.getMyLocation()[0];
		int y = this.getMyLocation()[1];
		ArrayList<Cell> possiblemoves = removeCorners(this, myGrid);
		int i = 0;
		while(i < possiblemoves.size()){
			if(!possiblemoves.get(i).getMyColor().equals("BLUE")){
				possiblemoves.remove(i);
			}
			i++;
		}
		Random ran = new Random();
		
		int move = ran.nextInt(possiblemoves.size());
		return possiblemoves.get(move);
		
		


	}
	public Cell getNearestWhenBlocked(Cell[][] myGrid){
		int x = this.getMyLocation()[0];
		int y = this.getMyLocation()[1];
		int r = (int) Math.sqrt((double) Math.pow(myGrid.length,2.0) + (double) Math.pow(myGrid[0].length, 2.0));
		//System.out.println(r);
		Cell c = myGrid[0][0];
		for (int i = 0; i<myGrid.length; i++){
			for(int j = 0; j< myGrid[0].length; j++){
				if(myGrid[i][j].getMyColor().equals("BLUE")){
					int newr = (int) Math.sqrt((double) Math.pow( (double) Math.abs(x-i) ,2.0) + (double) Math.pow((double) Math.abs(y-j), 2.0));
					
					if(newr < r){
						
						r = newr;
						c = myGrid[i][j];
						//return myGrid[i][j];
					}
				}
			}
		}
		return c;
	}
	@Override
	public void changeCellType(Cell[][] myGrid){
		Cell deadprey = this.getNearByPreyCell(myGrid);
		
		int x = deadprey.getMyLocation()[0];
		int y = deadprey.getMyLocation()[1];
		int cellX = this.getMyWidth();
		int cellY = this.getMyHeight();
		String shape = this.getMyShape();
		myGrid[x][y] = new EmptyWator(x, y, cellX, cellY, "BLUE", shape);
	}
	public Cell getNearByPreyCell(Cell[][] myGrid){
		ArrayList<Cell> possibleprey = removeCorners(this, myGrid);
		int i = 0;
		while(i<possibleprey.size()){
			if(!possibleprey.get(i).getMyColor().equals("GREEN")){
				possibleprey.remove(i);
			}
			i++;
		}
		Random ran = new Random();
		
		int move = ran.nextInt(possibleprey.size());
		return possibleprey.get(move);
	}
}
