import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public abstract class Simulation {
	//private String myDimensionString;
	public List<String> myParameters;
	//private ArrayList<Integer> myDimensions = new ArrayList<Integer>();  USE THIS IF WE EVER HAVE MORE THAN 2D

	
	protected Cell[][] myGrid;
	protected ArrayList<Cell> myEmptyCells;
	Scene myScene;
	private Group root;
	public Grid iGrid = new Grid();
	double[] myDimensions;

	
	public Simulation(double[] size, List<String> params) throws SAXException, IOException, ParserConfigurationException{
		myDimensions = size;
		myParameters = params;
		
	

	}
	
//	public String getDimensionString(){
//		return myDimensionString;
//	}
	
	public List<String> getParameters(){
		return myParameters;
	}
	public double[] getDimensions(){
		return myDimensions;
	}

	
	public String[][] simStep (Cell[][] cells) {
		myGrid = cells;
		String[][] newColors = new String[myGrid.length][myGrid[0].length];
		loopThroughCells();
		for(int i=0; i < myGrid.length; i++) {
			for(int j=0; j< myGrid[i].length; j++) {
				newColors[i][j] = myGrid[i][j].getMyColor();
			}
		}
		return newColors;
	}
	
	
	private void getAdjacentSpot(int x, int y, int[] loc) {
		int adjustedDirection = (myGrid[x][y].getDirection() + 45 / 2) % 360;
        if (adjustedDirection < 0)
            adjustedDirection += 360;

        adjustedDirection = (adjustedDirection / 45) * 45;
        int dc = 0;
        int dr = 0;
        if (adjustedDirection == 90)
            dc = 1;
        else if (adjustedDirection == 135)
        {
            dc = 1;
            dr = 1;
        }
        else if (adjustedDirection == 180)
            dr = 1;
        else if (adjustedDirection == 225)
        {
            dc = -1;
            dr = 1;
        }
        else if (adjustedDirection == 270)
            dc = -1;
        else if (adjustedDirection == 315)
        {
            dc = -1;
            dr = -1;
        }
        else if (adjustedDirection == 0)
            dr = -1;
        else if (adjustedDirection == 45)
        {
            dc = 1;
            dr = -1;
        }
        loc[0] = x + dr;
        loc[1] = y + dc;
	}
	public Cell[][] getMyGrid(){
		return myGrid;
	}
	public void setMyGrid(Cell[][] grid){
		myGrid = grid;
	}

	public void setRoot(Group r){
		root = r;
	}

	public void setScene(Scene ss){
		myScene = ss;
	}
//	public ArrayList<Cell> getSurroundingCells(Cell curr){
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
//		
//		return surroundingCells;
//	}
	
//	public abstract boolean checkForMove(int i, int j);
//	public abstract void moveCell(Cell c);
	public abstract void loopThroughCells();
//	public abstract void changeCellType(Cell[][] grid, Cell c);


}