import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fire extends Simulation{


	Scene myScene;
	private Group root;
	double probCatch = .2;
	public Grid iGrid = new Grid();
	protected Cell[][] myGrid = iGrid.getCells();
	public Fire(double[] dimensions, ArrayList<String> parameters)
			throws SAXException, IOException, ParserConfigurationException {
		super(dimensions, parameters);
		// TODO Auto-generated constructor stub
	}
//	public void setScene(Scene ss){
//		myScene = ss;
//	}
//	
//	public void setRoot(Group r){
//		root = r;
//	}

//	public String[][] segStep(Stage s, Cell[][] cells) {
//		myGrid = cells;
//		String[][] newColors = new String[Grid.gridColumns][Grid.gridRows];
//		loopThroughCells();
//
//		for(int i=0; i < cells.length; i++) {
//			for(int j=0; j< cells[i].length; j++) {
//				newColors[i][j] = cells[i][j].getMyColor();
//			}
//		}
//		return newColors;
//	}
	@Override
	public void loopThroughCells(){
		for (int col = 0; col < Grid.gridColumns; col++) {
			for (int row = 0; row < Grid.gridRows; row++) {
				Cell curr = myGrid[col][row];
				if (curr.getMyColor().equals("RED")) {
					ArrayList<Cell> nb = new ArrayList<Cell>(nbList(curr));
					for (Cell cell : nb) {
						if (catchFire(curr)) {
							int x = cell.getMyLocation()[0];
							int y = cell.getMyLocation()[1];
							if (!myGrid[x][y].getMyColor().equals("YELLOW"))
							myGrid[x][y].setMyColor(("RED"));
						}
						else{
							continue;
						}
					}
				}
			}
		}
	}
	
//	public ArrayList<Cell> checkNeighbors(Cell curr){
//
//		ArrayList<Cell> surroundingCells = new ArrayList<Cell>();
//		int currX = curr.getMyLocation()[0];
//		int currY = curr.getMyLocation()[1];
//
//		if (currX > 0 && currY > 0) {
//			surroundingCells.add(myGrid[currX-1][currY-1]);
//		}
//		if (currX > 0) {
//			surroundingCells.add(myGrid[currX-1][currY]);
//		}
//		if (currX > 0 && currY < Grid.gridRows-1) {
//			surroundingCells.add(myGrid[currX-1][currY+1]);
//		}
//		if (currY > 0) {
//			surroundingCells.add(myGrid[currX][currY-1]);
//		}
//		if (currY < Grid.gridRows-1) {
//			surroundingCells.add(myGrid[currX][currY+1]);
//		}
//		if (currX < Grid.gridColumns-1 && currY > 0) {
//			surroundingCells.add(myGrid[currX+1][currY-1]);
//		}
//		if (currX < Grid.gridColumns-1) {
//			surroundingCells.add(myGrid[currX+1][currY]);
//		}
//		if (currX < Grid.gridColumns-1 && currY < Grid.gridRows-1) {
//			surroundingCells.add(myGrid[currX+1][currY+1]);
//		}
//		return surroundingCells;
//	}

	public ArrayList<Cell> nbList(Cell current) {
		ArrayList<Cell> myNeighbors = new ArrayList<Cell>(current.getSurroundingCells(myGrid));
		return myNeighbors;
	}

	public boolean catchFire (Cell current) {
		Random rand = new Random();
		double randomValue = rand.nextDouble();
		
		if (randomValue < probCatch) return true;
		return false;
	}
	@Override
	public boolean checkForMove(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void moveCell(Cell c) {
		// TODO Auto-generated method stub
		
	}
}