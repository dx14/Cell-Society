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

public class Life extends Simulation{
	

	Scene myScene;
	private Group root;
	public Grid iGrid = new Grid();
	protected Cell[][] myGrid = iGrid.getCells();
	public void setScene(Scene ss){
		myScene = ss;
	}
	public Life(double[] dimensions, ArrayList<String> parameters)
			throws SAXException, IOException, ParserConfigurationException {
		super(dimensions, parameters);
		// TODO Auto-generated constructor stub
	}
//	public String[][] segStep(Stage s, Cell[][] cells){
//		myGrid = cells;
//		String[][] newColors = new String[Grid.gridColumns][Grid.gridRows];
//		
//		
//		for(int i=0; i < cells.length; i++) {
//			for(int j=0; j< cells[i].length; j++) {
//				newColors[i][j] = cells[i][j].getMyColor();
//			}
//		}
//		
//		return newColors;
//	}
	@Override
	public void loopThroughCells(){
		for (int col = 0; col < Dom.dimensionX; col++) {
			for (int row = 0; row < Dom.dimensionY; row++) {
				int cellwidth = myGrid[row][col].getMyWidth();
				int cellheight = myGrid[row][col].getMyHeight();
				String cellshape = myGrid[row][col].getMyShape();
				if (myGrid[row][col].checkForMove(myGrid)) {
						
					myGrid[row][col] = new LifePerson(row, col, cellwidth, cellheight, "BLACK", cellshape );
//					if (checkForMove(row,col)){
//						myGrid[row][col].setMyColor("BLACK");
//					}
//					else{
//						myGrid[row][col].setMyColor("WHITE");
//					}
				}
				else{
					myGrid[row][col] = new EmptyLife(row, col, cellwidth, cellheight, "WHITE", cellshape );
//					if (!checkForMove(row,col)){
//						myGrid[row][col].setMyColor("WHITE");
//					}
//					else{
//						myGrid[row][col].setMyColor("BLACK");
//					}
				}
				
			}
		}
	}
	
	@Override
	public boolean checkForMove(int x, int y) {
		//in Game of Life, check surroundings returns false if cell should die, true if cell should live
		ArrayList<Cell> nbs = myGrid[x][y].getSurroundingCells(myGrid);

		int numDead = 0;
		for (Cell c: nbs){
			if (c.getMyColor().equals("BLACK")){
				numDead++;
			}
				
		}
		if (!myGrid[x][y].getMyColor().equals("WHITE")) {
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
	@Override
	public void moveCell(Cell c) {
		// TODO Auto-generated method stub
		
	}

//	public void setRoot(Group r){
//		root = r;
//	}
	
	
//	public void moveCell(Cell[][] grid, Cell c) {
//	}
//	public void setCellToEmpty(Cell[][] grid, Cell c) {
//	}
//	public void setEmptyToCell(Cell[][] grid, Cell c) {
//	}
//	public void changeCellType(Cell[][] grid, Cell c) {
//	}
	
	

}
