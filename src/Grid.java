import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

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
    
	private int OFFSET = 0;
	private Cell[][] cells;

    
    public Pane makeGrid(String[][] colors) {   
    	
    	int cellX = width/Dom.dimensionX;
        int cellY = height/Dom.dimensionY;
        pane.setLayoutX(snappedLeftInset());
        pane.setLayoutY(snappedTopInset());
        
        cells = new Cell[Dom.dimensionX][Dom.dimensionY];
        for (int x = 0; x < width; x += OFFSET) {
        	for (int y = 0; y < height; y ++) {  
        		String color = colors[x][y];
        		Cell cell = new TriangleCell(x, y, cellX, cellY, color);
        		cells[x][y] = cell;
        		pane.getChildren().add(cell.myNode);
        	}
        }
        return pane;
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
			System.out.println("herp");
			e.printStackTrace();
		}
		FillGrid fg = new FillGrid();
		String[][] colors = fg.fillGrid(xml);
		Pane pane = makeGrid(colors);
		return pane;
	}

}