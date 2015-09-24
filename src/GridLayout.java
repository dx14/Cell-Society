import java.util.ArrayList;
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Shape;


public class GridLayout {
	Cell[][] cells;
	
	public Cell[][] getCells() {
		return cells;
	}



	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	public GridPane gridMaker(int width, int height, int gridColumns, int gridRows, String[][] colors){
		GridPane grid = new GridPane();
		//don't think this if statement works
//		if (root.getChildren().contains(grid)){
//			root.getChildren().remove(grid);
//		}
		int cellX = (width/gridColumns);
        for (int i=0; i<gridColumns; i++){
        	grid.getColumnConstraints().add(new ColumnConstraints(cellX));
        } 
        
        int cellY = height/gridRows;
        for (int j=0; j<gridRows; j++){
        	grid.getRowConstraints().add(new RowConstraints(cellY));
        }
        
        cells = new Cell[gridColumns][gridRows];
        for (int row = 0; row < gridColumns; row++) {       	
        	for (int col = 0; col < gridRows; col++) {        		
        		String color = colors[row][col];
        		Cell myCell = new RectangleCell(row, col, cellX, cellY, color);
        		cells[row][col] = myCell;
        		grid.add((Shape) myCell.getMyNode(), col, row);
        	}
        }

//        System.out.println("here");
        return grid;
	}

}
