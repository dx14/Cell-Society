import java.util.ArrayList;

public class Segregation extends Simulation {

	double minRate = .3;
	
	public Segregation() {
		super();
	}

	@Override
	public void update(Cell current) {
	}

	public ArrayList<Cell> nbList(Cell current) {
		Neighbors nb = new Neighbors();
		ArrayList<Cell> myNeighbors = new ArrayList<Cell>(nb.checkNeighbors(current));
		return myNeighbors;
	}
	
	public int totalNeighbors(Cell current) {
		int total;
		ArrayList<Cell> nb = new ArrayList<Cell>(nbList(current));
		total = nb.size();
		return total;
	}
	
	public double satisfactionRate (Cell current) {
		ArrayList<Cell> nbList = new ArrayList<Cell> (nbList(current));
		int nbTotal = totalNeighbors(current);
		int nbSame = 0;
		for (int i = 0; i < nbList.size(); i++) {
			if (current.getMyColor().equals(nbList.get(i).getMyColor())) {
				nbSame++;
			}
		}
		return nbSame/nbTotal;
	}
	
	public boolean needsToMove (Cell current) {
		double rate = satisfactionRate(current);
		if (rate >= minRate) {
			return false;
		}
		return true;
	}
	
	public void moveCell (Cell current, Cell[][] allCells) {
		for (int row = 0; row < allCells.length; row++) {
			for (int col = 0; col < allCells[row].length; col++) {
				Cell newCell = allCells[row][col];
				if (newCell.getMyColor().equals("WHITE")) {
					newCell.setMyColor(current.getMyColor());
					break;
				}
			}
		}
		current.setMyColor("WHITE");
	}
}
