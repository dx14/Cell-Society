
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javafx.scene.shape.Shape;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Dom {
	public static String title;
	public static String author;
	public static String simulation;
	public static String empty;
	public static int dimensionX; 
	public static int dimensionY;
	public static List<String> colors;
	public static List<String> params;
	public static List<String> shapes;
	public static String name;
	
	
	
	public String getName(Document document){
		name = document.getElementsByTagName("name").item(0).getTextContent();
		return name;
	}
	
	public String getEmptyColor(Document document){
		colors = new ArrayList<String>();
		NodeList nList = document.getElementsByTagName("color");
		for (int i=0; i<nList.getLength(); i++){
			Node nNode = nList.item(i);
			if (nNode.hasAttributes()){
				empty = nNode.getTextContent();
			}
		}
		
		return empty;
	}
	
	public String getTitle(Document document){
		title = document.getElementsByTagName("name").item(0).getAttributes().getNamedItem("title").getNodeValue();
		return title;
	}
	
	public String getAuthor(Document document){
		author = document.getElementsByTagName("name").item(0).getAttributes().getNamedItem("author").getNodeValue();
		return author;
	}
	
	public int getDimensionX(Document document){
		String tempX = document.getElementsByTagName("dimensionX").item(0).getTextContent();
		dimensionX = Integer.parseInt(tempX);
		return dimensionX;
	}
	
	public int getDimensionY(Document document){
		String tempY = document.getElementsByTagName("dimensionY").item(0).getTextContent();
		dimensionY = Integer.parseInt(tempY);
		return dimensionY;
	}
	
	public List<String> getColorList(Document document){
		colors = new ArrayList<String>();
		NodeList nList = document.getElementsByTagName("color");
		for (int i=0; i<nList.getLength(); i++){
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE){
				Element eNode = (Element) nNode;
				colors.add(eNode.getTextContent());
			}
			if (nNode.hasAttributes()){
				empty = nNode.getTextContent();
			}
		}
		return colors;
	}
	
	public List<String> getShape(Document document){
		shapes = new ArrayList<String>();
		NodeList nList = document.getElementsByTagName("shape");
		for (int i=0; i<nList.getLength(); i++){
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE){
				Element eNode = (Element) nNode;
				shapes.add(eNode.getTextContent());
			}
		}
		return shapes;
	}
	
	public List<String> getParameters(Document document){
		params = new ArrayList<String>();
		NodeList nList = document.getElementsByTagName("parameters");
		for (int i=0; i<nList.getLength(); i++){
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE){
				Element eNode = (Element) nNode;
				params.add(eNode.getTextContent());
			}
		}
		return params;
	}
	
	public void handleDom(String file) throws SAXException, IOException, ParserConfigurationException {
		
		File xmlFile = new File(file); 
		DocumentBuilderFactory dBFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dBFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		getEmptyColor(doc);
		getColorList(doc);
		getTitle(doc);
		getAuthor(doc);
		getDimensionX(doc);
		getDimensionY(doc);
		getShape(doc);
		getParameters(doc);
		getName(doc);
		
		

		//To figure out, how to call index of grid based on simName
//		myFillGrid = myGrids[simName];
		
	}

	
//read in XML file
	
}
