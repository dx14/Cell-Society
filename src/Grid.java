import java.awt.Component;
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


	private String simName;
	private String simAuthor;
	private String shapeCell;
	public static int gridColumns; 
	public static int gridRows;
	public static Group group;
	private String empty;
	private ArrayList<String> colors;
	public ArrayList<String> getColors() {
		return colors;
	}

	public static Cell[][] cells;
	//public BorderPane bp;
	public Scene initGrid (Group gp, BorderPane bp, Stage s, String language, int width, int height) throws SAXException, IOException, ParserConfigurationException {
		
		handleDom("src/Segregation.xml");
		
		Segregation seg = new Segregation();
		
		
		Scene window = new Scene(gp, width, height, Color.WHITE);
		Buttons myButtons = new Buttons();
        bp = new BorderPane();
        
        bp.setTop(myButtons.initButtons(s, language, width, height));
        
        
        FillGrid fGrid = new FillGrid();
        
        //change fill grid type here
        String[][] colorList = fGrid.fillGrid(gridRows, gridColumns, colors, "Segregation");
        
        GridPane grid = new GridPane();
        cells = new Cell[gridColumns][gridRows];
        GridLayout grid2 = new GridLayout();
        grid = grid2.gridMaker(width/2, height/2, gridRows, gridColumns, colorList);
        cells = grid2.cells;
        bp.setCenter(grid);
        
        gp.getChildren().add(bp);

        
        
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

	public int getGridRows() {
		return gridRows;
	}
	
	public void setColors(ArrayList<String> colors) {
		this.colors = colors;
	}
	
	public String getEmpty() {
		return empty;
	}


	public void setEmpty(String empty) {
		this.empty = empty;
	}


	public Group getGroup() {
		return group;
	}

	public Cell[][] getCells() {
		return cells;
	}
}