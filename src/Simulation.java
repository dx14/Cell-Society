

import java.util.ArrayList;

import com.sun.prism.paint.Color;

import javafx.scene.Scene;
import Simulations.Cell;

public abstract class Simulation {
	//private String myDimensionString;
	private ArrayList<Integer> myParameters = new ArrayList<Integer>();
	//private ArrayList<Integer> myDimensions = new ArrayList<Integer>();  USE THIS IF WE EVER HAVE MORE THAN 2D
	private int[] myDimensions = new int[2];
	private Grid myGrid;
	
	public Simulation(Scene scene, int[] dimensions, ArrayList<Integer> parameters){
		myDimensions = dimensions;
		myParameters = parameters;
		myGrid = new Grid(myDimensions[0], myDimensions[1]);
		
	}
//	public String getDimensionString(){
//		return myDimensionString;
//	}
	public ArrayList<Integer> getParameters(){
		return myParameters;
	}
	public int[] getDimensions(){
		return myDimensions;
	}
	public boolean isValidMove(int x, int y){
		return false;
	}
	public void step(Double elapsedTime){
		loopThroughCells();
		
		
	}
	public void loopThroughCells(){
		// THE GRID SOMEHOW NEEDS TO BE PASSED TO THE SIMULATION
		
		for(int i = 0; i < myGrid.getWidth(); i++){
			for(int j = 0; j < myGrid.getHeight(); j++){
				int[] loc = {i,j};
				Cell c = myGrid.getCell(i,j);
				
				if(c.checkSurroundings())
					if(isValidMove(i, j))
						moveCell();
			}
		}
	
		
	}
	public abstract void moveCell();
	
}
