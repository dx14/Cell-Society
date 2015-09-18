package Simulations;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public class GridMaker {
	
	private String simName;
	private String simAuthor;
	private final int gridColumns = 20; 
	private final int gridRows = 20;
	private final int cellSize = 10;
	private Cell[] myCells = {
			new BlueCell(Color.BLUE), 
	        new RedCell(Color.RED), 
	        new EmptyCell(Color.WHITE)
	};
	public Scene initGrid (int width, int height) {
		
		Group group = new Group();
		Scene window = new Scene(group, width, height, Color.WHITE);
		
        
        
        GridPane grid = new GridPane();
        Cell cell;
        for (int row = 0; row < gridColumns; row++) {
        	for (int col = 0; col < gridRows; col++) {
        		int[] loc = {row,col};
        		if ((row+col) % 2 == 0) cell = makeCell(1);
        		else cell = makeCell(2);
        		grid.add(cell, col, row);
//        		cell.widthProperty().bind(grid.widthProperty().divide(cellSize));
//                cell.heightProperty().bind(grid.heightProperty().divide(cellSize));
        	}
        }
        group.getChildren().add(grid);
        return window;
    }
	
	public Cell makeCell (int color) {
		Cell cell = myCells[color];
		return cell;
	}
}
