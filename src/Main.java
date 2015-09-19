

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private final int windowSizeX = 500;
	private final int windowSizeY = 500;
	
	
	@Override
    public void start (Stage s) throws SAXException, IOException, ParserConfigurationException {
		Buttons myButtons = new Buttons();
		Grid myGrid = new Grid();
		System.out.println(myButtons.getSimName());
		s.setTitle(myButtons.getSimName());
        // attach game to the stage and display it
       Scene scene = myGrid.initGrid(s, "English", windowSizeX, windowSizeY);
        double[] square= {(double) windowSizeX, (double) windowSizeY};
        ArrayList<String> param = new ArrayList<String>();
        param.add("0.0");
        param.add("0.0");
        param.add("1.0");
        Simulation sim = new WatorWorld(scene, square, param);
        s.setScene(scene);
        s.show();
        
       
        
    }

    /**
     * Start the program.
     */
    public static void main (String[] args) {
        launch(args);
    }
}
