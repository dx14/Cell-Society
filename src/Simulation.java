

import java.util.ArrayList;
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

public class Simulation {
	//private String myDimensionString;
	public ArrayList<String> myParameters = new ArrayList<String>();
	//private ArrayList<Integer> myDimensions = new ArrayList<Integer>();  USE THIS IF WE EVER HAVE MORE THAN 2D

	public double[] myDimensions = new double[2];
	public Cell[][] myGrid;
	private ArrayList<Cell> myEmptyCells;
	public Grid iGrid = new Grid();


	
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
	
	
	public void step(int width, int height, Double elapsedTime){
		loopThroughCells();
		GridLayout updateGrid = new GridLayout(width, height, iGrid.getGridRows(), iGrid.getGridColumns(), iGrid.getGroup(), iGrid.getColors());
		
	}
	
	
	public void loopThroughCells(){
		// THE GRID SOMEHOW NEEDS TO BE PASSED TO THE SIMULATION
		int width = myGrid[0][0].getMyWidth();
		int height = myGrid[0][0].getMyHeight();
		for(int i = 0; i < ((int) myDimensions[0])/width; i++){
			for(int j = 0; j < ((int) myDimensions[1])/height ; j++){
				int[] newspot;
				if(checkSurroundings(myParameters, i, j) && !myGrid[i][j].getMyColor().equals(Color.WHITE)){
					
					moveCell(myGrid, myGrid[i][j]);
				}
				else{
					changeCellType(myGrid, myGrid[i][j]);
				}
					
			}
		}
	
		
	}
	public int[] getNearestEmptyCell(int x, int y){
		int width = myGrid[x][y].getMyWidth();
		int height = myGrid[x][y].getMyHeight();
		int[] loc = {((int) myDimensions[0])/width - 1, ((int) myDimensions[1])/height - 1};
		double rad =  Math.sqrt((int) myDimensions[0]^2 + (int) myDimensions[1]^2 );

		for(int i = 0; i < myEmptyCells.size(); i++){
			if(rad >= Math.sqrt( (myEmptyCells.get(i).getMyLocation()[0] - x)^2  + 
					(myEmptyCells.get(i).getMyLocation()[1] - y)^2 )){
				rad = Math.sqrt( (myEmptyCells.get(i).getMyLocation()[0] - x)^2  + 
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
	public void addEmptyCell(Cell c){
		myEmptyCells.add(c);
	}
	public void removeEmptyCell(Cell c){
		myEmptyCells.remove(c);
	}
	public abstract boolean checkSurroundings(ArrayList<String> myParameters, int i, int j);
	public abstract void moveCell(Cell[][] grid, Cell c);
	public abstract void setCellToEmpty(Cell[][] grid, Cell c);
	public abstract void setEmptyToCell(Cell[][] grid, Cell c);
	public abstract void changeCellType(Cell[][] grid, Cell c);

}