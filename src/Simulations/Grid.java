package Simulations;

import javafx.scene.paint.Color;

public abstract class Grid {
	private int myWidth;
	private int myHeight;

	Grid(int width, int height){
		myWidth = width;
		myHeight = height;
	}
	public int getWidth(){
		return myWidth;
	}
	public int getHeight(){
		return myHeight;
	}
	public Cell getCell(int x, int y){
		Cell c = new EmptyCell(Color.WHITE);
		return c;
	}
	public EmptyCell getEmptyCell(){
		EmptyCell c = new EmptyCell(Color.WHITE);
		return c;
	};
	public abstract boolean isValidMove(int[] spot);
}
