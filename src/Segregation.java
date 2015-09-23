
import java.util.ArrayList;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


import javafx.scene.paint.Color;


import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
public class Segregation {

	Grid iGrid = new Grid();
	protected Cell[][] myGrid = iGrid.getCells();
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
	//	myGrid = cells;
		String[][] newColors = new String[myGrid.length][myGrid[0].length];
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


	public ArrayList<Cell> getSurroundingCells(Cell curr, Cell[][] allCells){

		
		ArrayList<Cell> surroundingCells = new ArrayList<Cell>();
		int currX = curr.getMyLocation()[0];
		int currY = curr.getMyLocation()[1];

		if (currX > 0 && currY > 0) {
			surroundingCells.add(allCells[currX-1][currY-1]);
		}
		if (currX > 0) {
			surroundingCells.add(allCells[currX-1][currY]);
		}
		if (currX > 0 && currY < Grid.gridRows-1) {
			surroundingCells.add(allCells[currX-1][currY+1]);
		}
		if (currY > 0) {
			surroundingCells.add(allCells[currX][currY-1]);
		}
		if (currY < Grid.gridRows-1) {
			surroundingCells.add(allCells[currX][currY+1]);
		}
		if (currX < Grid.gridColumns-1 && currY > 0) {
			surroundingCells.add(allCells[currX+1][currY-1]);
		}
		if (currX < Grid.gridColumns-1) {
			surroundingCells.add(allCells[currX+1][currY]);
		}
		if (currX < Grid.gridColumns-1 && currY < Grid.gridRows-1) {
			surroundingCells.add(allCells[currX+1][currY+1]);
		}
		
		return surroundingCells;
		
	}
	
	public ArrayList<Cell> getNeighbors(ArrayList<Cell> surroundings){
		for(int i = 0; i<surroundings.size(); i++){
			if(surroundings.get(i).getMyColor().equals("WHITE")){
				surroundings.remove(i);
			}
		}
		return surroundings;
	}
	

		public double satisfactionRate (Cell current, Cell[][] cells) {
		ArrayList<Cell> nbList = new ArrayList<Cell> (getNeighbors(getSurroundingCells(current, cells)));
		double nbTotal = nbList.size();
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
		int x = current.getMyLocation()[0];
		int y = current.getMyLocation()[1];
		int r = (int) Math.sqrt((double) Math.pow(allCells.length,2.0) + (double) Math.pow(allCells[0].length, 2.0));
		
		Cell c = myGrid[0][0];
		for (int i = 0; i<allCells.length; i++){
			for(int j = 0; j< allCells[0].length; j++){
				if(allCells[i][j].getMyColor().equals("WHITE")){
					int newr = (int) Math.sqrt((double) Math.pow( (double) Math.abs(x-i) ,2.0) + (double) Math.pow((double) Math.abs(y-j), 2.0));
					
					if(newr < r){
						
						r = newr;
						c = allCells[i][j];
						
					}
				}
			}
		}
		allCells[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyColor(current.getMyColor());
		allCells[current.getMyLocation()[0]][current.getMyLocation()[1]].setMyColor("WHITE");
		}
	}

