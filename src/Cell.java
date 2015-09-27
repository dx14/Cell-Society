import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;


public abstract class Cell {

	private int[] myLocation = new int[2];
	protected String myColor;
	protected Node myNode;
	protected String myShape;
	private int direction;
	private String myCellType;
	protected ArrayList<Ant> antList;
	private int myValue;
	private int myfPher;
	private int myhPher;
	private int myWidth;
	private int myHeight;
	public static boolean showOutline = false;
	public static boolean bounded = false;

	public Cell(int x, int y, int sizeX, int sizeY, String color, String shape) {
		myWidth = sizeX;
		myHeight = sizeY;
		myLocation[0] = x;
		myLocation[1] = y;
		myfPher = 0;
		myhPher = 0;
		myValue = 0;
		antList = new ArrayList<Ant>();
		myColor = color;
		myShape = shape;
		if(shape.equals("Square")){
			Rectangle rec = new Rectangle(sizeX, sizeY);
			rec.setFill(Paint.valueOf(myColor));
			myNode = rec;
			myNode.relocate(x*sizeX , y*sizeY);
			if (showOutline){
				rec.setStroke(Paint.valueOf("BLACK"));
			}
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
			if (showOutline){
				p.setStroke(Paint.valueOf("BLACK"));
			}
		}
		else {
			Polygon p;
			sizeX = 8*(sizeX)/10;
			sizeY = 8*(sizeY)/10;
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
			if (showOutline){
				p.setStroke(Paint.valueOf("BLACK"));
			}
		}
		
		
		
	}
	
	public static void switchOutline(){
		if (showOutline){
			showOutline = false;
		}
		else{
			showOutline = true;
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
		if(!bounded){
		if(!myShape.equals("Hexagon")){
			ArrayList<Cell> surroundingCells = new ArrayList<Cell>();
			int currX = this.getMyLocation()[0];
			int currY = this.getMyLocation()[1];
	
			if (currX > 0 && currY > 0) {
			
				surroundingCells.add(myGrid[currX-1][currY-1]);
			}
			if (currX > 0) {
			
				surroundingCells.add(myGrid[currX-1][currY]);
			}
			if (currX > 0 && currY < myGrid.length-1) {
		
				surroundingCells.add(myGrid[currX-1][currY+1]);
			}
			if (currY > 0) {
	
				surroundingCells.add(myGrid[currX][currY-1]);
			}
			if (currY < myGrid.length-1) {
				surroundingCells.add(myGrid[currX][currY+1]);
			}
			if (currX < myGrid[0].length-1 && currY > 0) {
			
				surroundingCells.add(myGrid[currX+1][currY-1]);
			}
			if (currX < myGrid[0].length-1) {
				
				surroundingCells.add(myGrid[currX+1][currY]);
			}
			if (currX < myGrid[0].length-1 && currY < myGrid.length-1) {
		
				surroundingCells.add(myGrid[currX+1][currY+1]);
			}
			
			return surroundingCells;
		}
		else{
			ArrayList<Cell> surroundingCells = new ArrayList<Cell>();
			int currX = this.getMyLocation()[0];
			int currY = this.getMyLocation()[1];
			if(currX >0 ){
				surroundingCells.add(myGrid[currX-1][currY]);
			}
			if(currX < myGrid.length-1){
				surroundingCells.add(myGrid[currX+1][currY]);
			}
			if(currY <myGrid[0].length-1){
				surroundingCells.add(myGrid[currX][currY+1]);
			}
			if(currX < myGrid[0].length-1&& currY < myGrid.length - 1){
				surroundingCells.add(myGrid[currX+1][currY+1]);
			}
			if(currY >0){
				surroundingCells.add(myGrid[currX][currY-1]);
			}
			if(currX <myGrid.length -1&& currY >0){
				surroundingCells.add(myGrid[currX+1][currY-1]);
			}
			
			
			return surroundingCells;
		}
		}
		else{
			if(!myShape.equals("Hexagon")){
				ArrayList<Cell> surroundingCells = new ArrayList<Cell>();
				int currX = this.getMyLocation()[0];
				int currY = this.getMyLocation()[1];
		
				if (currX > 0 && currY > 0) {
				
					surroundingCells.add(myGrid[currX-1][currY-1]);
				}
				if (currX == 0 && currY>0){
					surroundingCells.add(myGrid[myGrid.length-1][currY-1]);
				}
				if(currX>0 && currY == 0){
					surroundingCells.add(myGrid[currX-1][myGrid[0].length-1]);
				}
				if(currX==0 && currY ==0){
					surroundingCells.add(myGrid[myGrid.length-1][myGrid[0].length-1]);
				}
				if (currX > 0) {
				
					surroundingCells.add(myGrid[currX-1][currY]);
				}
				if(currX>0 && currY == myGrid[0].length-1){
					surroundingCells.add(myGrid[currX-1][0]);
				}
				if(currX == 0){
					surroundingCells.add(myGrid[myGrid.length-1][currY]);
				}
				if (currX > 0 && currY < myGrid[0].length-1) {
			
					surroundingCells.add(myGrid[currX-1][currY+1]);
				}
				if(currX == 0 && currY <myGrid[0].length-1){
					surroundingCells.add(myGrid[myGrid.length-1][currY+1]);
				}
				if(currX ==0 && currY == myGrid[0].length-1){
					surroundingCells.add(myGrid[myGrid.length-1][0]);
				}
				if (currY > 0) {
		
					surroundingCells.add(myGrid[currX][currY-1]);
				}
				if(currY == 0){
					surroundingCells.add(myGrid[currX][myGrid[0].length-1]);
				}
				if (currY < myGrid[0].length-1) {
					surroundingCells.add(myGrid[currX][currY+1]);
				}
				if(currY == myGrid[0].length-1){
					surroundingCells.add(myGrid[currX][0]);
				}
				if (currX < myGrid.length-1 && currY > 0) {
				
					surroundingCells.add(myGrid[currX+1][currY-1]);
				}
				if (currX == myGrid.length-1 && currY > 0) {
					
					surroundingCells.add(myGrid[0][currY-1]);
				}
				if(currX == myGrid.length-1){
					surroundingCells.add(myGrid[0][currY]);
				}
				if(currX == myGrid.length-1 && currY < myGrid[0].length-1){
					surroundingCells.add(myGrid[0][currY+1]);
				}
				if(currX == myGrid.length-1 && currY == myGrid[0].length-1){
					surroundingCells.add(myGrid[0][0]);
				}
				if(currX == myGrid.length-1 && currY ==0){
					surroundingCells.add(myGrid[0][myGrid[0].length-1]);
				}
				if (currX < myGrid.length-1) {
					
					surroundingCells.add(myGrid[currX+1][currY]);
				}
				if (currX < myGrid.length-1 && currY < myGrid[0].length-1) {
			
					surroundingCells.add(myGrid[currX+1][currY+1]);
				}
				if (currX <myGrid.length-1 && currY == myGrid[0].length-1){
					surroundingCells.add(myGrid[currX+1][0]);
				}
				if (currX <myGrid.length-1 && currY == 0){
					surroundingCells.add(myGrid[currX+1][myGrid[0].length-1]);
				}
				
				return surroundingCells;
			}
			else{
				ArrayList<Cell> surroundingCells = new ArrayList<Cell>();
				int currX = this.getMyLocation()[0];
				int currY = this.getMyLocation()[1];
				if(currX >0 ){
					surroundingCells.add(myGrid[currX-1][currY]);
				}
				if(currX ==0){
					surroundingCells.add(myGrid[myGrid.length-1][currY]);
				}
				if(currX < myGrid.length-1){
					surroundingCells.add(myGrid[currX+1][currY]);
				}
				if(currX == myGrid.length-1){
					surroundingCells.add(myGrid[0][currY]);
				}
				if(currX == myGrid.length-1 && currY<myGrid[0].length-1){
					surroundingCells.add(myGrid[0][currY+1]);
				}
				if(currX == myGrid.length-1 && currY==myGrid[0].length-1){
					surroundingCells.add(myGrid[0][0]);
				}
				if(currX == myGrid.length-1 && currY>0){
					surroundingCells.add(myGrid[0][currY-1]);
				}
				if(currX == myGrid.length-1 && currY==0){
					surroundingCells.add(myGrid[0][myGrid[0].length-1]);
				}
				if(currY <myGrid[0].length-1){
					surroundingCells.add(myGrid[currX][currY+1]);
				}
				if(currX < myGrid[0].length-1&& currY < myGrid.length - 1){
					surroundingCells.add(myGrid[currX+1][currY+1]);
				}
				if(currX < myGrid[0].length-1&& currY == myGrid.length - 1){
					surroundingCells.add(myGrid[currX+1][0]);
				}
				if(currX < myGrid[0].length-1&& currY == 0){
					surroundingCells.add(myGrid[currX+1][myGrid[0].length-1]);
				}
				if(currY >0){
					surroundingCells.add(myGrid[currX][currY-1]);
				}
				if(currY == 0){
					surroundingCells.add(myGrid[currX][myGrid[0].length-1]);
				}
				if(currY == myGrid[0].length-1){
					surroundingCells.add(myGrid[currX][0]);
				}
				if(currX <myGrid.length -1&& currY >0){
					surroundingCells.add(myGrid[currX+1][currY-1]);
				}
				
				
				return surroundingCells;
			}

		}
		}
	public int getMyValue(){
		return myValue;
	}
	public void setMyValue(int value){
		myValue = value;
	}
	public int getMyfPher(){
		return myfPher;
	}
	public void setMyfPher(int fpher){
		myfPher = fpher;
	}
	public int getMyhPher(){
		return myhPher;
	}
	public void setMyhPher(int hpher){
		myhPher = hpher;
	}
	public abstract boolean checkForMove( Cell[][] myGrid);
	public abstract void moveCell(Cell[][] myGrid);
	public abstract boolean checkIfBlockedIn(Cell[][] myGrid);
	public abstract void changeCellType(Cell[][] myGrid);
	public abstract void updateIfBlocked(Cell[][] myGrid);
	}

