import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
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
	private int gridColumns; 
	private int gridRows;
	private int cellSize = 5;
	private ArrayList<String> colors;
	
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
        for (int row = 0; row < gridColumns; row++) {
        	for (int col = 0; col < gridRows; col++) {
        		if ((row+col) % 2 == 0) cell = makeCell(cellSize, "RED");
        		else cell = makeCell(cellSize, "BLUE");
        		grid.add(cell, col, row);
        	}
        }
        group.getChildren().add(grid);
        return window;
    }
	
	public Rectangle makeCell (int size, String color) {
		Rectangle cell = new Rectangle (cellSize, cellSize, Paint.valueOf(color));
		return cell;
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
		gridColumns = myDom.getDimensionX(doc);
		gridRows = myDom.getDimensionY(doc);
		colors = new ArrayList<String>(myDom.getColorList(doc));
		
		//To figure out, how to call index of grid based on simName
//		myFillGrid = myGrids[simName];
		
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
