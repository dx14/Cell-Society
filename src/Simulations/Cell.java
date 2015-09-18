package Simulations;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public abstract class Cell {
	private int[] myLocation;
	private Paint myColor;
	public Cell(Paint color){
		myColor = color;
	}
	public void setLocation(int[] loc){
		myLocation = loc;
	}
	public int[] getLocation(){
		return myLocation;
	}
	public void setColor(Paint color){
		myColor = color;
	}
	public String getColor(){
		return myColor.toString();
	};
	public abstract boolean checkSurroudings();
}
