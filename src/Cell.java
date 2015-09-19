import java.awt.Dimension;
import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class Cell {

	private int[] myLocation = new int[2];
	private String myColor;
	private Node myNode;
	private int direction;
	private String myCellType;
	
	public Cell(int x, int y, int sizeX, int sizeY, String value) {
		myLocation[0] = x;
		myLocation[1] = y;
		myColor = value;
		Rectangle rec = new Rectangle(sizeX, sizeY);
		rec.setFill(Paint.valueOf(myColor));
		myNode = rec;
	
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
//	public abstract boolean checkSurroundings(ArrayList<String> myParameters, int x, int y);
	public String getCellType(){
		return myCellType;
	}
	public void setCellType(String type){
		myCellType = type;
	}


	
}
