

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
	private ArrayList<Integer> myParameters = new ArrayList<Integer>();
	//private ArrayList<Integer> myDimensions = new ArrayList<Integer>();  USE THIS IF WE EVER HAVE MORE THAN 2D
	private double[] myDimensions = new double[2];
	private Grid myGrid;
	
	
	
	public Simulation(Scene scene, double[] dimensions, ArrayList<Integer> parameters) throws SAXException, IOException, ParserConfigurationException{
		myDimensions = dimensions;
		myParameters = parameters;
		//myGrid = Grid.initGrid(dimensions[0], dimensions[1]);
		Group group = new Group();
		
		myGrid = new Grid(group, dimensions[0], dimensions[1], Color.WHITE);
		
	}
//	public String getDimensionString(){
//		return myDimensionString;
//	}
	public ArrayList<Integer> getParameters(){
		return myParameters;
	}
	public double[] getDimensions(){
		return myDimensions;
	}
	public boolean isValidMove(int x, int y){
		Cell c = myGrid.getCell(x, y);
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
		
		for(int i = 0; i < myGrid.getWidth(); i++){
			for(int j = 0; j < myGrid.getHeight(); j++){
				
				if(!myGrid.getCell(i, j).checkSurroundings(myParameters, i, j) && !myGrid.getCell(i, j).getCellType().equals("Empty")){
					if(isValidMove(i, j)){
						moveCell(myGrid, myGrid.getCell(i, j));
						}
					}	
				else{
					setCellToEmpty(myGrid, myGrid.getCell(i, j));
					setEmptyToCell(myGrid, myGrid.getCell(i, j));
				}
					
			}
		}
	
		
	}
	public int[] getNearestEmptyCell(int x, int y){
		int[] loc = new int[2];
		if(x != 0 && y!=0){
			if(myGrid.getCell(x-1, y).getCellType().equals("Empty")){
				loc[0] = x-1;
				loc[1] = y;
			}
			else if(myGrid.getCell(x+1, y).getCellType().equals("Empty")){
				loc[0] = x+1;
				loc[1] = y;
			}
			else if(myGrid.getCell(x, y-1).getCellType().equals("Empty")){
				loc[0] = x;
				loc[1] = y-1;
			}
			else if(myGrid.getCell(x, y+1).getCellType().equals("Empty")){
				loc[0] = x;
				loc[1] = y+1;
			}
		}
		else if(x != 0 && y==0){
			if(myGrid.getCell(x-1, y).getCellType().equals("Empty")){
				loc[0] = x-1;
				loc[1] = y;
			}
			else if(myGrid.getCell(x+1, y).getCellType().equals("Empty")){
				loc[0] = x+1;
				loc[1] = y;
			}
			else if(myGrid.getCell(x, (int) myGrid.getHeight() - 1).getCellType().equals("Empty")){
				loc[0] = x;
				loc[1] = y-1;
			}
			else if(myGrid.getCell(x, y+1).getCellType().equals("Empty")){
				loc[0] = x;
				loc[1] = y+1;
			}
		}
		else if(x == 0 && y!=0){
			if(myGrid.getCell((int) myGrid.getWidth() - 1, y).getCellType().equals("Empty")){
				loc[0] = x-1;
				loc[1] = y;
			}
			else if(myGrid.getCell(x+1, y).getCellType().equals("Empty")){
				loc[0] = x+1;
				loc[1] = y;
			}
			else if(myGrid.getCell(x, (int) myGrid.getWidth()).getCellType().equals("Empty")){
				loc[0] = x;
				loc[1] = y-1;
			}
			else if(myGrid.getCell(x, y+1).getCellType().equals("Empty")){
				loc[0] = x;
				loc[1] = y+1;
			}
		}
        return loc;
	}
	private void getAdjacentSpot(int x, int y, int[] loc) {
		int adjustedDirection = (myGrid.getCell(x, y).getDirection() + 45 / 2) % 360;
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
	public abstract void moveCell(Grid g, Cell c);
	public abstract void setCellToEmpty(Grid g, Cell c);
	public abstract void setEmptyToCell(Grid g, Cell c);
}