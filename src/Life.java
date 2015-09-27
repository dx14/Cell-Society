import java.io.IOException;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

//Any live cell with fewer than two live neighbours dies, as if caused by under-population.
//Any live cell with two or three live neighbours lives on to the next generation.
//Any live cell with more than three live neighbours dies, as if by overcrowding.
//Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

//Any live cell with fewer than two live neighbours dies, as if caused by under-population.
//Any live cell with two or three live neighbours lives on to the next generation.
//Any live cell with more than three live neighbours dies, as if by overcrowding.
//Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

public class Life extends Simulation{
	

	Scene myScene;
	private Group root;
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
