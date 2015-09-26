import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class ForagingAnts extends Simulation {

	public ForagingAnts(double[] dimensions, ArrayList<String> parameters)
			throws SAXException, IOException, ParserConfigurationException {
		super(dimensions, parameters);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void loopThroughCells() {
		for(int i = 0; i<Grid.gridRows; i++){
			for(int j = 0; j<Grid.gridColumns; j++){
				myGrid[i][j].checkForMove(myGrid);
			}
		}
		
	}

}
