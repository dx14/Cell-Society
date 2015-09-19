import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sun.prism.paint.Color;

import javafx.scene.Scene;

public class WatorWorld extends Simulation{

	public WatorWorld( double[] dimensions, ArrayList<String> parameters) throws SAXException, IOException, ParserConfigurationException {
		super(dimensions, parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkSurroundings(ArrayList<String> myParameters, int i, int j) {
		
		Cell myCurrentCell = myGrid[i][j];
		int width = myCurrentCell.getMyWidth();
		int height = myCurrentCell.getMyHeight();
		if(i !=0 && j !=0 && i != ((int) myDimensions[0])/width-1 && j != ((int) myDimensions[1])/height-1){
			if((!myGrid[i+1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i+1][j].getMyColor().equals("WHITE")) || 
				(!myGrid[i-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][j+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j+1].getMyColor().equals("WHITE"))||
				(!myGrid[i][j-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j-1].getMyColor().equals("WHITE"))
				){
				return false;
			}
		}
		else if(i == 0 && j !=0&& j != ((int) myDimensions[1])/height-1){
			if((!myGrid[i+1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i+1][j].getMyColor().equals("WHITE")) || 
				(!myGrid[((int) myDimensions[0])/width-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[((int) myDimensions[0])/width-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][j+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j+1].getMyColor().equals("WHITE"))||
				(!myGrid[i][j-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j-1].getMyColor().equals("WHITE"))
				){
				return false;
			}
		}	
		else if(i != 0 && j ==0&& i != ((int) myDimensions[0])/width-1 ){
			if((!myGrid[i+1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i+1][j].getMyColor().equals("WHITE")) || 
				(!myGrid[i-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][j+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j+1].getMyColor().equals("WHITE"))||
				(!myGrid[i][((int) myDimensions[1])/height-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][((int) myDimensions[1])/height-1].getMyColor().equals("WHITE"))
				){
				return false;
			}
			
		}
		else if(i == 0 && j ==0){
			if((!myGrid[i+1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i+1][j].getMyColor().equals("WHITE"))|| 
				(!myGrid[((int) myDimensions[0])/width-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[((int) myDimensions[0])/width-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][j+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j+1].getMyColor().equals("WHITE"))||
				(!myGrid[i][((int) myDimensions[1])/height-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][((int) myDimensions[1])/height-1].getMyColor().equals("WHITE"))
				){
				return false;
				}
		}
		else if(i != 0 && j == ((int) myDimensions[1])/height-1 && i != ((int) myDimensions[0])/width-1){
			if((!myGrid[i+1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i+1][j].getMyColor().equals("WHITE")) || 
				(!myGrid[i-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][0].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][0].getMyColor().equals("WHITE"))||
				(!myGrid[i][j-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j-1].getMyColor().equals("WHITE"))
				){
				return false;
			}
			
		}
		else if(i == ((int) myDimensions[0])/width-1 && j != 0 && j != ((int) myDimensions[1])/height-1){
			if((!myGrid[0][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[0][j].getMyColor().equals("WHITE")) || 
				(!myGrid[i-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][j+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j+1].getMyColor().equals("WHITE"))||
				(!myGrid[i][j-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j-1].getMyColor().equals("WHITE"))
				){
				return false;
			}
			
		}
		else if(i == ((int) myDimensions[0])/width-1 && j == ((int) myDimensions[1])/height-1){
			if((!myGrid[0][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[0][j].getMyColor().equals("WHITE")) || 
				(!myGrid[i-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][0].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][0].getMyColor().equals("WHITE"))||
				(!myGrid[i][j-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j-1].getMyColor().equals("WHITE"))
				){
				return false;
			}
			
		}
		else if(i == 0 && j ==((int) myDimensions[1])/height-1){
			if((!myGrid[i+1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i+1][j].getMyColor().equals("WHITE"))|| 
				(!myGrid[((int) myDimensions[0])/width-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[((int) myDimensions[0])/width-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][0].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][0].getMyColor().equals("WHITE"))||
				(!myGrid[i][j-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j-1].getMyColor().equals("WHITE"))
				){
				return false;
				}
		}
		else if(i == ((int) myDimensions[0])/width-1 && j ==0){
		
			if((!myGrid[0][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[0][j].getMyColor().equals("WHITE"))|| 
				(!myGrid[i-1][j].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i-1][j].getMyColor().equals("WHITE"))||
				(!myGrid[i][j+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][j+1].getMyColor().equals("WHITE"))||
				(!myGrid[i][((int) myDimensions[1])/height-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[i][((int) myDimensions[1])/height-1].getMyColor().equals("WHITE"))
				){
				return false;
				}
		}
		
		return true;
	}

	@Override
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
			myEmptyCells.add(myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]]);
		}
		else if(myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].getMyValue() > 5 && myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].getMyColor().equals("WHITE")){
			myGrid[newloc[0]][newloc[1]].setMyColor("BLUE");
			myEmptyCells.remove(myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]]);
		}
	}

	@Override
	public void setCellToEmpty(Cell[][] grid, Cell c) {
		myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyColor("WHITE");
		
	}

	@Override
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
	@Override
	public void changeCellType(Cell[][] grid, Cell c) {
		if(c.getMyColor().equals("RED")){
			Cell deadprey = getNearByPreyCell(grid, c);
			int[] killspot = new int[2];
			killspot[0] = deadprey.getMyLocation()[0];
			killspot[1] = deadprey.getMyLocation()[1];
			myGrid[killspot[0]][killspot[1]].setMyColor("WHITE");
			myEmptyCells.add(myGrid[killspot[0]][killspot[1]]);
			
		}
		if(c.getMyColor().equals("BLUE")){
			myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyColor("WHITE");
			myEmptyCells.add(myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]]);
		}
		
	}

}