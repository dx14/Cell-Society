import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.scene.Scene;

public class WatorWorld extends Simulation{

	public WatorWorld(Scene scene, double[] dimensions, ArrayList<String> parameters) throws SAXException, IOException, ParserConfigurationException {
		super(scene, dimensions, parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moveCell(Grid g, Cell c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCellToEmpty(Grid g, Cell c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEmptyToCell(Grid g, Cell c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeCellType(Grid g, Cell c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkSurroundings(ArrayList<String> myParameters, int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

}
