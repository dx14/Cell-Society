import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Dom {
	
	private String title;
	private String author;
	private int dimensionX;
	private int dimensionY;
	private ArrayList<String> colorList;
	
	public void handleVariables(Document document){
		//sets up title and author strings to be called
		title = document.getElementsByTagName("name").item(0).getAttributes().getNamedItem("title").toString();
		author = document.getElementsByTagName("name").item(0).getAttributes().getNamedItem("author").toString();
		
		String tempX = document.getElementsByTagName("dimensionX").item(0).getTextContent();
		String tempY = document.getElementsByTagName("dimensionY").item(0).getTextContent();
		dimensionX = Integer.parseInt(tempX);
		dimensionY = Integer.parseInt(tempY);
		
		colorList = handleColor(document);
	}
	
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

	
//read in XML file
	
}
