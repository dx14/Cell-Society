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

	public void setColors(ArrayList<String> colors) {
		this.colors = colors;
	}

	private String simName;
	private String simAuthor;
	private String shapeCell;
	private String empty;
	private int gridColumns; 
	private int gridRows;
	private Scene s;
	private String[] SimTypes = {"WatorWorld", "Fire", "Segregation"};
	private String[] CellPairs = {"Predator Prey", "Burning Tree", "1 2"};
	private ArrayList<String> colors;
	private Cell[][] cells;
	private ArrayList<Cell[]> SimCellPairs;
	
 	

	public Grid(Group group, double width, double height, Paint fill) throws SAXException, IOException, ParserConfigurationException {
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
        		Random ran = new Random();
        		int i = ran.nextInt(3);
        		String color = colors.get(i);
        		
        		Cell myCell = determineCell(simnum, cellX, cellY, row, col, i, color);
        		myCell.setCellType(celltypes[i]);
        		cells[row][col] = myCell;
        		grid.add((Shape) myCell.getMyNode(), col, row);
        	}
        }
        group.getChildren().add(grid);
       
    }


	private Cell determineCell(int simnum, int cellX, int cellY, int row, int col, int i, String color) {
		Cell[] watcelltypes = {
				new Predator(row, col, cellX, cellY, color),
				new Prey(row, col, cellX, cellY, color),
				new Empty(row, col, cellX, cellY, color)
				};
		SimCellPairs.add(watcelltypes);
		Cell[] firecelltypes = {
				new Tree(row, col, cellX, cellY, color),
				new Burning(row, col, cellX, cellY, color),
				new Empty(row, col, cellX, cellY, color)
				};
		SimCellPairs.add(firecelltypes);
		Cell[] segcelltypes = {
				new PopOne(row, col, cellX, cellY, color),
				new PopTwo(row, col, cellX, cellY, color),
				new Empty(row, col, cellX, cellY, color)
				};
		SimCellPairs.add(segcelltypes);
		
		Cell myCell = SimCellPairs.get(simnum)[i];
		return myCell;
	}
    
	
	public void handleDom(String file) throws SAXException, IOException, ParserConfigurationException {
		
		File xmlFile = new File(file); 
		DocumentBuilderFactory dBFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dBFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		Dom myDom = new Dom();
		simAuthor = myDom.getAuthor(doc);
		simName = myDom.getTitle(doc);
		shapeCell = myDom.getShape(doc);
		gridColumns = myDom.getDimensionX(doc);
		gridRows = myDom.getDimensionY(doc);
		empty = myDom.getEmptyColor(doc);
		colors = new ArrayList<String>(myDom.getColorList(doc));
		
		//To figure out, how to call index of grid based on simName
//		myFillGrid = myGrids[simName];
		
	}
	

	public Cell[][] getCells() {
		return cells;
	}
	public Cell getCell(int x, int y){
		return cells[x][y];
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	public String getShapeCell() {
		return shapeCell;
	}

	public void setShapeCell(String shapeCell) {
		this.shapeCell = shapeCell;
	}

	public String getSimName() {
		return simName;
	}

	public void setSimName(String simName) {
		this.simName = simName;
	}

	public String getSimAuthor() {
		return simAuthor;
	}

	public void setSimAuthor(String simAuthor) {
		this.simAuthor = simAuthor;
	}

	public int getGridColumns() {
		return gridColumns;
	}

	public void setGridColumns(int gridColumns) {
		this.gridColumns = gridColumns;
	}

	public int getGridRows() {
		return gridRows;
	}

	public void setGridRows(int gridRows) {
		this.gridRows = gridRows;
	}

}
