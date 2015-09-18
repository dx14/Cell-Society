import java.awt.Dimension;

import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class Cell {

	private Dimension myLocation;
	private String myColor;
	private Node myNode;
	
	public Cell(int x, int y, int sizeX, int sizeY, String value) {
		myLocation = new Dimension(x,y);
		myColor = value;
		myNode = new Rectangle(sizeX, sizeY);
		((Shape) myNode).setFill(Paint.valueOf(myColor));
	}
	
	
	public Node getMyNode() {
		return myNode;
	}

	public void setMyNode(Node myNode) {
		this.myNode = myNode;
	}

	public Dimension getMyLocation() {
		return myLocation;
	}
	public void setMyLocation(Dimension myLocation) {
		this.myLocation = myLocation;
	}
	public String getMyColor() {
		return myColor;
	}
	public void setMyColor(String myColor) {
		this.myColor = myColor;
	}
}
