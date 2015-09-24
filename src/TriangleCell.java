import java.util.ArrayList;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class TriangleCell extends Cell{

	public TriangleCell(int x, int y, int sizeX, int sizeY, String value) {
		super(x, y, sizeX, sizeY, value);
		Polygon p;
		if(((x+y) % 2) == 0){
			if(y == 0)
				p = new Polygon(new double[] {y +0.5*sizeX, x, y , x + sizeY, y + sizeX, x + sizeY});
			else{
				p = new Polygon(new double[] {y, x, y -0.5*sizeX, x + sizeY, y + 0.5*sizeX, x + sizeY});
			}
		}
		else
			if(y == 0)
				p = new Polygon(new double[] {y - 0.5*sizeX , x , y  +0.5*sizeX, x , y, x + sizeY});
			else{
				p = new Polygon(new double[] {y - sizeX , x , y  , x , y - 0.5*sizeX, x + sizeY});
			}
		p.setFill(Paint.valueOf(myColor));
		myNode = p;
	}

	@Override
	public ArrayList<Cell> getSurroundingCells(Cell[][] myGrid) {
		ArrayList<Cell> surroundingCells = new ArrayList<Cell>();
		int currX = this.getMyLocation()[0];
		int currY = this.getMyLocation()[1];

		if (currX > 0 && currY > 0) {
			surroundingCells.add(myGrid[currX-1][currY-1]);
		}
		if (currX > 0) {
			surroundingCells.add(myGrid[currX-1][currY]);
		}
		if (currX > 0 && currY < Grid.gridRows-1) {
			surroundingCells.add(myGrid[currX-1][currY+1]);
		}
		if (currY > 0) {
			surroundingCells.add(myGrid[currX][currY-1]);
		}
		if (currY < Grid.gridRows-1) {
			surroundingCells.add(myGrid[currX][currY+1]);
		}
		if (currX < Grid.gridColumns-1 && currY > 0) {
			surroundingCells.add(myGrid[currX+1][currY-1]);
		}
		if (currX < Grid.gridColumns-1) {
			surroundingCells.add(myGrid[currX+1][currY]);
		}
		if (currX < Grid.gridColumns-1 && currY < Grid.gridRows-1) {
			surroundingCells.add(myGrid[currX+1][currY+1]);
		}
		
		return surroundingCells;
	}

}
