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
	Grid iGrid = new Grid();
	Scene myScene;
	private Group root;
	public void setScene(Scene ss){
		myScene = ss;
	}
	
	public String[][] segStep(Stage s, Cell[][] cells){
		String[][] newColors = new String[Grid.gridColumns][Grid.gridRows];
		for (int col = 0; col < Grid.gridColumns; col++) {
			for (int row = 0; row < Grid.gridRows; row++) {
				if (cells[row][col].getMyColor().equals(iGrid.getEmpty())){
					if (!checkSurroundings(cells[row][col], cells)){
						newColors[row][col] = iGrid.getEmpty().toString();
					}
					else{
						newColors[row][col] = cells[row][col].getMyColor().toString();
					}
				}
				else{
					if (checkSurroundings(cells[row][col], cells)){
						newColors[row][col] = iGrid.getColors().get(0);
					}
					else{
						newColors[row][col] = cells[row][col].getMyColor().toString();
					}
				}
				
			}
		}
		return newColors;
	}
	
	public boolean checkSurroundings(Cell cell, Cell[][] myGrid) {
		//in Game of Life, check surroundings returns false if cell should die, true if cell should live
		Surroundings neighbors = new Surroundings();
		ArrayList<Cell> nbs = neighbors.checkNeighbors(cell, myGrid);
		if (!cell.getMyColor().equals(iGrid.getEmpty())){
			//cell is alive
			if (nbs.size() < 2 || nbs.size() > 3){
				return false;
			}
			else{
				return true;
			}
		}
		else{
			//cell is dead
			if (nbs.size() == 3){
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
