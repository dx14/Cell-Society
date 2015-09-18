import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
	private double cellSize;
	private double cellRatio = .000015;
	private ArrayList<String> colors;
	
	public Scene initGrid (int width, int height) throws SAXException, IOException, ParserConfigurationException {
		
		handleDom("src/Segregation.xml");
		
		HBox group = new HBox();
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.BOTTOM_CENTER);
		Scene window = new Scene(group, width, height, Color.WHITE);
		
        Rectangle cell = new Rectangle();
        cellSize = (width*height)*cellRatio;
        
        GridPane grid = new GridPane();
        for (int row = 0; row < gridColumns; row++) {
        	for (int col = 0; col < gridRows; col++) {
        		Random ran = new Random();
        		int x = ran.nextInt(3);
        		cell = makeCell(cellSize, colors.get(x));
        		grid.add(cell, col, row);
        	}
        }
        
        vbox.getChildren().add(grid);
        group.getChildren().add(vbox);
        group.setAlignment(Pos.CENTER);
        return window;
    }