import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class SlimeMolds extends Simulation{

	public SlimeMolds(double[] dimensions, ArrayList<String> parameters)
			throws SAXException, IOException, ParserConfigurationException {
		super(dimensions, parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkForMove(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void moveCell(Cell c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loopThroughCells() {
		// TODO Auto-generated method stub
		
	}

}
