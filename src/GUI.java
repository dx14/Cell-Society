import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class GUI {

	private Scene myScene;
	private BorderPane border;
	private double bpX;
	private double bpY;
	
	Buttons myButtons = new Buttons();
	Dom myDom = new Dom();
	Grid myGrid = new Grid();
	Step myStep = new Step();

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
		bpY = Math.abs(myScene.getHeight()-2*border.getPadding().getTop() - 5*border.getPadding().getBottom());
		myGrid.getCellSize(bpX, bpY);
		myButtons.checkButtonClick(border);
		return myScene;
	}
	
	public void addGrid(Pane grid, BorderPane bd) {			
		bd.setCenter(grid);
		bd.getCenter().relocate(Main.windowSizeX, Main.windowSizeY);
	}
	
	public void addChart(LineChart<Number, Number> chart, BorderPane bd) {
		bd.setCenter(chart);
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