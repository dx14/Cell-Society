package Simulations;

import java.util.ArrayList;

public abstract class Simulation {
	private String myDimensions;
	private ArrayList<Integer> myParameters;
	public Simulation(String dimensions, ArrayList<Integer> parameters){
		myDimensions = dimensions;
		myParameters = parameters;
	}
	public String getDimensions(){
		return myDimensions;
	}
	public ArrayList<Integer> getParameters(){
		return myParameters;
	}
	public void step(Double elapsedTime){
		
	}
	public abstract void moveCell();
	public abstract void checkSurroundings();
}
