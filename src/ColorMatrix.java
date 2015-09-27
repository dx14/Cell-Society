import java.util.ArrayList;
import java.util.Random;


public class ColorMatrix {
	//color matrix factory
	public String[][] createColorMatrix(String XML){
		String[][] tempColors = new String[Dom.dimensionX][Dom.dimensionY];
		if (XML.equals("Segregation")){
			tempColors = randomColorMatrix();
		}
		else if (XML.equals("Wator")){
			tempColors = randomColorMatrix();
		}
		else if (XML.equals("Fire")){
			tempColors = fireColorMatrix();
		}
		else if (XML.equals("Life")){
			tempColors = lifeColorMatrix();
		}
		return tempColors;
	}
	
	public String[][] randomColorMatrix(){
		String[][] rColors = new String[Dom.dimensionX][Dom.dimensionY];
		for (int row = 0; row < Dom.dimensionX; row++) {       	
	    	for (int col = 0; col < Dom.dimensionY; col++) {
	    			Random ran = new Random();
		    		int i = ran.nextInt(3);
		    		String color = Dom.colors.get(i);
		    		rColors[row][col] = color;
	    		}
		}
		return rColors;
	}
	
	public String[][] fireColorMatrix(){
		String[][] fColors = new String[Dom.dimensionX][Dom.dimensionY];
		for (int row = 0; row < Dom.dimensionX; row++) {       	
	    	for (int col = 0; col < Dom.dimensionY; col++) {
	    		if ((col == 0) || (row == 0) || (col == Dom.dimensionX-1) || (row == Dom.dimensionY-1)) {
    				fColors[col][row] = Dom.empty;
    			}
    			else if ((col == Dom.dimensionX/2) && (row == Dom.dimensionY/2)) {
    				fColors[col][row] = Dom.colors.get(0);
    			}
    			else{
    				fColors[col][row] = Dom.colors.get(1);
    			}
	    		}
		}
		return fColors;
	}
	
	public String[][] lifeColorMatrix(){
		String[][] fColors = new String[Dom.dimensionX][Dom.dimensionY];
		for (int row = 0; row < Dom.dimensionX; row++){
			for (int col = 0; col < Dom.dimensionY; col++){
//				if (row == Dom.dimensionX/2 && col == Dom.dimensionY/2
//						|| row == Dom.dimensionX/2 && col == Dom.dimensionY/2+1
//						|| row == Dom.dimensionX/2 && col == Dom.dimensionY/2-1){
//					fColors[row][col] = Dom.colors.get(0);
//				}
//				else{
//					fColors[row][col] = Dom.empty;
//				}
				Random ran = new Random();
	    		int i = ran.nextInt(3);
	    		String color = Dom.colors.get(i);
	    		fColors[row][col] = color;
			}
		}
		return fColors;
	}

}

