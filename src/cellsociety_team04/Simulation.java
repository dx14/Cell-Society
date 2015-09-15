package cellsociety_team04;

import java.util.ArrayList;

public abstract class Simulation {
	private String myDimensions;
	private ArrayList<Integer> myParameters;
	public Simulation(String dimensions, ArrayList<Integer> parameters){
		myDimensions = dimensions;
		myParameters = parameters;
	}
}
