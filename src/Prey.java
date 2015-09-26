import java.util.ArrayList;
import java.util.Random;

public class Prey extends Cell{
	
	public Prey(int x, int y, int sizeX, int sizeY, String value, String shape, int count) {
		super(x, y, sizeX, sizeY, value, shape);
		setMyValue(count);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkForMove(Cell[][] myGrid) {
		
		ArrayList<Cell> surroundingCells = removeCorners(this, myGrid);
		
		for(int i = 0; i < surroundingCells.size();i++){
			if(surroundingCells.get(i).getMyColor().equals("YELLOW")){		
				return false;
			}	
		}

		return true;
	}

	@Override
	public void moveCell(Cell[][] myGrid) {
		
		Cell emptycell = this.getNearestEmptyCell(this, myGrid);
		int x = emptycell.getMyLocation()[0];
		int y = emptycell.getMyLocation()[1];
		int cellX = this.getMyWidth();
		int cellY = this.getMyHeight();
		String color = this.getMyColor();
		String shape = this.getMyShape();
		int count = this.getMyValue() +1;
		int a = this.getMyLocation()[0];
		int b = this.getMyLocation()[1];
	//	System.out.println(x + " " + y + " " + a + " " + b);
		
		
		if(count> 3){
			myGrid[this.getMyLocation()[0]][this.getMyLocation()[1]] = new Prey(this.getMyLocation()[0], this.getMyLocation()[1], cellX, cellY, color, shape,0 );
			myGrid[x][y] = new Prey(x, y, cellX, cellY, color, shape,0 );
		}
		else{
			myGrid[this.getMyLocation()[0]][this.getMyLocation()[1]] = new EmptyWator(this.getMyLocation()[0],this.getMyLocation()[1],cellX, cellY, "BLUE", shape);
			myGrid[x][y] = new Prey(x, y, cellX, cellY, color, shape,count );
		}
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
			if(!this.getMyColor().equals(possiblemoves.get(i).getMyColor())){
				return false;
			}
		}
		
		
		return true;
	
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
	public Cell getNearestEmptyCell(Cell c, Cell[][] myGrid){
		ArrayList<Cell> possiblemoves = removeCorners(c, myGrid);
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
	public Cell getNearByPredatorCell(Cell[][] myGrid){
		ArrayList<Cell> possiblepredator = removeCorners(this, myGrid);
		int i = 0;
		while(i<possiblepredator.size()){
			if(!possiblepredator.get(i).getMyColor().equals("YELLO")){
				possiblepredator.remove(i);
			}
			i++;
		}
		Random ran = new Random();
		
		int move = ran.nextInt(possiblepredator.size());
		return possiblepredator.get(move);
	}
	@Override
	public void updateIfBlocked(Cell[][] myGrid){
		int count = this.getMyValue() +1;	
		int x = this.getMyLocation()[0];
		int y = this.getMyLocation()[1];
		int cellX = this.getMyWidth();
		int cellY = this.getMyHeight();
		String color = this.getMyColor();
		String shape = this.getMyShape();
		
		if(count> 3){
			Cell emptycell = this.getNearestWhenBlocked(myGrid);
			int a = emptycell.getMyLocation()[0];
			int b = emptycell.getMyLocation()[1];
			myGrid[x][y] = new Prey(x, y, cellX, cellY, color, shape, 0);
			myGrid[a][b] = new Prey(a,b,cellX,cellY, color,shape,0);
			
		}
		else{
			myGrid[x][y] = new Prey(x, y, cellX, cellY, color, shape, count);
		}
	}
	@Override
	public void changeCellType(Cell[][] myGrid){
		int x = this.getMyLocation()[0];
		int y = this.getMyLocation()[1];
		int cellX = this.getMyWidth();
		int cellY = this.getMyHeight();
		String shape = this.getMyShape();
		myGrid[x][y] = new Predator(x,y,cellX,cellY,"YELLOW", shape, 0);
		Cell c = this.getNearByPredatorCell(myGrid);
		int a = c.getMyLocation()[0];
		int b = c.getMyLocation()[1];
		myGrid[a][b] = new EmptyWator(a, b, cellX, cellY, "BLUE", shape);
	}


}
