import java.util.ArrayList;

public class PopOne extends Cell {

	public PopOne(int x, int y, int sizeX, int sizeY, String value, String shape) {
		super(x, y, sizeX, sizeY, value, shape);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkForMove(Cell[][] myGrid) {
		
		double minRate = .3;
		double rate = satisfactionRate(this, myGrid);
		if (rate >= minRate) {
			return false;
		}
		return true;
	}
	public double satisfactionRate (Cell current, Cell[][] myGrid) {
		ArrayList<Cell> nbList = new ArrayList<Cell> (getNeighbors(current.getSurroundingCells(myGrid)));
		double nbTotal = nbList.size();
		double nbSame = 0;
		for (int i = 0; i < nbList.size(); i++) {
			if (current.getMyColor().equals(nbList.get(i).getMyColor())) {
				nbSame++;
			}
		}
		return nbSame/nbTotal;
	}
	public ArrayList<Cell> getNeighbors(ArrayList<Cell> surroundings){
		
		for(int i = 0; i<surroundings.size(); i++){
			if(surroundings.get(i).getMyColor().equals("WHITE")){
				surroundings.remove(i);
			}
		}
		return surroundings;
	}

	@Override
	public void moveCell(Cell[][] myGrid) {
		int x = this.getMyLocation()[0];
		int y = this.getMyLocation()[1];
		int r = (int) Math.sqrt((double) Math.pow(myGrid.length,2.0) + (double) Math.pow(myGrid[0].length, 2.0));
		
		Cell c = myGrid[0][0];
		for (int i = 0; i<myGrid.length; i++){
			for(int j = 0; j< myGrid[0].length; j++){
				if(myGrid[i][j].getMyColor().equals("WHITE")){
					int newr = (int) Math.sqrt((double) Math.pow( (double) Math.abs(x-i) ,2.0) + (double) Math.pow((double) Math.abs(y-j), 2.0));
					
					if(newr < r){
						
						r = newr;
						c = myGrid[i][j];
						
					}
				}
			}
		}
		int cellX = this.getMyWidth();
		int cellY = this.getMyHeight();
		String color = this.getMyColor();
		String shape = this.getMyShape();
		int newX = c.getMyLocation()[0];
		int newY = c.getMyLocation()[1];
		myGrid[newX][newY] = new PopOne(newX, newY, cellX, cellY, color, shape);
		myGrid[x][y] = new EmptyPop(x, y, cellX, cellY, "WHITE", shape);
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
