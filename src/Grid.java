import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class Grid {

	public static int gridColumns; 
	public static int gridRows;
	private String simName;
	private String simAuthor;
	private String shapeCell;
	private BorderPane bp;
	private ArrayList<String> colors;
	private Cell[][] cells;
 	
	public Scene initGrid (Stage s, String language, int width, int height) throws SAXException, IOException, ParserConfigurationException {
		
		Segregation seg = new Segregation();
		
		Buttons myButtons = new Buttons();
        GridPane grid = new GridPane();
		handleDom("src/Segregation.xml");
		
		bp = new BorderPane();
		Scene window = new Scene(bp, width, height, Color.WHITE);

        int cellX = width/80;
        for (int i=0; i<gridColumns; i++){
        	grid.getColumnConstraints().add(new ColumnConstraints(cellX));
        } 
        
        int cellY = height/80;
        for (int j=0; j<gridRows; j++){
        	grid.getRowConstraints().add(new RowConstraints(cellY));
        }
        
        cells = new Cell[gridColumns][gridRows];
        for (int col = 0; col < gridColumns; col++) {       	
        	for (int row = 0; row < gridRows; row++) {  
        		Random ran = new Random();
        		int i = ran.nextInt(3);
        		String color = colors.get(i);
        		Cell myCell = new Cell(row, col, cellX, cellY, color);
        		cells[row][col] = myCell;
        		grid.add((Shape) myCell.getMyNode(), col, row);
        	}
        }
        
        grid.setAlignment(Pos.CENTER);
        bp.setCenter(grid);
        bp.setTop(myButtons.initButtons(s, language, width, height));
        
   //     seg.startUpdateLoop(s, cells);
        
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

}