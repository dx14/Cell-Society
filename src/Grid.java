import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class Grid {

	public void setColors(ArrayList<String> colors) {
		this.colors = colors;
	}

	private String simName;
	private String simAuthor;
	private String shapeCell;
	private int gridColumns; 
	private int gridRows;
	private int cellSize = 10;
	private ArrayList<String> colors;
	private String[][] currColors;
	
	public Scene initGrid (int width, int height) throws SAXException, IOException, ParserConfigurationException {
		
		handleDom("src/Segregation.xml");
		System.out.println(simName);
		System.out.println(simAuthor);
		System.out.println(gridColumns);
		System.out.println(gridRows);
		System.out.println(colors);
		
		Group group = new Group();
		Scene window = new Scene(group, width, height, Color.WHITE);
		
        Rectangle cell = new Rectangle();
        
        GridPane grid = new GridPane();
        
        int cellX = width/gridColumns;
        for (int i=0; i<gridColumns; i++){
        	grid.getColumnConstraints().add(new ColumnConstraints(cellX));
        } 
        
        int cellY = height/gridRows;
        for (int j=0; j<gridRows; j++){
        	grid.getRowConstraints().add(new RowConstraints(cellY));
        }
        
        if (shapeCell.equals("Rectangle")){
        	//to do something here that shows which method of making cells should be called
        	//but since we are assuming all cells are squares, will wait for sprint 2 to code
        }
        
        currColors = new String[gridColumns][gridRows];
        for (int row = 0; row < gridColumns; row++) {       	
        	for (int col = 0; col < gridRows; col++) {     		
        		cell = makeCell(cellX, cellY);
        		currColors[col][row] = cell.getFill().toString();
        		System.out.println(currColors[col][row]);
        		grid.add(cell, col, row);
        	}
        }
        group.getChildren().add(grid);
        return window;
    }
	

	public Rectangle makeCell (int x, int y) {
		Random ran = new Random();
		int i = ran.nextInt(3);
		String color = colors.get(i);
		Rectangle cell2 = new Rectangle (x, y, Paint.valueOf(color));
		return cell2;
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
		colors = new ArrayList<String>(myDom.getColorList(doc));
		
		//To figure out, how to call index of grid based on simName
//		myFillGrid = myGrids[simName];
		
	}
	
	public String[][] getCurrColors() {
		return currColors;
	}

	public void setCurrColors(String[][] currColors) {
		this.currColors = currColors;
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

	public int getCellSize() {
		return cellSize;
	}

	public void setCellSize(int cellSize) {
		this.cellSize = cellSize;
	}
}
