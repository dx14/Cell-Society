import java.util.ArrayList;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class RectangleCell extends Cell{

	public RectangleCell(int x, int y, int sizeX, int sizeY, String value) {
		super(x, y, sizeX, sizeY, value);
		// TODO Auto-generated constructor stub
		Rectangle rec = new Rectangle(sizeX, sizeY);
		rec.setFill(Paint.valueOf(myColor));
		myNode = rec;
	}

	@Override
	public ArrayList<Cell> getSurroundingCells( Cell[][] myGrid) {
		

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
