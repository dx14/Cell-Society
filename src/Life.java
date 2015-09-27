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
				int cellwidth = cells[row][col].getMyWidth();
				int cellheight = cells[row][col].getMyHeight();
				String cellshape = cells[row][col].getMyShape();
				if (cells[row][col].checkForMove(cells)) {
					tempCells[row][col] = new LifePerson(row, col, cellwidth, cellheight, "BLACK", cellshape );
				}
				else{
					tempCells[row][col] = new EmptyLife(row, col, cellwidth, cellheight, "WHITE", cellshape );			

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
