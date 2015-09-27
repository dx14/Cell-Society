import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Step {

	private int FRAMES_PER_SECOND = 60;
	private int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	private double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private Timeline animation;
	int two = 2;
	
	Buttons myButtons = new Buttons();
	Grid myGrid = new Grid();
	
	String xml;
	String shape;
	
	public void initLoop(String xml, String sim, String shape, BorderPane bd)  { 
		int FRAMES_PER_SECOND = 1;
		double[] square = {Main.windowSizeX, Main.windowSizeY};
		Cell[][] myCells = myGrid.initCells(xml, shape);		
		ArrayList<String> params = getParams();
		Simulation mySim =  simFactory(xml, square, params);
		Timeline animation =  new Timeline();
		KeyFrame frame = new KeyFrame(Duration.seconds(FRAMES_PER_SECOND),
				e -> mySim.simStep (myCells, shape, bd));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
	}
	
	public void start(){
		animation.play();
	}
	
	public void speedUp(){
		FRAMES_PER_SECOND+=2;
	}
	
	public void slowDown(){
		FRAMES_PER_SECOND/=2;
	}

	public void stop(){
		animation.stop();
	}
	
	public void checkSim (){
		String simType = myButtons.sims.getSelectionModel().getSelectedItem();
		switch (simType) {
		case "Segregation": 
			xml = "src/Segregation.xml";
			myButtons.simName = "Segregation";
			break;
		case "WaTor World":
			xml = "src/Wator.xml";
			myButtons.simName = "WatorWorld";
			break;
		case "Spreading of Fire":
			xml = "src/Fire.xml";
			myButtons.simName = "Fire";
			break;
		case "Game of Life":
			xml = "src/GameOfLife.xml";
			myButtons.simName = "Life";
			break;
		default: 
			break;
		}
	}
	
	public void checkButtonClick(int fps, BorderPane border) {
		myButtons.addBox("English");
		myButtons.addButtons("English");
		myButtons.sims.setOnAction(e -> checkSim());
		myButtons.shapes.setOnAction(e -> checkShape());
		myButtons.loadButton.setOnMouseClicked(e -> loadSim(fps, xml, shape, border));
		myButtons.resumeButton.setOnMouseClicked(e -> start());
		myButtons.showOutlineButton.setOnMouseClicked(e -> Cell.switchOutline());
		myButtons.stopButton.setOnMouseClicked(e -> stop());
//		speedButton.setOnMouseClicked(e -> speedSim(tm, fps, border));
//		slowButton.setOnMouseClicked(e -> slowSim(tm, fps, border));
//		forwardButton.setOnMouseClicked(e -> stepSim(tm, fps, border));
	}
	
	
	public void checkShape() {
		String shapeType = myButtons.shapes.getSelectionModel().getSelectedItem();
		switch (shapeType) {
		case "Square": 
			shape = "Square";
			break;
		case "Triangle":
			shape = "Triangle";
			break;
		case "Hexagon":
			shape = "Hexagon";
			break;
		default: 
			break;
		}
	}
	
	public void loadSim(int fps, String xml, String shape, BorderPane border){
//		if (isRunning)
//			tm.stop();
		if (myButtons.sims.getSelectionModel().getSelectedItem() != null &&
				myButtons.shapes.getSelectionModel().getSelectedItem() != null) {
		Grid myGrid = new Grid();
		GUI myGUI = new GUI();
		Pane grid = myGrid.initGrid(xml, shape);   // initGrid should take in shape too
		myGUI.addGrid(grid, border);
		}
	}
	
	public ArrayList<String> getParams(){
		ArrayList<String> parameters = new ArrayList<String>();
		for (int i=0; i<Dom.params.size(); i++){
			parameters.add(Dom.params.get(i));
		}
		return parameters;
	}
	
	public Simulation simFactory(String xml, double[] square, ArrayList<String> params) {
		String[] simName = {"src/Segregation.xml", "src/GameOfLife.xml", "src/Fire.xml", "src/Wator.xml"};

		int last = 0;
		for (int i=0; i<simName.length; i++){
			if (xml.equals(simName[i])){
				last = i;
			}
		}		
		Simulation[] mySims = {new Segregation(square, params),
								new Life(square, params),
								new Fire(square, params),
								new WatorWorld(square, params)};
		return mySims[last];
	}
}
