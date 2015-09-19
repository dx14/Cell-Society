import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sun.prism.paint.Color;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WatorWorld {
	public ArrayList<String> myParameters = new ArrayList<String>();
	//private ArrayList<Integer> myDimensions = new ArrayList<Integer>();  USE THIS IF WE EVER HAVE MORE THAN 2D

	Scene myScene;
	private Group root;
	
	public double[] myDimensions = new double[2];
	
	//protected ArrayList<Cell> myEmptyCells;;
	public Grid iGrid = new Grid();
	protected Cell[][] myGrid = iGrid.getCells();
	public WatorWorld( double[] dimensions, ArrayList<String> parameters) throws SAXException, IOException, ParserConfigurationException {
		myDimensions = dimensions;
		myParameters = parameters;
		// TODO Auto-generated constructor stub
	}

	
	public boolean checkSurroundings(ArrayList<String> myParameters, int i, int j) {
		
		Cell myCurrentCell = myGrid[i][j];
		int width = myCurrentCell.getMyWidth();
		int height = myCurrentCell.getMyHeight();
		if(i !=0 && j !=0 && i != myGrid.length-1 && j != myGrid[0].length-1){
			if((!myGrid[i+1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i+1][j].getMyColor().equals("WHITE")) || 
				(!myGrid[i-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][j+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j+1].getMyColor().equals("WHITE"))||
				(!myGrid[i][j-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j-1].getMyColor().equals("WHITE"))
				){
				return false;
			}
		}
		else if(i == 0 && j !=0&& j != myGrid[0].length -1 ){
			if((!myGrid[i+1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i+1][j].getMyColor().equals("WHITE")) || 
				(!myGrid[myGrid.length-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[myGrid.length -1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][j+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j+1].getMyColor().equals("WHITE"))||
				(!myGrid[i][j-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j-1].getMyColor().equals("WHITE"))
				){
				return false;
			}
		}	
		else if(i != 0 && j ==0&& i != myGrid.length-1){
			if((!myGrid[i+1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i+1][j].getMyColor().equals("WHITE")) || 
				(!myGrid[i-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][j+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j+1].getMyColor().equals("WHITE"))||
				(!myGrid[i][myGrid[0].length-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][myGrid[0].length-1].getMyColor().equals("WHITE"))
				){
				return false;
			}
			
		}
		else if(i == 0 && j ==0){
			if((!myGrid[i+1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i+1][j].getMyColor().equals("WHITE"))|| 
				(!myGrid[myGrid.length-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[myGrid.length-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][j+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j+1].getMyColor().equals("WHITE"))||
				(!myGrid[i][myGrid[0].length -1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][myGrid[0].length-1].getMyColor().equals("WHITE"))
				){
				return false;
				}
		}
		else if(i != 0 && j == myGrid[0].length-1 && i != myGrid.length-1){
			if((!myGrid[i+1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i+1][j].getMyColor().equals("WHITE")) || 
				(!myGrid[i-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][0].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][0].getMyColor().equals("WHITE"))||
				(!myGrid[i][j-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j-1].getMyColor().equals("WHITE"))
				){
				return false;
			}
			
		}
		else if(i == myGrid.length-1 && j != 0 && j != myGrid[0].length-1){
			if((!myGrid[0][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[0][j].getMyColor().equals("WHITE")) || 
				(!myGrid[i-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][j+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j+1].getMyColor().equals("WHITE"))||
				(!myGrid[i][j-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j-1].getMyColor().equals("WHITE"))
				){
				return false;
			}
			
		}
		else if(i == myGrid.length-1 && j == myGrid[0].length-1){
			if((!myGrid[0][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[0][j].getMyColor().equals("WHITE")) || 
				(!myGrid[i-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][0].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][0].getMyColor().equals("WHITE"))||
				(!myGrid[i][j-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j-1].getMyColor().equals("WHITE"))
				){
				return false;
			}
			
		}
		else if(i == 0 && j == myGrid[0].length-1){
			if((!myGrid[i+1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i+1][j].getMyColor().equals("WHITE"))|| 
				(!myGrid[myGrid.length-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[myGrid.length-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][0].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][0].getMyColor().equals("WHITE"))||
				(!myGrid[i][j-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j-1].getMyColor().equals("WHITE"))
				){
				return false;
				}
		}
		else if(i == myGrid.length-1 && j ==0){
		
			if((!myGrid[0][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[0][j].getMyColor().equals("WHITE"))|| 
				(!myGrid[i-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][j+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j+1].getMyColor().equals("WHITE"))||
				(!myGrid[i][myGrid[0].length -1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][myGrid[0].length -1].getMyColor().equals("WHITE"))
				){
				return false;
				}
		}
		
		return true;
	}

	
	public void moveCell(Cell[][] grid, Cell c) {
		Cell emptycell = getNearestEmptyCell(c.getMyLocation()[0], c.getMyLocation()[1]);
		int[] newloc = new int[2];
		newloc[0] = emptycell.getMyLocation()[0];
		newloc[1] = emptycell.getMyLocation()[1];
		myGrid[newloc[0]][newloc[1]].setMyLocation(c.getMyLocation());
		myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyLocation(newloc);
		myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyValue(myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].getMyValue() + 1);
		if(myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].getMyValue() > 4 && myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].getMyColor().equals("RED")){
			myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyColor("WHITE");
			myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyValue(0);
			
		}
		else if(myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].getMyValue() > 5 && myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].getMyColor().equals("WHITE")){
			myGrid[newloc[0]][newloc[1]].setMyColor("BLUE");
			
			
		}
	}


	public void setCellToEmpty(Cell[][] grid, Cell c) {
		myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyColor("WHITE");
		
	}

	
	public void setEmptyToCell(Cell[][] grid, Cell c) {
		myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyColor("BLUE");
		
	}
	public Cell getNearByPreyCell(Cell[][] grid, Cell c){
		int width = c.getMyWidth();
		int height = c.getMyHeight();
		Random ran = new Random();
		int one = ran.nextInt(2);
		int d = (-1)^one;
		if( c.getMyLocation()[0] + d >= 0 && c.getMyLocation()[0] + d <  ((int) myDimensions[0])/width){
			return myGrid[c.getMyLocation()[0] +d][c.getMyLocation()[1]];
				
		}
		else if( c.getMyLocation()[1] + d >= 0 && c.getMyLocation()[1] + d <  ((int) myDimensions[1])/height){
			return myGrid[c.getMyLocation()[0]][c.getMyLocation()[1] + d];
		}
		else {
			d = d*-1;
			if( c.getMyLocation()[0] + d >= 0 && c.getMyLocation()[0] + d <  ((int) myDimensions[0])/width){
				return myGrid[c.getMyLocation()[0] +d][c.getMyLocation()[1]];
					
			}
			else {
				return myGrid[c.getMyLocation()[0]][c.getMyLocation()[1] + d];
			}
		}
		
		
		
	}
	public String[][] segStep(Stage s, Cell[][] cells){
		myGrid = cells;
		loopThroughCells();
		String[][] newColors = new String[myGrid.length][myGrid[0].length];
		for(int i=0; i < myGrid.length; i++) {
			for(int j=0; j< myGrid[i].length; j++) {
				newColors[i][j] = myGrid[i][j].getMyColor();
			}
		}
		return newColors;
//		GridLayout updateGrid = new GridLayout(width, height, iGrid.getGridRows(), iGrid.getGridColumns(), iGrid.getGroup(), iGrid.getColors());
		
	}
	public void loopThroughCells(){
		// THE GRID SOMEHOW NEEDS TO BE PASSED TO THE SIMULATION

		
		for(int i = 0; i < myGrid.length; i++){
			for(int j = 0; j < myGrid[0].length; j++){
				int[] newspot = new int[2];
				if(checkSurroundings(myParameters, i, j) && !myGrid[i][j].getMyColor().equals(Color.WHITE)){
					Cell emptyCell = getNearestEmptyCell(i,j);
					newspot[0] = emptyCell.getMyLocation()[0];
					newspot[1] = emptyCell.getMyLocation()[1];
					moveCell(myGrid, myGrid[newspot[0]][newspot[1]]);

				}
				else{
					changeCellType(myGrid, myGrid[i][j]);
				}
					
			}
		}
	
		
	}
	public Cell getNearestEmptyCell(int x, int y){
		int width = myGrid[0][0].getMyWidth();
		int height = myGrid[0][0].getMyHeight();
		Random ran = new Random();
		int one = ran.nextInt(2);
		int d = (-1)^one;
		if( x + d >= 0 && x + d <  ((int) myDimensions[0])/width){

			if(myGrid[x +d][y].getMyColor().equals("WHITE"))
				return myGrid[x +d][y];
				
		}
		else if( y + d >= 0 && y + d <  ((int) myDimensions[1])/height){
			if(myGrid[x][y + d].getMyColor().equals("WHITE"))
				return myGrid[x][y + d];
		}
		else {
			d = d*-1;
			if( y + d >= 0 && y + d <  ((int) myDimensions[0])/width){
				if(myGrid[x][y + d].getMyColor().equals("WHITE"))
					return myGrid[x][y+d];
					
			}
			else {
				return myGrid[x + d][y];
			}
		}
		return myGrid[x][y];
		
		


	}
	public void changeCellType(Cell[][] grid, Cell c) {
		if(c.getMyColor().equals("RED")){
			Cell deadprey = getNearByPreyCell(grid, c);
			int[] killspot = new int[2];
			killspot[0] = deadprey.getMyLocation()[0];
			killspot[1] = deadprey.getMyLocation()[1];
			myGrid[killspot[0]][killspot[1]].setMyColor("WHITE");
			myGrid[killspot[0]][killspot[1]].setMyValue(0);
			
			
		}
		if(c.getMyColor().equals("BLUE")){
			myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyColor("WHITE");
			myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyValue(0);
		}
		
	}
	public ArrayList<String> getParameters(){
		return myParameters;
	}
	public double[] getDimensions(){
		return myDimensions;
	}

//	public void addEmptyCell(Cell c){
//		myEmptyCells.add(c);
//	}
//	public void removeEmptyCell(Cell c){
//		myEmptyCells.remove(c);
//	}
	
	public void setRoot(Group r){
		root = r;
	}

	public void setScene(Scene ss){
		myScene = ss;
	}
}