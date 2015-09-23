import java.util.ArrayList;
import java.util.Random;


public class FillGrid {
	public String[][] fillGrid(int gridRows, int gridColumns, ArrayList<String> colors, String XML){
		String[][] tempColors = new String[gridRows][gridColumns];
	    for (int row = 0; row < gridColumns; row++) {       	
	    	for (int col = 0; col < gridRows; col++) { 
	    		if (XML.equals("Segregation")){
	    			Random ran = new Random();
		    		int i = ran.nextInt(3);
		    		String color = colors.get(i);
		    		tempColors[row][col] = color;
	    		}
	    		else if (XML.equals("Fire")){
	    			if ((col == 0) || (row == 0) || (col == gridColumns-1) || (row == gridRows-1)) {
	    				tempColors[col][row] = "YELLOW";
	    			}
	    			else if ((col == gridRows/2) && (row == gridColumns/2)) {
	    				tempColors[col][row] = "RED";
	    			}
	    			else{
	    				tempColors[col][row] = "GREEN";
	    			}
	    			
	    		}
	    		else if (XML.equals("Life")){
	    			if (XML.equals("Life")){
//	    				tempColors[gridRows/2][gridColumns/2] = "BLACK";
//	    				tempColors[gridRows/2+1][gridColumns/2+1] = "BLACK";
//	    				tempColors[gridRows/2-1][gridColumns/2-1] = "BLACK";
//	    				if (row != gridRows/2 && row != gridRows/2-1 && row != gridRows/2+1){
//	    					if (col != gridColumns/2 & col != gridColumns/2-1 & col != gridColumns/2+1){
//		    					tempColors[row][col] = "WHITE";
//		    				}
//	    				}
//	    				
	    				Random ran = new Random();
			    		int i = ran.nextInt(10);
			    		if (i%5 == 0){
			    			tempColors[row][col] = colors.get(0);
			    		}
			    		else{
			    		tempColors[row][col] = colors.get(2);
			    		}
	    			}
	    		}

	    	}
	    }
		return tempColors;
	}

}
