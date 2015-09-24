import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sun.prism.paint.Color;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WatorWorld extends Simulation{
	public ArrayList<String> myParameters = new ArrayList<String>();
	//private ArrayList<Integer> myDimensions = new ArrayList<Integer>();  USE THIS IF WE EVER HAVE MORE THAN 2D

	Scene myScene;
	private Group root;
	
	public double[] myDimensions = new double[2];
	
	//protected ArrayList<Cell> myEmptyCells;;
	public Grid iGrid = new Grid();
	protected Cell[][] myGrid = iGrid.getCells();
	public WatorWorld( double[] dimensions, ArrayList<String> parameters) throws SAXException, IOException, ParserConfigurationException {
		super(dimensions, parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkForMove(int x, int y) {
		
		Cell myCurrentCell = myGrid[x][y];
		ArrayList<Cell> surroundingCells = myCurrentCell.getSurroundingCells(myGrid);
		
		for(int i = 0; i < surroundingCells.size();i++){
			
			if(x == surroundingCells.get(i).getMyLocation()[0] || y == surroundingCells.get(i).getMyLocation()[1]){
				if(!surroundingCells.get(i).getMyColor().equals(myCurrentCell.getMyColor()) && 
						!surroundingCells.get(i).getMyColor().equals("BLUE")){
					
					return false;
				}
			}	
		}
		
//		int width = myCurrentCell.getMyWidth();
//		int height = myCurrentCell.getMyHeight();
//		if(x !=0 && y !=0 && x != myGrid.length-1 && y != myGrid[0].length-1){
//			if((!myGrid[x+1][y].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x+1][y].getMyColor().equals("BLUE")) || 
//				(!myGrid[x-1][y].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x-1][y].getMyColor().equals("BLUE"))||
//				(!myGrid[x][y+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x][y+1].getMyColor().equals("BLUE"))||
//				(!myGrid[x][y-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x][y-1].getMyColor().equals("BLUE"))
//				){
//				return false;
//			}
//			
//		}
//		else if(x == 0 && y !=0&& y != myGrid[0].length -1 ){
//			if((!myGrid[x+1][y].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x+1][y].getMyColor().equals("BLUE")) || 
//				(!myGrid[x][y+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x][y+1].getMyColor().equals("BLUE"))||
//				(!myGrid[x][y-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x][y-1].getMyColor().equals("BLUE"))
//				){
//				return false;	
//			}
//			
//		}	
//		else if(x != 0 && y ==0&& x != myGrid.length-1){
//			if((!myGrid[x+1][y].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x+1][y].getMyColor().equals("BLUE")) || 
//				(!myGrid[x-1][y].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x-1][y].getMyColor().equals("BLUE"))||
//				(!myGrid[x][y+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x][y+1].getMyColor().equals("BLUE"))
//				){
//				return false;
//			}
//			
//			
//		}
//		else if(x == 0 && y ==0){
//			if((!myGrid[x+1][y].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x+1][y].getMyColor().equals("BLUE"))|| 
//			
//				(!myGrid[x][y+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x][y+1].getMyColor().equals("BLUE"))
//				
//				){
//				return false;
//				}
//			
//		}
//		else if(x != 0 && y == myGrid[0].length-1 && x != myGrid.length-1){
//			if((!myGrid[x+1][y].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x+1][y].getMyColor().equals("BLUE")) || 
//				(!myGrid[x-1][y].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x-1][y].getMyColor().equals("BLUE"))||
//				
//				(!myGrid[x][y-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x][y-1].getMyColor().equals("BLUE"))
//				){
//				return false;
//			}
//			
//		}
//		else if(x == myGrid.length-1 && y != 0 && y != myGrid[0].length-1){
//			if(
//				(!myGrid[x-1][y].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x-1][y].getMyColor().equals("BLUE"))||
//				(!myGrid[x][y+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x][y+1].getMyColor().equals("BLUE"))||
//				(!myGrid[x][y-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x][y-1].getMyColor().equals("BLUE"))
//				){
//				return false;
//			}
//			
//		}
//		else if(x == myGrid.length-1 && y == myGrid[0].length-1){
//			if(
//				(!myGrid[x-1][y].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x-1][y].getMyColor().equals("BLUE"))||
//				
//				(!myGrid[x][y-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x][y-1].getMyColor().equals("BLUE"))
//				){
//				return false;
//			}
//		
//			
//		}
//		else if(x == 0 && y == myGrid[0].length-1){
//			if((!myGrid[x+1][y].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x+1][y].getMyColor().equals("BLUE"))|| 
//				
//				
//				(!myGrid[x][y-1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x][y-1].getMyColor().equals("BLUE"))
//				){
//				return false;
//				}
//			
//		}
//		else if(x == myGrid.length-1 && y ==0){
//		
//			if(
//				(!myGrid[x-1][y].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x-1][y].getMyColor().equals("BLUE"))||
//				(!myGrid[x][y+1].getMyColor().equals(myCurrentCell.getMyColor()) && !myGrid[x][y+1].getMyColor().equals("BLUE")))
//				{
//				return false;
//				}
//			
//		}
		
		return true;
	}

	@Override
	public void moveCell(Cell c) {
		
		Cell emptycell = getNearestEmptyCell(c.getMyLocation()[0], c.getMyLocation()[1]);
		int[] newloc = new int[2];
		newloc[0] = emptycell.getMyLocation()[0];
		newloc[1] = emptycell.getMyLocation()[1];
		
		myGrid[newloc[0]][newloc[1]].setMyColor(c.getMyColor());
		myGrid[newloc[0]][newloc[1]].setMyValueOne(myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].getMyValueOne() + 1);
		myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyColor("BLUE");
		myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyValueOne(0);
		if(myGrid[newloc[0]][newloc[1]].getMyValueOne() > 5 && myGrid[newloc[0]][newloc[1]].getMyColor().equals("YELLOW")){
			myGrid[newloc[0]][newloc[1]].setMyColor("BLUE");
			myGrid[newloc[0]][newloc[1]].setMyValueOne(0);
			
			
		}
		else if(myGrid[newloc[0]][newloc[1]].getMyValueOne() > 4 && myGrid[newloc[0]][newloc[1]].getMyColor().equals("GREEN")){
			
			myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyColor("GREEN");
			
			
		}
	}



	public Cell getNearByPreyCell(Cell c){
		
		ArrayList<Cell> possibleprey = c.getSurroundingCells(myGrid);
		int i = 0;
		while( i < possibleprey.size()){
			if((c.getMyLocation()[0] != possibleprey.get(i).getMyLocation()[0] 
					&& c.getMyLocation()[1] != possibleprey.get(i).getMyLocation()[1])
				|| possibleprey.get(i).getMyColor().equals(c.getMyColor()) ||
						possibleprey.get(i).getMyColor().equals("BLUE")){
					possibleprey.remove(i);
				}	
			i++;
		}
//		int x = c.getMyLocation()[0];
//		int y = c.getMyLocation()[1];
//		ArrayList<Cell> possiblemoves = new ArrayList<Cell>();
//		if(x+1 <= myGrid.length-1){
//			if(myGrid[x+1][y].getMyColor().equals("GREEN")){
//				possiblemoves.add(myGrid[x+1][y]);
//			}
//		}
//		if(y+1 <= myGrid[0].length-1){
//			if(myGrid[x][y+1].getMyColor().equals("GREEN")){
//				possiblemoves.add(myGrid[x][y+1]);
//			}
//		}
//		if(y-1>=0){
//			if(myGrid[x][y-1].getMyColor().equals("GREEN")){
//				possiblemoves.add(myGrid[x][y-1]);
//			}
//		}
//		if(x-1>=0){
//			if(myGrid[x-1][y].getMyColor().equals("GREEN")){
//				possiblemoves.add(myGrid[x-1][y]);
//			}
//		}
		Random ran = new Random();
		
		int move = ran.nextInt(possibleprey.size());
		return possibleprey.get(move);
		
		

		
	}
//	public String[][] segStep(Stage s, Cell[][] cells){
//		myGrid = cells;
//		loopThroughCells();
//		String[][] newColors = new String[myGrid.length][myGrid[0].length];
//		for(int i=0; i < myGrid.length; i++) {
//			for(int j=0; j< myGrid[i].length; j++) {
//				newColors[i][j] = myGrid[i][j].getMyColor();
//			}
//		}
//		return newColors;
//
//		
//	}
	@Override
	public void loopThroughCells(){
		
		
		for(int i = 0; i < myGrid.length; i++){
			for(int j = 0; j < myGrid[0].length; j++){
				int[] newspot = new int[2];
				if(checkForMove(i, j) && !myGrid[i][j].getMyColor().equals(Color.WHITE) && !checkIfBlockedIn(i,j)){
					
					moveCell( myGrid[i][j]);

				}
				else if(checkIfBlockedIn(i,j)){
					
					if(myGrid[i][j].getMyColor().equals("GREEN")){
						
						myGrid[i][j].setMyValueOne(myGrid[i][j].getMyValueOne() + 1);
						if(myGrid[i][j].getMyValueOne() > 4){
							Cell newempty = getNearestWhenBlocked(i,j);
							myGrid[newempty.getMyLocation()[0]][newempty.getMyLocation()[1]].setMyColor("GREEN");
						}
					}
					else if(myGrid[i][j].getMyColor().equals("YELLOW")){
						
						myGrid[i][j].setMyValueOne(myGrid[i][j].getMyValueOne() + 1);
						if(myGrid[i][j].getMyValueOne() > 5){
							myGrid[i][j].setMyValueOne(0);
							myGrid[i][j].setMyColor("BLUE");
						}
					}
				}
				else{
					
					changeCellType(myGrid[i][j]);
				}
					
			}
		}
	
		
	}
	public Cell getNearestWhenBlocked(int x, int y){
		
		int r = (int) Math.sqrt((double) Math.pow(myGrid.length,2.0) + (double) Math.pow(myGrid[0].length, 2.0));
		//System.out.println(r);
		Cell c = myGrid[0][0];
		for (int i = 0; i<myGrid.length; i++){
			for(int j = 0; j< myGrid[0].length; j++){
				if(myGrid[i][j].getMyColor().equals("BLUE")){
					int newr = (int) Math.sqrt((double) Math.pow( (double) Math.abs(x-i) ,2.0) + (double) Math.pow((double) Math.abs(y-j), 2.0));
					
					if(newr < r){
						
						r = newr;
						c = myGrid[i][j];
						//return myGrid[i][j];
					}
				}
			}
		}
		return c;
	}
	public Cell getNearestEmptyCell(int x, int y){
		
		ArrayList<Cell> possiblemoves = myGrid[x][y].getSurroundingCells(myGrid);
		int i = 0;
		while(i < possiblemoves.size()){
			if((x != possiblemoves.get(i).getMyLocation()[0] && y != possiblemoves.get(i).getMyLocation()[1]) 
					|| !possiblemoves.get(i).getMyColor().equals("BLUE")){
				possiblemoves.remove(i);
			}
			i++;
		}
		
//		if(x+1 <= myGrid.length-1){
//			if(myGrid[x+1][y].getMyColor().equals("BLUE")){
//				possiblemoves.add(myGrid[x+1][y]);
//			}
//		}
//		if(y+1 <= myGrid[0].length-1){
//			if(myGrid[x][y+1].getMyColor().equals("BLUE")){
//				possiblemoves.add(myGrid[x][y+1]);
//			}
//		}
//		if(y-1>=0){
//			if(myGrid[x][y-1].getMyColor().equals("BLUE")){
//				possiblemoves.add(myGrid[x][y-1]);
//			}
//		}
//		if(x-1>=0){
//			if(myGrid[x-1][y].getMyColor().equals("BLUE")){
//				possiblemoves.add(myGrid[x-1][y]);
//			}
//		}
		Random ran = new Random();
		
		int move = ran.nextInt(possiblemoves.size());
		return possiblemoves.get(move);
		
		


	}
	public void changeCellType( Cell c) {
		
		if(c.getMyColor().equals("YELLOW")){
			
			Cell deadprey = getNearByPreyCell( c);
			int[] killspot = new int[2];
			killspot[0] = deadprey.getMyLocation()[0];
			killspot[1] = deadprey.getMyLocation()[1];
			myGrid[killspot[0]][killspot[1]].setMyColor("BLUE");
			myGrid[killspot[0]][killspot[1]].setMyValueOne(0);
			
			
		}
		if(c.getMyColor().equals("GREEN")){
			
			myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyColor("BLUE");
			myGrid[c.getMyLocation()[0]][c.getMyLocation()[1]].setMyValueOne(0);
		}
		
	}
	public boolean checkIfBlockedIn(int x, int y){
		
		ArrayList<Cell> possiblemoves = myGrid[x][y].getSurroundingCells(myGrid);
		int i = 0;
	
		while( i<possiblemoves.size()){
			if((x != possiblemoves.get(i).getMyLocation()[0] && y != possiblemoves.get(i).getMyLocation()[1]) ){
				
				possiblemoves.remove(i);
			}
			i++;
		}
	
		int totalaround = possiblemoves.size();
		
		int j = 0;
		while( j <possiblemoves.size()){
			
			
			if( !possiblemoves.get(j).getMyColor().equals(myGrid[x][y].getMyColor() )){
				
				possiblemoves.remove(j);
			}
			j++;
		}
		
		if(possiblemoves.size() == totalaround){
			
			return true;
		}
		
//		int width = myCurrentCell.getMyWidth();
//		int height = myCurrentCell.getMyHeight();
//		if(x !=0 && y !=0 && x != myGrid.length-1 && y != myGrid[0].length-1){
//			
//			if(myGrid[x+1][y].getMyColor().equals(myCurrentCell.getMyColor()) &&  
//					myGrid[x-1][y].getMyColor().equals(myCurrentCell.getMyColor()) && 
//					myGrid[x][y+1].getMyColor().equals(myCurrentCell.getMyColor()) && 
//					myGrid[x][y-1].getMyColor().equals(myCurrentCell.getMyColor())
//					){
//					return true;
//				}
//		}
//		else if(x == 0 && y !=0&& y != myGrid[0].length -1 ){
//			
//			if(myGrid[x+1][y].getMyColor().equals(myCurrentCell.getMyColor()) &&  
//					
//					myGrid[x][y+1].getMyColor().equals(myCurrentCell.getMyColor()) && 
//					myGrid[x][y-1].getMyColor().equals(myCurrentCell.getMyColor())
//					){
//					return true;
//				}
//		}	
//		else if(x != 0 && y ==0&& x != myGrid.length-1){
//			
//			if(myGrid[x+1][y].getMyColor().equals(myCurrentCell.getMyColor()) &&  
//					myGrid[x-1][y].getMyColor().equals(myCurrentCell.getMyColor()) && 
//					myGrid[x][y+1].getMyColor().equals(myCurrentCell.getMyColor())
//					
//					){
//					return true;
//				}
//			
//		}
//		else if(x == 0 && y ==0){
//			
//			if(myGrid[x+1][y].getMyColor().equals(myCurrentCell.getMyColor()) &&  
//					
//					myGrid[x][y+1].getMyColor().equals(myCurrentCell.getMyColor())
//				
//					){
//					return true;
//				}
//		}
//		else if(x != 0 && y == myGrid[0].length-1 && x != myGrid.length-1){
//			
//			if(myGrid[x+1][y].getMyColor().equals(myCurrentCell.getMyColor()) &&  
//					myGrid[x-1][y].getMyColor().equals(myCurrentCell.getMyColor()) && 
//					
//					myGrid[x][y-1].getMyColor().equals(myCurrentCell.getMyColor())
//					){
//					return true;
//				}
//			
//		}
//		else if(x == myGrid.length-1 && y != 0 && y != myGrid[0].length-1){
//			
//			if(
//					myGrid[x-1][y].getMyColor().equals(myCurrentCell.getMyColor()) && 
//					myGrid[x][y+1].getMyColor().equals(myCurrentCell.getMyColor()) && 
//					myGrid[x][y-1].getMyColor().equals(myCurrentCell.getMyColor())
//					){
//					return true;
//				}
//			
//		}
//		else if(x == myGrid.length-1 && y == myGrid[0].length-1){
//			
//			if(
//					myGrid[x-1][y].getMyColor().equals(myCurrentCell.getMyColor()) && 
//					
//					myGrid[x][y-1].getMyColor().equals(myCurrentCell.getMyColor())
//					){
//					return true;
//				}
//			
//		}
//		else if(x == 0 && y == myGrid[0].length-1){
//			
//			if(myGrid[x+1][y].getMyColor().equals(myCurrentCell.getMyColor()) &&  
//					
//					
//					myGrid[x][y-1].getMyColor().equals(myCurrentCell.getMyColor())
//					){
//					return true;
//				}
//		}
//		else if(x == myGrid.length-1 && y ==0){
//		
//			if(
//					myGrid[x-1][y].getMyColor().equals(myCurrentCell.getMyColor()) && 
//					myGrid[x][y+1].getMyColor().equals(myCurrentCell.getMyColor()) 
//					
//					){
//					return true;
//				}
//		}
		
		return false;
	}
//	public ArrayList<String> getParameters(){
//		return myParameters;
//	}
//	public double[] getDimensions(){
//		return myDimensions;
//	}

//	public void addEmptyCell(Cell c){
//		myEmptyCells.add(c);
//	}
//	public void removeEmptyCell(Cell c){
//		myEmptyCells.remove(c);
//	}
//	
//	public void setRoot(Group r){
//		root = r;
//	}
//
//	public void setScene(Scene ss){
//		myScene = ss;
//	}
}