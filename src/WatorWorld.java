import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.scene.Scene;

public class WatorWorld extends Simulation{

	public WatorWorld(Scene scene, double[] dimensions, ArrayList<Integer> parameters) throws SAXException, IOException, ParserConfigurationException {
		super(scene, dimensions, parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moveCell(Grid g, Cell c) {
		// TODO Auto-generated method stub
		
	}

}
