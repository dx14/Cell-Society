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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

public class GUI {

	private Scene myScene;
	private BorderPane border;
	private final int fps = 1;
	private double bpX;
	private double bpY;
	
	Buttons myButtons = new Buttons();
	Dom myDom = new Dom();
	Grid myGrid = new Grid();

	public Scene initGUI() throws SAXException, IOException, ParserConfigurationException {
		border = new BorderPane();
		myScene = new Scene(border, Main.windowSizeX, Main.windowSizeY);
		border.setPadding(new Insets(30));
		border.setStyle("-fx-background-color: white;");
		HBox buttons = myButtons.addButtons("English");
		HBox box = myButtons.addBox("English");
		border.setBottom(buttons);	
		border.setTop(box);	
		bpX = Math.abs(myScene.getWidth()-border.getPadding().getLeft() - border.getPadding().getRight());
		bpY = Math.abs(myScene.getHeight()-border.getPadding().getTop() - 6*border.getPadding().getBottom());
		myGrid.getCellSize(bpX, bpY);
		myButtons.checkButtonClick(fps, border);
		return myScene;
	}
	
	public void addGrid(Pane grid, BorderPane bd) {			
		bd.setCenter(grid);
		bd.getCenter().relocate(Main.windowSizeX, Main.windowSizeY);
	}
	
	
	public double getBpX() {
		return bpX;
	}

	public void setBpX(double bpX) {
		this.bpX = bpX;
	}

	public double getBpY() {
		return bpY;
	}

	public void setBpY(double bpY) {
		this.bpY = bpY;
	}
}