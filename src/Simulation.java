

import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public abstract class Simulation {
	//private String myDimensionString;
	private ArrayList<String> myParameters = new ArrayList<String>();
	//private ArrayList<Integer> myDimensions = new ArrayList<Integer>();  USE THIS IF WE EVER HAVE MORE THAN 2D
	private double[] myDimensions = new double[2];
	private Cell[][] myGrid;
	private ArrayList<Cell> myEmptyCells;
	
	
	
	public Simulation(double[] dimensions, ArrayList<String> parameters) throws SAXException, IOException, ParserConfigurationException{
		myDimensions = dimensions;
		myParameters = parameters;
		
		
		
		
	}
//	public String getDimensionString(){
//		return myDimensionString;
//	}
	public ArrayList<String> getParameters(){
		return myParameters;
	}
	public double[] getDimensions(){
		return myDimensions;
	}
	public boolean isValidMove(int x, int y){
		Cell c = myGrid[x][y];
		if(c.getCellType() != "Empty")
			return false;
		else
			return true;
	}
	public void step(Double elapsedTime){
		loopThroughCells();
		
		
	}
	public void loopThroughCells(){
		// THE GRID SOMEHOW NEEDS TO BE PASSED TO THE SIMULATION
		
		for(int i = 0; i < myDimensions[0]; i++){
			for(int j = 0; j < myDimensions[1]; j++){
				int[] newspot;
				if(checkSurroundings(myParameters, i, j) && !myGrid[i][j].getMyColor().equals(Color.WHITE)){
					newspot = getNearestEmptyCell(i,j);
					moveCell(myGrid, myGrid[newspot[0]][newspot[1]]);
				}
				else{
					changeCellType(myGrid, myGrid[i][j]);
				}
					
			}
		}
	
		
	}
	public int[] getNearestEmptyCell(int x, int y){
		int[] loc = {(int) myDimensions[0], (int) myDimensions[1]};
		int rad = (int) Math.sqrt((int) myDimensions[0]^2 + (int) myDimensions[1]^2 );
	
		for(int i = 0; i < myEmptyCells.size(); i++){
			if(rad >= (int) Math.sqrt( (myEmptyCells.get(i).getMyLocation()[0] - x)^2  + 
					(myEmptyCells.get(i).getMyLocation()[1] - y)^2 )){
				rad = (int) Math.sqrt( (myEmptyCells.get(i).getMyLocation()[0] - x)^2  + 
						(myEmptyCells.get(i).getMyLocation()[1] - y)^2 );
				loc[0] = x;
				loc[1] = y;
			}
					
		}
        return loc;
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
	public abstract boolean checkSurroundings(ArrayList<String> myParameters, int i, int j);
	public abstract void moveCell(Cell[][] grid, Cell c);
	public abstract void setCellToEmpty(Cell[][] grid, Cell c);
	public abstract void setEmptyToCell(Cell[][] grid, Cell c);
	public abstract void changeCellType(Cell[][] grid, Cell c);
}