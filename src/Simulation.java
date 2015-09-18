

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
				double[] loc = {(double) i,(double) j};
				
				
				if(myGrid.getCell(i, j).checkSurroundings(myParameters))
					if(isValidMove(i, j))
						moveCell(myGrid, myGrid.getCell(i, j));
			}
		}
	
		
	}
	public abstract void moveCell(Grid g, Cell c);
}