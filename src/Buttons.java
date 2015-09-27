
import java.util.ResourceBundle;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Buttons {

	private static final int VBOX_GAP = 10;
	private static final int HBOX_GAP = 80;
	private static final int BUTTON_SIZE = 90;
	private static final double SPD_CHANGE = 0.2;
	private String[][] colors;
	private Cell[][] cells;
	private ResourceBundle myResources;
	private HBox hbox;
	private HBox windowTop;
	private Button loadButton;
	private Button resumeButton;
	public Button stopButton;
	private Button speedButton;
	private Button slowButton;
	private Button forwardButton;
	private CheckBox showOutlineButton;
	private CheckBox showChartButton;
	private ComboBox<String> sims;
	private ComboBox<String> shapes;
	private boolean isRunning = false;
	private double fps = 2;
	private String xml;
	private String shape;
	private String simName;
	private Timeline animation;
	Step myStep = new Step();
	
	public HBox addButtons(String language) {

		myResources = ResourceBundle.getBundle(language);

		hbox = new HBox(HBOX_GAP);
		hbox.setAlignment(Pos.BOTTOM_CENTER);

		VBox vbox1 = new VBox(VBOX_GAP);
		VBox vbox2 = new VBox(VBOX_GAP);
		VBox vbox3 = new VBox(VBOX_GAP);

		vbox1.setAlignment(Pos.TOP_CENTER);
		vbox2.setAlignment(Pos.TOP_CENTER);
		vbox3.setAlignment(Pos.TOP_CENTER);

		loadButton = new Button (myResources.getString("LoadCommand"));
		resumeButton = new Button (myResources.getString("ResumeCommand"));
		stopButton = new Button (myResources.getString("StopCommand"));
		speedButton = new Button (myResources.getString("SpeedCommand"));
		slowButton = new Button (myResources.getString("SlowCommand"));
		forwardButton = new Button (myResources.getString("ForwardCommand"));

		loadButton.setMinWidth(BUTTON_SIZE);
		resumeButton.setMinWidth(BUTTON_SIZE);
		stopButton.setMinWidth(BUTTON_SIZE);
		speedButton.setMinWidth(BUTTON_SIZE);
		slowButton.setMinWidth(BUTTON_SIZE);
		forwardButton.setMinWidth(BUTTON_SIZE);
		
		vbox1.getChildren().addAll(loadButton, forwardButton);
		vbox2.getChildren().addAll(resumeButton, stopButton);
		vbox3.getChildren().addAll(speedButton, slowButton);

		hbox.getChildren().addAll(vbox1, vbox2, vbox3);
		return hbox;
	}
	
	public HBox addBox (String language) {
		windowTop = new HBox(2*HBOX_GAP);
		windowTop.setAlignment(Pos.TOP_CENTER);
		VBox vbox = new VBox(VBOX_GAP);
		VBox vbox2 = new VBox(VBOX_GAP);
		
		showOutlineButton = new CheckBox (myResources.getString("OutlineCommand"));
		showChartButton = new CheckBox (myResources.getString("ChartCommand"));
		
		sims = new ComboBox<String>();
		sims.getItems().addAll(
				myResources.getString("Segregation"),
				myResources.getString("WaTor"),
				myResources.getString("Fire"),
				myResources.getString("Life"),
				myResources.getString("SlimeMolds"),
				myResources.getString("ForagingAnts"));
		sims.setPromptText(myResources.getString("ChooseSim"));
		
		shapes = new ComboBox<String>();
		shapes.getItems().addAll(
				myResources.getString("Square"),
				myResources.getString("Triangle"),
				myResources.getString("Hexagon"));
		shapes.setPromptText(myResources.getString("ChooseShape"));

		vbox.getChildren().addAll(sims, shapes);
		vbox2.getChildren().addAll(showOutlineButton, showChartButton);
		vbox.alignmentProperty().set(Pos.TOP_LEFT);
		vbox2.alignmentProperty().set(Pos.TOP_RIGHT);
		
		windowTop.getChildren().add(vbox);
		windowTop.getChildren().add(vbox2);
		
		return windowTop;
	}

	
	public void checkSim (){
		String simType = sims.getSelectionModel().getSelectedItem();
		switch (simType) {
		case "Segregation": 
			xml = "src/Segregation.xml";
			simName = "Segregation";
			break;
		case "WaTor World":
			xml = "src/Wator.xml";
			simName = "WatorWorld";
			break;
		case "Spreading of Fire":
			xml = "src/Fire.xml";
			simName = "Fire";
			break;
		case "Game of Life":
			xml = "src/GameOfLife.xml";
			simName = "Life";
			break;
		case "Slime Molds":
			xml = "src/SlimeMolds.xml";
			simName = "SlimeMolds";
			break;
		case "Foraging Ants":
			xml = "src/ForagingAnts.xml";
			simName = "ForagingAnts";
		default: 
			break;
		}
	}
	
	public void checkShape() {
		String shapeType = shapes.getSelectionModel().getSelectedItem();
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

	public void checkButtonClick(BorderPane border) {
		sims.setOnAction(e -> checkSim());
		shapes.setOnAction(e -> checkShape());
		
		loadButton.setOnMouseClicked(e -> loadSim(xml, shape, border));
		resumeButton.setOnMouseClicked(e -> resumeSim(xml, simName, shape, border));
		stopButton.setOnMouseClicked(e -> stopSim());
		showOutlineButton.setOnMouseClicked(e -> Cell.switchOutline());
		stopButton.setOnMouseClicked(e -> stopSim());
		showChartButton.setOnMouseClicked(e -> Simulation.switchChart());
		speedButton.setOnMouseClicked(e -> speedSim(border));
		slowButton.setOnMouseClicked(e -> slowSim(border));
		forwardButton.setOnMouseClicked(e -> forwardSim(border));
	}
	
	public void loadSim(String xml, String shape, BorderPane border){
		if (sims.getSelectionModel().getSelectedItem() != null &&
				shapes.getSelectionModel().getSelectedItem() != null) {
		Grid myGrid = new Grid();
		GUI myGUI = new GUI();
		Pane grid = myGrid.initGrid(xml, shape);
		cells = myGrid.getCells();
		myGUI.addGrid(grid, border);
		}
	}
	
	public void resumeSim(String xml, String sim, String shape, BorderPane bd)  {
		if (shape != null && sim != null) {		
			Step myStep = new Step();			
			animation = myStep.initLoop(cells, xml, sim, shape, bd);
			animation.play();
			isRunning = true;
		}
	}	
	
	public void stopSim() {
		if (isRunning) {
		animation.stop();
		isRunning = false;
		}
	}
	
	public void speedSim(BorderPane border) {
		if (isRunning){
			animation.stop();
			double fps2 = 0.2;
			if (fps > 0.2){
				fps2 = fps - SPD_CHANGE;
			}
			System.out.println(fps2);
			animation = myStep.changeLoop(shape, border, fps2);
			animation.play();
			fps=fps2;
		}
	}
	
	public void slowSim(BorderPane border) {
		if (isRunning) {
			animation.stop();
		}
		double fps2 = fps + SPD_CHANGE;
		System.out.println(fps2);
		animation = myStep.changeLoop(shape, border, fps2);
		animation.play();
		fps=fps2;
	}
//	
	
	public void forwardSim(BorderPane border) {
		if (isRunning) {
			animation.stop();
		}
		animation = myStep.stepLoop(shape, border, fps);
		animation.play();
	}
}