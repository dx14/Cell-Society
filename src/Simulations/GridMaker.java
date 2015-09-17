package simulations;

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
	
	public Scene initGrid (int width, int height) {
		
		Group group = new Group();
		Scene window = new Scene(group, width, height, Color.WHITE);
		
        Rectangle cell = new Rectangle();
        
        GridPane grid = new GridPane();
        for (int row = 0; row < gridColumns; row++) {
        	for (int col = 0; col < gridRows; col++) {
        		if ((row+col) % 2 == 0) cell = makeCell(cellSize, "RED");
        		else cell = makeCell(cellSize, "BLUE");
        		grid.add(cell, col, row);
//        		cell.widthProperty().bind(grid.widthProperty().divide(cellSize));
//                cell.heightProperty().bind(grid.heightProperty().divide(cellSize));
        	}
        }
        group.getChildren().add(grid);
        return window;
    }
	
	public Rectangle makeCell (int size, String color) {
		Rectangle cell = new Rectangle (cellSize, cellSize, Paint.valueOf(color));
		return cell;
	}
}
