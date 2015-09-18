import java.util.ArrayList;

import javafx.stage.Stage;


public class Neighbors {
	private Grid myGrid = new Grid();
	private final Cell[][] allCells = myGrid.getCells();
	private final int gridX = myGrid.getGridColumns();
	private final int gridY = myGrid.getGridRows();
	private final String empty = myGrid.getEmpty();
	private String[][] nextCellColor = new String[gridX][gridY];
	
	public ArrayList<Cell> checkNeighbors(Cell current){
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		int x = current.getMyLocation().width;
		int y = current.getMyLocation().height;
		if (x-1 != 0 && y-1 != 0){
			neighbors.add(allCells[x-1][y-1]);
		}
		if (x-1 != 0 && y != 0){
			neighbors.add(allCells[x-1][y]);
		}
		if (x-1 != 0 && y+1 != gridY){
			neighbors.add(allCells[x-1][y+1]);
		}
		if (x != 0 && y-1 != 0){
			neighbors.add(allCells[x][y-1]);
		}
		if (x != 0 && y+1 != gridY){
			neighbors.add(allCells[x][y+1]);
		}
		if (x+1 != gridX && y-1 != 0){
			neighbors.add(allCells[x+1][y-1]);
		}
		if (x+1 != gridX && y != 0){
			neighbors.add(allCells[x+1][y]);
		}
		if (x+1 != gridX && y+1 != gridY){
			neighbors.add(allCells[x+1][y+1]);
		}
		return neighbors;
	}
}
