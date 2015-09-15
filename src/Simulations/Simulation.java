package Simulations;

import java.util.ArrayList;

public abstract class Simulation {
	private String myDimensionString;
	private ArrayList<Integer> myParameters = new ArrayList<Integer>();
	private ArrayList<Integer> myDimensions = new ArrayList<Integer>();
	public Simulation(String dimensions, ArrayList<Integer> parameters){
		myDimensionString = dimensions;
		myParameters = parameters;
		for(int i = 0; i<myDimensionString.length(); i++){
			if(myDimensionString.charAt(i) == 'x'){
				continue;
			}
			else
				myDimensions.add(i);
		}
	}
	public String getDimensionString(){
		return myDimensionString;
	}
	public ArrayList<Integer> getParameters(){
		return myParameters;
	}
	public ArrayList<Integer> getDimensions(){
		return myDimensions;
	}
	public void step(Double elapsedTime){
		if(checkSurroundings())
			moveCell();
		
		
	}
	public abstract void moveCell();
	public abstract boolean checkSurroundings();
}
