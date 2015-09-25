<<<<<<< HEAD
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
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
	private FillGrid fg = new FillGrid();
	private ArrayList<String> colors;
	public ArrayList<String> getColors() {
		return colors;
	}

	public static Cell[][] cells;
	//public BorderPane bp;
	public Scene initGrid (Group gp, BorderPane bp, Stage s, String language, int width, int height) throws SAXException, IOException, ParserConfigurationException {
		
		handleDom("src/Wator.xml");
		
	//	Segregation seg = new Segregation();
		
		
		Scene window = new Scene(gp, width, height, Color.WHITE);
		Buttons myButtons = new Buttons();
        bp = new BorderPane();
        
//        bp.setTop(myButtons.initButtons(s, language, width, height));
        
        

        String[][] colorList = fg.fillGrid(gridRows, gridColumns, colors, "Wator");
=======
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
 
/**
 * A node that draws a triangle grid of dots using canvas
 */
public class Grid extends Pane {
	private Pane pane = new Pane();
    private final int width = Main.windowSizeX;
    private final int height = Main.windowSizeY;
    
	private Cell[][] cells;

    
    public Pane makeGrid(String[][] colors) {   
    	
    	int cellX = 7*(width)/10/Dom.dimensionX;
        int cellY = 7*(height)/10/Dom.dimensionY;
>>>>>>> bb623b71f8a4f6cda123fe43a0a8db4005840247
        
        
        cells = new Cell[Dom.dimensionX][Dom.dimensionY];
        for (int x = 0; x < Dom.dimensionX; x ++) {
        	for (int y = 0; y < Dom.dimensionY; y ++) {  
        		String color = colors[x][y];
        		Cell cell = returnCell(x, y, cellX, cellY, color, Dom.shapes.get(0), Dom.name);
        		cells[x][y] = cell;
        		pane.getChildren().add(cell.myNode);
        	}
        }

        return pane;
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
    
    public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	public Pane initGrid(String xml) {
		Dom myDom = new Dom();
		try {
			myDom.handleDom(xml);
		} catch (SAXException | IOException | ParserConfigurationException | DOMException e) {
			e.printStackTrace();
		}
		ColorMatrix fg = new ColorMatrix();
		String name = Dom.name.trim();
		String[][] colors = fg.createColorMatrix(name);
		Pane pane = makeGrid(colors);
		return pane;
	}

}