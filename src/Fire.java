import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fire {
	Scene myScene;
	private Group root;
	double probCatch = .2;
	
	public void setScene(Scene ss){
		myScene = ss;
	}
	
	public void setRoot(Group r){
		root = r;
	}

	public String[][] segStep(Stage s, Cell[][] cells) {

		String[][] newColors = new String[Grid.gridColumns][Grid.gridRows];
		for (int col = 0; col < Grid.gridColumns; col++) {
			for (int row = 0; row < Grid.gridRows; row++) {
				Cell curr = cells[col][row];
				if (curr.getMyColor().equals("RED")) {
					ArrayList<Cell> nb = new ArrayList<Cell>(nbList(curr, cells));
					for (Cell cell : nb) {
						if (catchFire(curr, cells)) {
							int x = cell.getMyLocation()[0];
							int y = cell.getMyLocation()[1];
							if (!cells[x][y].getMyColor().equals("YELLOW"))
							cells[x][y].setMyColor(("RED"));
						}
						else{
							continue;
						}
					}
				}
			}
		}

		for(int i=0; i < cells.length; i++) {
			for(int j=0; j< cells[i].length; j++) {
				newColors[i][j] = cells[i][j].getMyColor();
			}
		}
		return newColors;
	}

	public ArrayList<Cell> checkNeighbors(Cell curr, Cell[][] allCells){

		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		int currX = curr.getMyLocation()[0];
		int currY = curr.getMyLocation()[1];

		if (currX > 0) {
			neighbors.add(allCells[currX-1][currY]);
		}
		if (currY > 0) {
			neighbors.add(allCells[currX][currY-1]);
		}
		if (currY < Grid.gridRows-1) {
			neighbors.add(allCells[currX][currY+1]);
		}
		if (currX < Grid.gridColumns-1) {
			neighbors.add(allCells[currX+1][currY]);
		}
		return neighbors;
	}

	public ArrayList<Cell> nbList(Cell current, Cell[][] cells) {
		ArrayList<Cell> myNeighbors = new ArrayList<Cell>(checkNeighbors(current, cells));
		return myNeighbors;
	}

	public boolean catchFire (Cell current, Cell[][] cells) {
		Random rand = new Random();
		double randomValue = rand.nextDouble();
		System.out.println(randomValue);
		if (randomValue < probCatch) return true;
		return false;
	}
}