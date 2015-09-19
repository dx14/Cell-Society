import java.util.ArrayList;

import javafx.scene.shape.Shape;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Dom {
	
	
	
	public ArrayList<String> getColorList(Document document){
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
	
	public String getEmptyColor(Document document){
		String empty = document.getElementsByTagName("color").item(0).getAttributes().getNamedItem("empty").getNodeValue();
		return empty;
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
	
	public ArrayList<Integer> getParameters(Document document){
		ArrayList<Integer> params = new ArrayList<Integer>();
		NodeList nList = document.getElementsByTagName("parameters");
		for (int i=0; i<nList.getLength(); i++){
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE){
				Element eNode = (Element) nNode;
				int par = Integer.parseInt(eNode.getTextContent());
				params.add(par);
			}
		}
		return params;
	}

	
//read in XML file
	
}
