# Peer Code Review
## Dennis Xu (dx14), William Yang (wzy)

##Duplicated code:

### In Dom.java:
 public ArrayList<String> getColorList(Document document){ 
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
      
### In Dom. java:
   public String getEmptyColor(Document document){ 
      colors = new ArrayList<String>(); 
      NodeList nList = document.getElementsByTagName("color"); 
      for (int i=0; i<nList.getLength(); i++){ 
         Node nNode = nList.item(i); 
         if (nNode.hasAttributes()){ 
            empty = nNode.getTextContent(); 
         } 
      } 
      
### Refactored Code:
   public ArrayList<String> getColorList(Document document){ 
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
      
We chose these methods to refactor because they are essentially the same method, and thus we do not need duplicate methods. 
Instead, the getColorList will return an ArrayList that contains the Empty color inside of it, and we can access that color
directly through the colorList. We will delete the second duplicate method, getEmptyColor().

### In Dom.java:
   public int getDimensionY(Document document){ 
      String tempY = document.getElementsByTagName("dimensionY").item(0).getTextContent(); 
      dimensionY = Integer.parseInt(tempY); 
      return dimensionY; 
   } 
   
### In Dom.java:
    public int getDimensionX(Document document){ 
      String tempX = document.getElementsByTagName("dimensionX").item(0).getTextContent(); 
      dimensionX = Integer.parseInt(tempX); 
      return dimensionX; 
   } 
   
### Refactored Code:
  public void setDimensions(Document document) {
  dimensionX = Integer.parseInt(document.getElementsByTagName("dimensionX").item(0).getTextContent());
  dimensionY = Integer.parseInt(document.getElementsByTagName("dimensionY").item(0).getTextContent());
  }
  
  We chose this piece of code because it can be condensed into one method and is essentially the same method, using diff variables.
  These two codes are essentially getters for the dimensions of the grid. These are stored as static variables that can be called
  in any class, and are also final. Thus, we can just have a method that sets these variables, and we will not need
  to have a getter method for both dimensions.

      
      
