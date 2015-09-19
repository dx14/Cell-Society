import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


public class GridLayout {
	private Scene scene;
	private Cell[][] grid;
	private Cell myCell;
	private Dom myDom = new Dom();
	
	public Grid(int width, int height){
		Group root = new Group();
		scene = new Scene(root, width, height);
		grid = new Cell[width][height];
		
		GridPane grid = new GridPane();
		
        int cellX = ((int) width)/myDom;
        for (int i=0; i<gridColumns; i++){
        	grid.getColumnConstraints().add(new ColumnConstraints(cellX));
        } 
        
        int cellY = ((int)height )/gridRows;
        for (int j=0; j<gridRows; j++){
        	grid.getRowConstraints().add(new RowConstraints(cellY));
        }
		
		for (int row=0; row<width; row++){
			for (int col=0; col<height; col++){
				//call fillgrid here? //choose type of cell
				grid[row][col] = ;
				root.getChildren().add(grid[row][col]);
				
			}
		}
	}

	public static void main(String[] args) {
		new Grid()
	}

}


class ButtonGrid {
	 
    JFrame frame=new JFrame(); //creates frame
    JButton[][] grid; //names the grid of buttons

    public ButtonGrid(int width, int length){ //constructor
            frame.setLayout(new GridLayout(width,length)); //set layout
            grid=new JButton[width][length]; //allocate the size of grid
            for(int y=0; y<length; y++){
                    for(int x=0; x<width; x++){
                            grid[x][y]=new JButton("("+x+","+y+")"); //creates new button     
                            frame.add(grid[x][y]); //adds button to grid
                    }
            }
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack(); //sets appropriate size for frame
            frame.setVisible(true); //makes frame visible
    }
    public static void main(String[] args) {
            new ButtonGrid(3,3);//makes new ButtonGrid with 2 parameters
    }