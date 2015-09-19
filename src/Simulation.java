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
<<<<<<< HEAD
	private double[] myDimensions = new double[2];
	private Cell[][] myGrid;
	private ArrayList<Cell> myEmptyCells;
	

	public Simulation(double[] dimensions, ArrayList<String> parameters) throws SAXException, IOException, ParserConfigurationException{
		myDimensions = dimensions;
		myParameters = parameters;		
=======

	public double[] myDimensions = new double[2];
	public Cell[][] myGrid;
	private ArrayList<Cell> myEmptyCells;
	public Grid iGrid = new Grid();


	
	public Simulation(double[] dimensions, ArrayList<String> parameters) throws SAXException, IOException, ParserConfigurationException{
		myDimensions = dimensions;
		myParameters = parameters;
		
	
>>>>>>> f65b5a7f6b510963b813e4bab25a11c358276712
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
<<<<<<< HEAD
//	public boolean isValidMove(int x, int y){
//		Cell c = myGrid[x][y];
//		if(c.getCellType() != "Empty")
//			return false;
//		else
//			return true;
//	}
	public void step(Double elapsedTime){
=======
	public boolean isValidMove(int x, int y){
		Cell c = myGrid[x][y];
		if(c.getCellType() != "Empty")
			return false;
		else
			return true;
	}
	
	
	public void step(int width, int height, Double elapsedTime){
>>>>>>> f65b5a7f6b510963b813e4bab25a11c358276712
		loopThroughCells();
//		GridLayout updateGrid = new GridLayout(width, height, iGrid.getGridRows(), iGrid.getGridColumns(), iGrid.getGroup(), iGrid.getColors());
		
	}
	
	
	public void loopThroughCells(){
		// THE GRID SOMEHOW NEEDS TO BE PASSED TO THE SIMULATION
<<<<<<< HEAD
		
		for(int i = 0; i < myDimensions[0]; i++){
			for(int j = 0; j < myDimensions[1]; j++){
				int[] newspot;
				if(checkSurroundings(myParameters, i, j) && !myGrid[i][j].getMyColor().equals(Color.WHITE)){
					newspot = getNearestEmptyCell(i,j);
					moveCell(myGrid, myGrid[newspot[0]][newspot[1]]);
=======
		int width = myGrid[0][0].getMyWidth();
		int height = myGrid[0][0].getMyHeight();
		for(int i = 0; i < ((int) myDimensions[0])/width; i++){
			for(int j = 0; j < ((int) myDimensions[1])/height ; j++){
				int[] newspot;
				if(checkSurroundings(myParameters, i, j) && !myGrid[i][j].getMyColor().equals(Color.WHITE)){
					
					moveCell(myGrid, myGrid[i][j]);
>>>>>>> f65b5a7f6b510963b813e4bab25a11c358276712
				}
				else{
					changeCellType(myGrid, myGrid[i][j]);
				}
					
			}
		}
	
		
	}
<<<<<<< HEAD
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
=======
	public Cell getNearestEmptyCell(int x, int y){
		int width = myGrid[0][0].getMyWidth();
		int height = myGrid[0][0].getMyHeight();
		Random ran = new Random();
		int one = ran.nextInt(2);
		int d = (-1)^one;
		if( x + d >= 0 && x + d <  ((int) myDimensions[0])/width){
			return myGrid[x +d][y];
				
		}
		else if( y + d >= 0 && y + d <  ((int) myDimensions[1])/height){
			return myGrid[x][y+d];
		}
		else {
			d = d*-1;
			if( y + d >= 0 && x + d <  ((int) myDimensions[1])/height){
				return myGrid[x ][y+d];
>>>>>>> f65b5a7f6b510963b813e4bab25a11c358276712
					
			}
			else {
				return myGrid[x+d][y];
			}
		}
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
<<<<<<< HEAD
	public abstract boolean checkSurroundings(ArrayList<String> myParameters, int i, int j);
	public abstract void moveCell(Cell[][] grid, Cell c);
	public abstract void setCellToEmpty(Cell[][] grid, Cell c);
	public abstract void setEmptyToCell(Cell[][] grid, Cell c);
	public abstract void changeCellType(Cell[][] grid, Cell c);
=======
	public void addEmptyCell(Cell c){
		myEmptyCells.add(c);
	}
	public void removeEmptyCell(Cell c){
		myEmptyCells.remove(c);
	}
//	public abstract boolean checkSurroundings(ArrayList<String> myParameters, int i, int j);
//	public abstract void moveCell(Cell[][] grid, Cell c);
//	public abstract void setCellToEmpty(Cell[][] grid, Cell c);
//	public abstract void setEmptyToCell(Cell[][] grid, Cell c);
//	public abstract void changeCellType(Cell[][] grid, Cell c);

>>>>>>> f65b5a7f6b510963b813e4bab25a11c358276712
}