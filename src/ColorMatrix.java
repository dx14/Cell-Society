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
		else if (XML.equals("ForagingAnts")){
			tempColors = antsColorMatrix();
		}
		else if (XML.equals("SlimeMolds")){
			tempColors = percentageColorMatrix();
		}
		return tempColors;
	}
	
	public String[][] percentageColorMatrix(){
		String[][] pColors = new String[Dom.dimensionX][Dom.dimensionY];
		int total = Dom.dimensionX*Dom.dimensionY;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (String s: Dom.params){
			int i = Integer.parseInt(s);
			nums.add(total*i);
		}
		for (int row = 0; row < Dom.dimensionX; row++) {       	
	    	for (int col = 0; col < Dom.dimensionY; col++) {
		    		int j = helpPercentage(nums);
		    		String color = Dom.colors.get(j);
		    		pColors[row][col] = color;
	    		}
		}
		return pColors;
	}
	
	public int helpPercentage(ArrayList<Integer> nums){
		Random ran = new Random();
		int i = ran.nextInt(Dom.colors.size());
		int curr = nums.get(i);
		while (curr == 0){
			i = ran.nextInt(Dom.colors.size());
			curr = nums.get(i);
		}
		return i;
	}
	
	public String[][] antsColorMatrix(){
		String[][] aColors = new String[Dom.dimensionX][Dom.dimensionY];
		Random ran = new Random();
		int i = ran.nextInt(Dom.dimensionX);
		int j = ran.nextInt(Dom.dimensionY);
		int k = ran.nextInt(Dom.dimensionX);
		int l = ran.nextInt(Dom.dimensionY);
		for (int row = 0; row < Dom.dimensionX; row++) {       	
	    	for (int col = 0; col < Dom.dimensionY; col++) {
	    		if (row == i && col == j){
	    			String color = Dom.empty;
	    			aColors[row][col] = color;
	    		}
	    		else if (row == k || col == j){
	    			String color = Dom.colors.get(0);
	    			aColors[row][col] = color;
	    		}
	    		else{
	    			String color = Dom.colors.get(1);
	    			aColors[row][col] = color;
	    		}
	    	}
	    }
		return aColors;
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

