import java.io.File;
import java.io.IOException;

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
	
	private String simName;
	private String simAuthor;
	private int gridColumns; 
	private int gridRows;
	private int cellSize = 1;
	
//	private FillGrid[] myGrids = {
//			new SegregationFillGrid()
//	};
//	private FillGrid myFillGrid;
	
	public void main(String argv[]) throws SAXException, IOException, ParserConfigurationException {
		File xmlFile = new File("XML FILE HERE"); 
		DocumentBuilderFactory dBFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dBFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		Dom dom = new Dom();
		simName = dom.getTitle();
		simAuthor = dom.getAuthor();
		gridColumns = dom.getDimensionX();
		gridRows = dom.getDimensionY();
		
		//To figure out, how to call index of grid based on simName
//		myFillGrid = myGrids[simName];
		
	}
	
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
