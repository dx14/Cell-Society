import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class HandleDom {
	private static String simName;
	private static String simAuthor;
	private static String shapeCell;
	private static String empty;
	public static int gridColumns; 
	public static int gridRows;
	private static ArrayList<String> colors;
	private static ArrayList<Integer> params;
	
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

	public String getShapeCell() {
		return shapeCell;
	}

	public void setShapeCell(String shapeCell) {
		this.shapeCell = shapeCell;
	}

	public String getEmpty() {
		return empty;
	}

	public void setEmpty(String empty) {
		this.empty = empty;
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

	public ArrayList<String> getColors() {
		return colors;
	}

	public void setColors(ArrayList<String> colors) {
		this.colors = colors;
	}

	public ArrayList<Integer> getParams() {
		return params;
	}

	public void setParams(ArrayList<Integer> params) {
		this.params = params;
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
		params = myDom.getParameters(doc);
		
		
		
		//To figure out, how to call index of grid based on simName
//		myFillGrid = myGrids[simName];
		
		
		
	}
	
	
}
