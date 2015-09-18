import java.util.ArrayList;

import javafx.scene.shape.Shape;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Dom {
	
	
	
	public ArrayList<String> handleColor(Document document){
		ArrayList<String> colors = new ArrayList<String>();
		NodeList nList = document.getElementsByTagName("color");
		for (int i=0; i<nList.getLength(); i++){
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE){
				Element eNode = (Element) nNode;
				colors.add(eNode.getTextContent());
			}
		}
		return colors;
	}
	
	public String getTitle(Document document){
		String title = document.getElementsByTagName("name").item(0).getAttributes().getNamedItem("title").getNodeValue();
		return title;
	}
	
	public String getAuthor(Document document){
		String author = document.getElementsByTagName("name").item(0).getAttributes().getNamedItem("author").getNodeValue();
		return author;
	}
	
	public int getDimensionX(Document document){
		String tempX = document.getElementsByTagName("dimensionX").item(0).getTextContent();
		int dimensionX = Integer.parseInt(tempX);
		return dimensionX;
	}
	
	public int getDimensionY(Document document){
		String tempY = document.getElementsByTagName("dimensionY").item(0).getTextContent();
		int dimensionY = Integer.parseInt(tempY);
		return dimensionY;
	}
	
	public String getShape(Document document){
		String cellShape = document.getElementsByTagName("cell").item(0).getChildNodes().item(0).getTextContent();
		return cellShape;
	}
	
	public ArrayList<String> getColorList(Document document){
		ArrayList<String> colorList = new ArrayList<String>();
		colorList = handleColor(document);
		return colorList;
	}

	
//read in XML file
	
}
