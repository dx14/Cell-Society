import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

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
	public static int gridColumns; 
	public static int gridRows;
	public static Group group;
	private String empty;
	
	private int FRAMES_PER_SECOND = 2;
	private int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	private double SECOND_DELAY = 0.1 / FRAMES_PER_SECOND;
	private Timeline animation;
	
	public String getEmpty() {
		return empty;
	}


	public void setEmpty(String empty) {
		this.empty = empty;
	}


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}


	public Cell[][] getCells() {
		return cells;
	}


	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	private ArrayList<String> colors;
	public ArrayList<String> getColors() {
		return colors;
	}

	public static Cell[][] cells;
	public BorderPane bp;
	public Scene initGrid (Simulation sim, Group group, Stage s, String language, int width, int height) throws SAXException, IOException, ParserConfigurationException {
		
		handleDom("src/Segregation.xml");
		
		
		Scene window = new Scene(group, width, height, Color.WHITE);
		Buttons myButtons = new Buttons();
        bp = new BorderPane();
        
        bp.setTop(myButtons.initButtons(s, language, width, height));
        
        String[][] colorList = new String[gridRows][gridColumns];
        for (int row = 0; row < gridColumns; row++) {       	
        	for (int col = 0; col < gridRows; col++) {     
        		Random ran = new Random();
        		int i = ran.nextInt(3);
        		String color = colors.get(i);
        		colorList[row][col] = color;
        	}
        }
        GridPane grid = new GridPane();
        cells = new Cell[gridColumns][gridRows];
        GridLayout grid2 = new GridLayout();
        grid = grid2.gridMaker(width, height, gridRows, gridColumns, colorList);
        cells = grid2.cells;
        
        bp.setBottom(grid);
        
        group.getChildren().add(bp);
        
        return window;
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
		empty = myDom.getEmptyColor(doc);
		
		//To figure out, how to call index of grid based on simName
//		myFillGrid = myGrids[simName];
		
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