import java.util.ArrayList;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
	public class Segregation {
		
		Grid myGrid = new Grid();
		private int FRAMES_PER_SECOND = 2;
		private int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
//		private double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
		private Timeline animation;
		private Group root;
//		private Cell[][] newCells;
		double minRate = .3;
		Scene myScene;
		
		public void setScene(Scene ss){
			myScene = ss;
		}
		
		public String[][] segStep (Stage s, Cell[][] cells) {
			String[][] newColors = new String[Grid.gridColumns][Grid.gridRows];
			for (int col = 0; col < Grid.gridColumns; col++) {
				for (int row = 0; row < Grid.gridRows; row++) {
					Cell curr = cells[col][row];
					if (needsToMove(curr, cells)) {
						moveCell(curr, cells);
					}
				}
			}
			for(int i=0; i < cells.length; i++) {
				  for(int j=0; j< cells[i].length; j++) {
				    newColors[i][j] = cells[i][j].getMyColor();
				  }
			}
			return newColors;
		}
			
		public void setRoot(Group r){
			root = r;
		}
		
		
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
			if (currX > 0 && currY < Grid.gridRows-1) {
				neighbors.add(allCells[currX-1][currY+1]);
			}
			if (currY > 0) {
				neighbors.add(allCells[currX][currY-1]);
			}
			if (currY < Grid.gridRows-1) {
				neighbors.add(allCells[currX][currY+1]);
			}
			if (currX < Grid.gridColumns-1 && currY > 0) {
				neighbors.add(allCells[currX+1][currY-1]);
			}
			if (currX < Grid.gridColumns-1) {
				neighbors.add(allCells[currX+1][currY]);
			}
			if (currX < Grid.gridColumns-1 && currY < Grid.gridRows-1) {
				neighbors.add(allCells[currX+1][currY+1]);
			}
			return neighbors;
		}
		public ArrayList<Cell> nbList(Cell current, Cell[][] cells) {
			ArrayList<Cell> myNeighbors = new ArrayList<Cell>(checkNeighbors(current, cells));
			return myNeighbors;
		}
		
		public int totalNeighbors(Cell current, Cell[][] cells) {
			int total;
			ArrayList<Cell> nb = new ArrayList<Cell>(nbList(current, cells));
			total = nb.size();
			return total;
		}
		
		public double satisfactionRate (Cell current, Cell[][] cells) {
			ArrayList<Cell> nbList = new ArrayList<Cell> (nbList(current, cells));
			double nbTotal = totalNeighbors(current, cells);
			double nbSame = 0;
			for (int i = 0; i < nbList.size(); i++) {
				if (current.getMyColor().equals(nbList.get(i).getMyColor())) {
					nbSame++;
				}
			}
			return nbSame/nbTotal;
		}
		
		public boolean needsToMove (Cell current, Cell[][] cells) {
			double rate = satisfactionRate(current, cells);
			if (rate >= minRate) {
				return false;
			}
			return true;
		}
		
		public void moveCell (Cell current, Cell[][] allCells) {
			outerloop:
			for (int row = 0; row < allCells.length; row++) {
				for (int col = 0; col < allCells[row].length; col++) {
					Cell newCell = allCells[row][col];
					if (newCell.getMyColor().equals("WHITE")) {
						newCell.setMyColor(current.getMyColor());
						break outerloop;
					} 
				} 
			}
			current.setMyColor("WHITE");
		}
	}
