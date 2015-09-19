import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

//Any live cell with fewer than two live neighbours dies, as if caused by under-population.
//Any live cell with two or three live neighbours lives on to the next generation.
//Any live cell with more than three live neighbours dies, as if by overcrowding.
//Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

public class Life{
	Scene myScene;
	private Group root;
	public void setScene(Scene ss){
		myScene = ss;
	}
	
	public String[][] segStep(Stage s, Cell[][] cells){
		String[][] newColors = new String[Grid.gridColumns][Grid.gridRows];
		for (int col = 0; col < Grid.gridColumns; col++) {
			for (int row = 0; row < Grid.gridRows; row++) {
				if (cells[row][col].getMyColor().equals("WHITE")) {
					if (checkSurroundings(cells[row][col], cells)){
						cells[row][col].setMyColor("BLACK");
					}
					else{
						cells[row][col].setMyColor("WHITE");
					}
				}
				else{
					if (!checkSurroundings(cells[row][col], cells)){
						cells[row][col].setMyColor("WHITE");
					}
					else{
						cells[row][col].setMyColor("BLACK");
					}
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
	
	public boolean checkSurroundings(Cell cell, Cell[][] myGrid) {
		//in Game of Life, check surroundings returns false if cell should die, true if cell should live
		ArrayList<Cell> nbs = checkNeighbors(cell, myGrid);
		
		int numDead = 0;
		for (Cell c: nbs){
			if (c.getMyColor().equals("BLACK")){
				numDead++;
			}
				
		}
		if (!cell.getMyColor().equals("WHITE")) {
			//cell is alive
			if (numDead < 2 || numDead > 3){
				return false;
			}
			else{
				return true;
			}
		}
		else{
			//cell is dead
			if (numDead == 3){
				return true;
			}
			else{
				return false;
			}
		}
	}

	public void setRoot(Group r){
		root = r;
	}
	
	
//	public void moveCell(Cell[][] grid, Cell c) {
//	}
//	public void setCellToEmpty(Cell[][] grid, Cell c) {
//	}
//	public void setEmptyToCell(Cell[][] grid, Cell c) {
//	}
//	public void changeCellType(Cell[][] grid, Cell c) {
//	}
	
	

}
