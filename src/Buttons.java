import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Buttons {

	private static final int VBOX_GAP = 20;
	private static final int HBOX_GAP = 80;
	private static final int BUTTON_SIZE = 90;
	private static final int SPD_CHANGE = 2;
	private ResourceBundle myResources;
	private HBox hbox;
	private HBox windowTop;
	private Button loadButton;
	private Button resumeButton;
	private Button stopButton;
	private Button speedButton;
	private Button slowButton;
	private Button forwardButton;
	private ComboBox<String> sims;
	private ComboBox<String> shapes;
	private boolean isRunning = false;
	private String xml;
	private String shape;
	private String simName;
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
		windowTop = new HBox();
		windowTop.setAlignment(Pos.CENTER_LEFT);
		VBox vbox = new VBox();

		sims = new ComboBox<String>();
		sims.getItems().addAll(
				myResources.getString("Segregation"),
				myResources.getString("WaTor"),
				myResources.getString("Fire"),
				myResources.getString("Life"));
		sims.setPromptText(myResources.getString("ChooseSim"));
		
		shapes = new ComboBox<String>();
		shapes.getItems().addAll(
				myResources.getString("Square"),
				myResources.getString("Triangle"),
				myResources.getString("Hexagon"));
		shapes.setPromptText(myResources.getString("ChooseShape"));

		vbox.getChildren().addAll(sims, shapes);
		windowTop.getChildren().add(vbox);
		return windowTop;
	}
	
	public void checkSim () {
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

	public void checkButtonClick(int fps, BorderPane border) {
		sims.setOnAction(e -> checkSim());
		shapes.setOnAction(e -> checkShape());
		loadButton.setOnMouseClicked(e -> loadSim(fps, xml, shape, border));
		resumeButton.setOnMouseClicked(e -> resumeSim(xml, simName, shape, border));
//		stopButton.setOnMouseClicked(e -> stopSim(tm, fps));
//		speedButton.setOnMouseClicked(e -> speedSim(tm, fps, border));
//		slowButton.setOnMouseClicked(e -> slowSim(tm, fps, border));
//		forwardButton.setOnMouseClicked(e -> stepSim(tm, fps, border));
	}
	
	public void loadSim(int fps, String xml, String shape, BorderPane border) {
//		if (isRunning)
//			tm.stop();
		if (sims.getSelectionModel().getSelectedItem() != null &&
				shapes.getSelectionModel().getSelectedItem() != null) {
		Grid myGrid = new Grid();
		GUI myGUI = new GUI();
		Pane grid = myGrid.initGrid(xml, shape);   // initGrid should take in shape too
		myGUI.addGrid(grid, border);
		}
	}
	
	public void resumeSim(String xml, String sim, String shape, BorderPane bd)  {
		if (shape != null && sim != null) {
			if (!isRunning) {
				Grid myGrid = new Grid();
				Step myStep = new Step();
				myGrid.initCells(xml, shape);
				myStep.startLoop(xml, sim, shape, bd);
				isRunning = true;
			}
		}
	}
//	
//	public void stopSim(Timeline tm, int fps) {
//		if (isRunning) {
//		tm.stop();
//		isRunning = false;
//		}
//	}
//	
//	public void speedSim(Timeline tm, int fps, BorderPane border) {
//		if (isRunning) {
//		tm.stop();
//		Timeline animation =  new Timeline();
//		final int fps2 = fps+SPD_CHANGE;
//		KeyFrame frame = new KeyFrame(Duration.seconds(fps2),
//				e -> buttonStep(animation, fps2, border));
//		animation.setCycleCount(Timeline.INDEFINITE);
//		animation.getKeyFrames().add(frame);
//		animation.play();
//		}
//	}
//	
//	public void slowSim(Timeline tm, int fps, BorderPane border) {
//		if (isRunning) {
//		tm.stop();
//		Timeline animation =  new Timeline();
//		final int fps2 = fps/SPD_CHANGE;
//		KeyFrame frame = new KeyFrame(Duration.seconds(fps2),
//				e -> buttonStep(animation, fps2, border));
//		animation.setCycleCount(Timeline.INDEFINITE);
//		animation.getKeyFrames().add(frame);
//		animation.play();
//		}
//	}
//	
//	public void stepSim(Timeline tm, int fps, BorderPane border) {
//		if (!isRunning)
//			tm.stop();
//		
//		Timeline animation =  new Timeline();
//		KeyFrame frame = new KeyFrame(Duration.seconds(1),
//				e -> buttonStep(animation, fps, border));
//		animation.setCycleCount(1);
//		animation.getKeyFrames().add(frame);
//		animation.play();
//		isRunning = false;
//	}
}