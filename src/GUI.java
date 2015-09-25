import java.io.IOException;
import java.util.ResourceBundle;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class GUI {

	private Scene myScene;
	private BorderPane border;
	
	Dom myDom = new Dom();
	Buttons myButtons = new Buttons();

	public GUI (Scene scene) {
		myScene = scene;
	}

	public Scene initGUI() throws SAXException, IOException, ParserConfigurationException {
		myScene = new Scene(border, Main.windowSizeX, Main.windowSizeY);
		HBox buttons = myButtons.addButtons("English");
		border.getChildren().add(buttons);
		return myScene;
	}

//	public addGrid(GridPane grid); {
//	}
}