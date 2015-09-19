import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class Grid extends Scene{
	
	private Scene scene;
	private String[] SimTypes = {"WatorWorld", "Fire", "Segregation"};
	private String[] CellPairs = {"Predator Prey", "Burning Tree", "1 2"};
	private ArrayList<String> colors;
	private Cell[][] cells;
	private ArrayList<Cell[]> SimCellPairs;
	private ArrayList<Integer> params;
	private File xmlFile;
	

	//public Grid(Group group, double width, double height, Paint fill) throws SAXException, IOException, ParserConfigurationException {
		super(group, width, height, fill);
		//	s = window;
		simName = getSimName();
		int simnum = 0;
		String cellpair = " ";
		for(int i = 0; i <SimTypes.length; i++){
			if(simName.equals(SimTypes[i])){
				cellpair = CellPairs[i];
				simnum = i;
				break;
			}
			else
				cellpair = null;
		}
		cellpair.concat(" Empty");
		String[] celltypes  = cellpair.split(" ");


		handleDom("src/Segregation.xml");
		
		
		
		
        
        GridPane grid = new GridPane();
        
        int cellX = ((int) width)/gridColumns;
        for (int i=0; i<gridColumns; i++){
        	grid.getColumnConstraints().add(new ColumnConstraints(cellX));
        } 
        
        int cellY = ((int)height )/gridRows;
        for (int j=0; j<gridRows; j++){
        	grid.getRowConstraints().add(new RowConstraints(cellY));
        }
        
        
        cells = new Cell[gridColumns][gridRows];
        for (int row = 0; row < gridColumns; row++) {       	
        	for (int col = 0; col < gridRows; col++) {  
        		int i = chooseCellType();       		
        		Cell myCell = determineCell(simnum, row, col, i);
        		myCell.setCellType(celltypes[i]);
        		cells[row][col] = myCell;
        		grid.add((Shape) myCell.getMyNode(), col, row);
        	}
        }
        group.getChildren().add(grid);
       
    }
	
	private int chooseCellType(){
		int i = FillGrid.set(xmlFile.toString());
		return i;
	}

	private void createCellPairs(int cellX, int cellY){
		Cell[] watcelltypes = {
				new Predator(0, 0, cellX, cellY, colors.get(0)),
				new Prey(0, 0, cellX, cellY, colors.get(1)),
				new Empty(0, 0, cellX, cellY, colors.get(2))
				};
		SimCellPairs.add(watcelltypes);
		Cell[] firecelltypes = {
				new Tree(0, 0, cellX, cellY, colors.get(0)),
				new Burning(0, 0, cellX, cellY, colors.get(1)),
				new Empty(0, 0, cellX, cellY, colors.get(2))
				};
		SimCellPairs.add(firecelltypes);
		Cell[] segcelltypes = {
				new PopOne(0, 0, cellX, cellY, colors.get(0)),
				new PopTwo(0, 0, cellX, cellY, colors.get(1)),
				new Empty(0, 0, cellX, cellY, colors.get(2))
				};
		SimCellPairs.add(segcelltypes);
	}

	private Cell determineCell(int simnum, int row, int col, int i) {
		Cell myCell = SimCellPairs.get(simnum)[i];
		myCell.setMyLocation(new int[] {row,col});
		return myCell;
	}
    

}
