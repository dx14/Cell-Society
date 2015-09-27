import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class SlimeMolds extends Simulation{

public SlimeMolds(double[] size, List<String> params)
			throws SAXException, IOException, ParserConfigurationException {
		super(size, params);
		// TODO Auto-generated constructor stub
	}



	

	@Override
	public void loopThroughCells(Cell[][]  cells) {
		
		for (int col = 0; col < Dom.dimensionX; col++) {
			
			for (int row = 0; row < Dom.dimensionY; row++) {
				int cellwidth = cells[col][row].getMyWidth();
				int cellheight = cells[col][row].getMyHeight();
				String cellshape = cells[col][row].getMyShape();
				if (cells[col][row].checkForMove(cells) && !cells[row][col].checkIfBlockedIn(cells)) {
					cells[col][row].moveCell(cells);
					
				}
				
				
			}
		}
		
	}

}
