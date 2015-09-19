import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

//Any live cell with fewer than two live neighbours dies, as if caused by under-population.
//Any live cell with two or three live neighbours lives on to the next generation.
//Any live cell with more than three live neighbours dies, as if by overcrowding.
//Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

public class Life extends Simulation{

	public Life(double[] dimensions, ArrayList<String> parameters)
			throws SAXException, IOException, ParserConfigurationException {
		super(dimensions, parameters);
		// TODO Auto-generated constructor stub
	}
	
	public void loopThroughCells(){
		String[][] colorList = new String[iGrid.gridRows][iGrid.gridColumns];
		for(int i = 0; i < myDimensions[0]; i++){
			for(int j = 0; j < myDimensions[1]; j++){
				if (myGrid[i][j].getMyColor().equals(iGrid.getEmpty())){
					if (!checkSurroundings(myParameters, i, j)){
						colorList[row][col] = iGrid.getEmpty().toString();
					}
					else{
						colorList[row][col] = myGrid[i][j].getMyColor().toString();
					}
				}
				else{
					if (checkSurroundings(myParameters, i, j)){
						setEmptyToCell(Cell[][] grid, Cell c);
					}
					else{
						continue;
					}
				}
				
			}
		}
	}
	
	public boolean checkSurroundings(ArrayList<String> params, int row, int col) {
		//in Game of Life, check surroundings returns false if cell should die, true if cell should live
		Surroundings neighbors = new Surroundings();
		Cell curr = myGrid[row][col];
		ArrayList<Cell> nbs = neighbors.checkNeighbors(curr, myGrid);
		if (!curr.getMyColor().equals(iGrid.getEmpty())){
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
	
	
	public void moveCell(Cell[][] grid, Cell c) {
	}
	public void setCellToEmpty(Cell[][] grid, Cell c) {
	}
	public void setEmptyToCell(Cell[][] grid, Cell c) {
	}
	public void changeCellType(Cell[][] grid, Cell c) {
	}
	
	

}
