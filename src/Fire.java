import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import javafx.scene.Group;
import javafx.scene.Scene;

public class Fire extends Simulation{


	Scene myScene;
	private Group root;
	double probCatch = .2;
	public Fire(double[] dimensions, List<String> params)
	{
		super(dimensions, params);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loopThroughCells(Cell[][] cells){
		for (int col = 0; col < Dom.dimensionX; col++) {
			for (int row = 0; row < Dom.dimensionY; row++) {
				Cell curr = cells[col][row];
				int cellwidth = cells[row][col].getMyWidth();
				int cellheight = cells[row][col].getMyHeight();
				String cellshape = cells[row][col].getMyShape();
				ArrayList<Cell> nb = new ArrayList<Cell>(curr.getSurroundingCells(cells));
				for (Cell cell : nb) {
					if (curr.checkForMove(cells)) {

						int x = cell.getMyLocation()[0];
						int y = cell.getMyLocation()[1];

						if (!cells[x][y].getMyColor().equals("YELLOW"))
							cells[x][y] = new Burning(row, col, cellwidth, cellheight, "RED", cellshape);
					}
					else{
						continue;
					}
				}
			}
			
		}
	}
}
