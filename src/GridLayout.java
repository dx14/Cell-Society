import java.util.ArrayList;
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
	
	public Pane gridMaker(int width, int height, int gridColumns, int gridRows, String[][] colors){
		Pane grid = new Pane();

		//don't think this if statement works
//		if (root.getChildren().contains(grid)){
//			root.getChildren().remove(grid);
//		}
		int cellX = (width/gridColumns);
//        for (int i=0; i<gridColumns; i++){
//        	grid.getColumnConstraints().add(new ColumnConstraints(cellX));
//        } 
//        
        int cellY = height/gridRows;
//        for (int j=0; j<gridRows; j++){
//        	grid.getRowConstraints().add(new RowConstraints(cellY));
//        }
        
        cells = new Cell[gridColumns][gridRows];
        for (int row = 0; row < gridColumns; row++) {       	
        	for (int col = 0; col < gridRows; col++) {        		
        		String color = colors[row][col];
        		
        		
        		Cell myCell = returnCell(row, col, cellX, cellY, color, "Rectangle", "WatorWorld");
        		cells[row][col] = myCell;
        		
        		grid.getChildren().add(myCell.getMyNode());
        	}
        }

//        System.out.println("here");
        return grid;
	}
	public Cell returnCell(int row,int col,int cellX,int cellY,String color,String shape, String simname ){
		Cell[] WatorCells = {new Predator(row, col, cellX, cellY, color, shape, 0),
				new Prey(row, col, cellX, cellY, color, shape,0),
				new EmptyWator(row, col, cellX, cellY, color, shape)};
		Cell[] LifeCells = {new LifePerson(row, col, cellX, cellY, color, shape),
				new EmptyLife(row, col, cellX, cellY, color, shape)};
		Cell[] SegCells = {new PopOne(row, col, cellX, cellY, color, shape),
				new PopTwo(row, col, cellX, cellY, color, shape),
				new EmptyPop(row, col, cellX, cellY, color, shape)};
		Cell[] FireCells = {new Burning(row, col, cellX, cellY, color, shape),
				new Tree(row, col, cellX, cellY, color, shape),
				new EmptyFire(row, col, cellX, cellY, color, shape)};
		Cell[][] AllCells = {WatorCells, LifeCells, SegCells, FireCells};
		String[] SimNames = {"WatorWorld", "Life", "Segregation", "Fire"};
		String[][] allColors = { {"YELLOW", "GREEN", "BLUE"},
				{"BLACK", "WHITE"}, {"RED", "BLUE", "WHITE"}, {"RED", "GREEN", "YELLOW"}};
		
		int Simindex = 0;
		for(int i = 0; i<SimNames.length; i++){
			
			if(simname.equals(SimNames[i]))
				Simindex = i;
		}
		String[] SimColors = allColors[Simindex];
		int Colorindex = 0;
		for(int j = 0; j<SimColors.length;j++){
			if(color.equals(SimColors[j])){
				Colorindex = j;
			}
		}
		
		return AllCells[Simindex][Colorindex];
	}
}
