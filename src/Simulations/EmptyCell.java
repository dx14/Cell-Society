package Simulations;

import javafx.scene.paint.Paint;

public class EmptyCell extends Cell{

	public EmptyCell( Paint color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkSurroudings() {
		return false;
		
	}

}
