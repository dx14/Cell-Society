import java.awt.Dimension;
import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public abstract class Cell {

	private int[] myLocation = new int[2];
	protected String myColor;
	protected Node myNode;
	protected String myShape;
	private int direction;
	private String myCellType;

	private int myWidth;
	private int myHeight;

	
	public Cell(int x, int y, int sizeX, int sizeY, String value, String shape) {
		myWidth = sizeX;
		myHeight = sizeY;
		myLocation[0] = x;
		myLocation[1] = y;
		myColor = value;

		myShape = shape;
		if(shape.equals("Rectangle")){
			Rectangle rec = new Rectangle(sizeX, sizeY);
			rec.setFill(Paint.valueOf(myColor));
			myNode = rec;
			myNode.relocate(x*sizeY , y*sizeX );
		}
		else if (shape.equals("Triangle")){
			Polygon p;
			if(((x+y) % 2) == 0){
				p = new Polygon(new double[] {y +0.5*sizeX, x, y , x + sizeY, y + sizeX, x + sizeY});	

			}
			else
				p = new Polygon(new double[] {y - 0.5*sizeX , x , y  +0.5*sizeX, x , y, x + sizeY});


			p.setFill(Paint.valueOf(myColor));
			myNode = p;
			if(y == 0)
				myNode.relocate(y*sizeX, x*sizeY);
			else
				myNode.relocate(y*sizeX - y*(0.5*sizeX), x*sizeY);
		}
		else {
			Polygon p;
			
			p = new Polygon(new double[] {  0, 0.5*sizeY, 
											0.25*sizeX , 0, 
											0.75*sizeX, 0, 
											sizeX, 0.5*sizeY, 
											0.75*sizeX, sizeY,
											0.25*sizeX, sizeY 
											});	
			p.setFill(Paint.valueOf(myColor));
			myNode = p;
			if((y%2) == 0){
				myNode.relocate(0.5*sizeX + (y/2)*(1.5*sizeX),  0.5*sizeY + x*sizeY);
			}
			else
				myNode.relocate(-0.25*sizeX + ((y+1)/2)*(1.5*sizeX), sizeY + x*sizeY);
		}
		
	}
	
	public Node getMyNode() {
		return myNode;
	}

	public void setMyNode(Node myNode) {
		this.myNode = myNode;
	}

	public int[] getMyLocation() {
		return myLocation;
	}
	public void setMyLocation(int[] myLocation) {
		this.myLocation = myLocation;
	}
	public String getMyColor() {
		return myColor;
	}
	public void setMyColor(String myColor) {
		this.myColor = myColor;
	}
	 public int getDirection() {
	        return direction;
	}
	public void setDirection(int newDirection)
	    {
	        direction = newDirection % 360;
	        if (direction < 0)
	            direction += 360;
	    }

	//public abstract boolean checkSurroundings(ArrayList<Integer> parameters, int x, int y);
	public String getCellType(){
		return myCellType;
	}
	public void setCellType(String type){
		myCellType = type;
	}


	public int getMyWidth(){
		return myWidth;
	}
	public int getMyHeight(){
		return myHeight;
	}
	public String getMyShape(){
		return myShape;
	}
	public ArrayList<Cell> getSurroundingCells(Cell[][] myGrid){
		if(myShape.equals("Rectangle") || myShape.equals("Triangle")){
			ArrayList<Cell> surroundingCells = new ArrayList<Cell>();
			int currX = this.getMyLocation()[0];
			int currY = this.getMyLocation()[1];

			if (currX > 0 && currY > 0) {
				surroundingCells.add(myGrid[currX-1][currY-1]);
			}
			if (currX > 0) {
				surroundingCells.add(myGrid[currX-1][currY]);
			}
			if (currX > 0 && currY < Grid.gridRows-1) {
				surroundingCells.add(myGrid[currX-1][currY+1]);
			}
			if (currY > 0) {
				surroundingCells.add(myGrid[currX][currY-1]);
			}
			if (currY < Grid.gridRows-1) {
				surroundingCells.add(myGrid[currX][currY+1]);
			}
			if (currX < Grid.gridColumns-1 && currY > 0) {
				surroundingCells.add(myGrid[currX+1][currY-1]);
			}
			if (currX < Grid.gridColumns-1) {
				surroundingCells.add(myGrid[currX+1][currY]);
			}
			if (currX < Grid.gridColumns-1 && currY < Grid.gridRows-1) {
				surroundingCells.add(myGrid[currX+1][currY+1]);
			}
			
			return surroundingCells;
		}
		else{
			ArrayList<Cell> surroundingCells = new ArrayList<Cell>();
			int currX = this.getMyLocation()[0];
			int currY = this.getMyLocation()[1];
			if(currX >1 ){
				surroundingCells.add(myGrid[currX-2][currY]);
			}
			if(currX < myGrid.length-2){
				surroundingCells.add(myGrid[currX+2][currY]);
			}
			if(currX >0 && currY <myGrid[0].length-1){
				surroundingCells.add(myGrid[currX-1][currY+1]);
			}
			if(currX < myGrid.length-1 && currY < myGrid[0].length - 1){
				surroundingCells.add(myGrid[currX+1][currY+1]);
			}
			if(currX >0 && currY >0){
				surroundingCells.add(myGrid[currX-1][currY-1]);
			}
			if(currX <myGrid.length -1&& currY >0){
				surroundingCells.add(myGrid[currX+1][currY-1]);
			}
			return surroundingCells;
		}

		}
	public abstract boolean checkForMove( Cell[][] myGrid);
	public abstract void moveCell(Cell[][] myGrid);
	public abstract boolean checkIfBlockedIn(Cell[][] myGrid);
	public abstract void changeCellType(Cell[][] myGrid);
	}

