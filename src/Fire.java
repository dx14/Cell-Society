import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fire extends Simulation{


	Scene myScene;
	private Group root;
	double probCatch = .2;
	public Grid iGrid = new Grid();
	protected Cell[][] myGrid = iGrid.getCells();
	public Fire( double[] dimensions, List<String> params)
			throws SAXException, IOException, ParserConfigurationException {
		super(dimensions, params);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loopThroughCells(){
		for (int col = 0; col < Dom.dimensionX; col++) {
			for (int row = 0; row < Dom.dimensionY; row++) {
				Cell curr = myGrid[col][row];
				int cellwidth = myGrid[row][col].getMyWidth();
				int cellheight = myGrid[row][col].getMyHeight();
				String cellshape = myGrid[row][col].getMyShape();
				ArrayList<Cell> nb = new ArrayList<Cell>(curr.getSurroundingCells(myGrid));
				for (Cell cell : nb) {
					if (curr.checkForMove(myGrid)) {

						int x = cell.getMyLocation()[0];
						int y = cell.getMyLocation()[1];

						if (!myGrid[x][y].getMyColor().equals("YELLOW"))
							myGrid[x][y] = new Burning(row, col, cellwidth, cellheight, "RED", cellshape);
					}
					else{
						continue;
					}
				}
			}
			
		}
	}
}
