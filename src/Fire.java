import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.scene.Scene;

public class Fire extends Simulation{

	public Fire(double[] dimensions, ArrayList<String> parameters)
			throws SAXException, IOException, ParserConfigurationException {
		super(dimensions, parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkSurroundings(ArrayList<String> myParameters, int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void moveCell(Cell[][] grid, Cell c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCellToEmpty(Cell[][] grid, Cell c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEmptyToCell(Cell[][] grid, Cell c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeCellType(Cell[][] grid, Cell c) {
		// TODO Auto-generated method stub
		
	}

}