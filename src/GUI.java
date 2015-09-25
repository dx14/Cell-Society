import java.io.IOException;
import java.util.ResourceBundle;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

public class GUI {

	private Scene myScene;
	private BorderPane border = new BorderPane();
	
	Buttons myButtons = new Buttons();
	Dom myDom = new Dom();
		
	public Scene initGUI() throws SAXException, IOException, ParserConfigurationException {
		myScene = new Scene(border, Main.windowSizeX, Main.windowSizeY, Color.RED);
		border.setPadding(new Insets(30));
		border.setStyle("-fx-background-color: white;");
		HBox buttons = myButtons.addButtons("English");
		ComboBox<String> box = myButtons.addBox("English");
		border.setBottom(buttons);	
		border.setTop(box);
		startButtonStep();
		return myScene;
	}
	
	public void startButtonStep() { 
		int FRAMES_PER_SECOND = 1;
		Timeline animation =  new Timeline();
		KeyFrame frame = new KeyFrame(Duration.seconds(FRAMES_PER_SECOND),
				e -> myButtons.buttonStep(animation, FRAMES_PER_SECOND));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	
	public void addGrid(Pane grid) {
		border.setCenter(grid);
	}
}