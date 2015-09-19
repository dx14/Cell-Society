import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Buttons {

	private static final int BOX_GAP = 10;
	private HBox hbox;
	private Scene window;
	private ResourceBundle myResources;
	//	private static final String SOURCE_PATH = "src/";
	private String simName;
	private String simAuthor;
	private int gridColumns; 
	private int gridRows;
	private double cellSize;

	public HBox initButtons(Stage s, String language, int width, int height) throws SAXException, IOException, ParserConfigurationException {
		
		handleDom("src/Segregation.xml");
		myResources = ResourceBundle.getBundle(language);

		hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);

		window = new Scene(hbox, width, height);

		VBox vbox1 = new VBox(BOX_GAP);
		VBox vbox2 = new VBox(BOX_GAP);
		VBox vbox3 = new VBox(BOX_GAP);

		vbox1.setAlignment(Pos.TOP_CENTER);
		vbox2.setAlignment(Pos.TOP_CENTER);
		vbox3.setAlignment(Pos.TOP_CENTER);

		Button pauseButton = new Button (myResources.getString("PauseCommand"));
		Button resumeButton = new Button (myResources.getString("ResumeCommand"));
		Button forwardButton = new Button (myResources.getString("ForwardCommand"));
		Button speedButton = new Button (myResources.getString("SpeedCommand"));
		Button slowButton = new Button (myResources.getString("SlowCommand"));

		pauseButton.setOnMouseClicked(e -> pauseSim());
		resumeButton.setOnMouseClicked(e -> resumeSim());
		forwardButton.setOnMouseClicked(e -> fwdSim());
		speedButton.setOnMouseClicked(e -> speedSim());
		slowButton.setOnMouseClicked(e -> slowSim());

		vbox1.getChildren().add(pauseButton);
		vbox1.getChildren().add(resumeButton);
		vbox2.getChildren().add(forwardButton);
		vbox3.getChildren().add(speedButton);
		vbox3.getChildren().add(slowButton);

		hbox.getChildren().addAll(vbox1, vbox2, vbox3);

		return hbox;
	}

	public void handleDom(String file) throws SAXException, IOException, ParserConfigurationException {

		File xmlFile = new File(file); 
		DocumentBuilderFactory dBFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dBFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();

		Dom myDom = new Dom();
		simAuthor = myDom.getAuthor(doc);
		simName = myDom.getTitle(doc);
		gridColumns = myDom.getDimensionX(doc);
		gridRows = myDom.getDimensionY(doc);
	}

	public Rectangle makeCell (double size, String color) {
		Rectangle cell = new Rectangle (cellSize, cellSize, Paint.valueOf(color));
		return cell;
	}

	public void pauseSim() {
		
	}

	public void resumeSim() {

	}

	public void speedSim() {

	}

	public void slowSim() {

	}

	public void fwdSim() {

	}

	public String getSimName() {
		return simName;
	}

	public String getSimAuthor() {
		return simAuthor;
	}

	public int getGridColumns() {
		return gridColumns;
	}

	public int getGridRows() {
		return gridRows;
	}

	public double getCellSize() {
		return cellSize;
	}
}