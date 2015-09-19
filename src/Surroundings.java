import java.util.ArrayList;


public class Surroundings {
	Grid Grid = new Grid();
	public ArrayList<Cell> checkNeighbors(Cell curr, Cell[][] allCells){
		
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		int currX = curr.getMyLocation()[0];
		int currY = curr.getMyLocation()[1];
	
		if (currX > 0 && currY > 0) {
			neighbors.add(allCells[currX-1][currY-1]);
		}
		if (currX > 0) {
			neighbors.add(allCells[currX-1][currY]);
		}
		if (currX > 0 && currY < Grid.getGridRows()-1) {
			neighbors.add(allCells[currX-1][currY+1]);
		}
		if (currY > 0) {
			neighbors.add(allCells[currX][currY-1]);
		}
		if (currY < Grid.getGridRows()-1) {
			neighbors.add(allCells[currX][currY+1]);
		}
		if (currX < Grid.getGridColumns()-1 && currY > 0) {
			neighbors.add(allCells[currX+1][currY-1]);
		}
		if (currX < Grid.getGridColumns()-1) {
			neighbors.add(allCells[currX+1][currY]);
		}
		if (currX < Grid.getGridColumns()-1 && currY < Grid.getGridRows()-1) {
			neighbors.add(allCells[currX+1][currY+1]);
		}
		return neighbors;
	}
	
}
