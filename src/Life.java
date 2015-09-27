import java.util.List;
import javafx.scene.Scene;

public class Life extends Simulation{

	Scene myScene;
	public void setScene(Scene ss){
		myScene = ss;
	}

	public Life(  double[] dimensions, List<String> params)
	{
		super(dimensions, params);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void loopThroughCells(Cell[][] cells){
		Cell[][] tempCells = new Cell[Dom.dimensionX][Dom.dimensionY];
		for (int col = 0; col < Dom.dimensionX; col++) {
			for (int row = 0; row < Dom.dimensionY; row++) {
				int cellwidth = cells[col][row].getMyWidth();
				int cellheight = cells[col][row].getMyHeight();
				String cellshape = cells[col][row].getMyShape();
				if (cells[col][row].checkForMove(cells)) {
					
					tempCells[col][row] = new LifePerson(col, row, cellwidth, cellheight, "BLACK", cellshape );
				}
				else{
					tempCells[col][row] = new EmptyLife(col, row, cellwidth, cellheight, "WHITE", cellshape );			

				}
			}
		}
		for(int i=0; i<cells.length; i++){
			for (int j=0; j<cells[0].length; j++){
				cells[i][j] = tempCells[i][j];
			}
		}
	}
}
