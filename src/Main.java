import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static final int windowSizeX = 500;
	public static int windowSizeY = 500;
	
	@Override
    public void start (Stage s) throws SAXException, IOException, ParserConfigurationException {
		Grid myGrid = new Grid();
        Scene scene = myGrid.initGrid(s, "English", windowSizeX, windowSizeY);
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
