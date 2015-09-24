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
	private ResourceBundle myResources;
	private Button pauseButton;
	private Button resumeButton;
	private Button forwardButton;
	private Button speedButton;
	private Button slowButton;

	public HBox addButtons(String language) throws SAXException, IOException, ParserConfigurationException {
		
<<<<<<< HEAD
=======
		handleDom("src/Segregation.xml");
>>>>>>> b7733981bd6068d0d830244ef1ef07d4dfdda788
		myResources = ResourceBundle.getBundle(language);

		hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);

		VBox vbox1 = new VBox(BOX_GAP);
		VBox vbox2 = new VBox(BOX_GAP);
		VBox vbox3 = new VBox(BOX_GAP);

		vbox1.setAlignment(Pos.TOP_CENTER);
		vbox2.setAlignment(Pos.TOP_CENTER);
		vbox3.setAlignment(Pos.TOP_CENTER);

		pauseButton = new Button (myResources.getString("PauseCommand"));
		resumeButton = new Button (myResources.getString("ResumeCommand"));
		forwardButton = new Button (myResources.getString("ForwardCommand"));
		speedButton = new Button (myResources.getString("SpeedCommand"));
		slowButton = new Button (myResources.getString("SlowCommand"));

		vbox1.getChildren().add(pauseButton);
		vbox1.getChildren().add(resumeButton);
		vbox2.getChildren().add(forwardButton);
		vbox3.getChildren().add(speedButton);
		vbox3.getChildren().add(slowButton);

		hbox.getChildren().addAll(vbox1, vbox2, vbox3);

		return hbox;
	}
}