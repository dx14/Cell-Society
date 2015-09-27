import java.util.ArrayList;
import java.util.Random;

public class AntSpot extends Cell{

	
	public AntSpot(int x, int y, int sizeX, int sizeY, String color, String shape) {
		super(x, y, sizeX, sizeY, color, shape);
		// TODO Auto-generated constructor stub
		 
	}

	@Override
	public boolean checkForMove(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		if(this.getMyValue() >0){
			while(this.getMyValue() != antList.size()){
				antList.add(new Ant("Hungry", "fPher", false));
			}
			return true;
		}
		else
			return false;
	}

	@Override
	public void moveCell(Cell[][] myGrid) {
		this.setMyColor("BLACK");
		int i = 0;
		while(i<antList.size()){
			
			ArrayList<Cell> moves = this.getSurroundingCells(myGrid);
			int j = 0;
			while(j< moves.size()){
				if(moves.get(j).getMyValue() >=10){
					moves.remove(j);
				}
				if(moves.size() >0){
					if(moves.get(j).getMyColor().equals("BROWN")){
						moves.remove(j);
					}
				}	
				j++;
			}
			if(moves.size()>0){
				Ant ant = antList.get(i);
				if(ant.getMyState().equals("Hungry")){
					Random ran = new Random();
		    		int val = ran.nextInt(moves.size());
					Cell go = moves.get(val);
					for(int k = 0; k<moves.size(); k++){
						if(go.getMyfPher() < moves.get(k).getMyfPher()){
							go = moves.get(k);
						}
						
					}
					if(go.getMyfPher() > 9000){
						ant.setMyState("Homesick");
					}
					this.setMyhPher(this.getMyhPher() + 1);
					this.setMyValue(this.getMyValue() - 1);
					antList.remove(i);
					go.setMyValue(go.getMyValue() + 1);
					go.antList.add(ant);
					
					
				}
				else if(ant.getMyState().equals("HomeSick")){
					Random ran = new Random();
		    		int val = ran.nextInt(moves.size());
					Cell go = moves.get(val);
					for(int k = 0; k<moves.size(); k++){
						if(go.getMyhPher() < moves.get(k).getMyhPher()){
							go = moves.get(k);
						}
					}
					this.setMyValue(this.getMyValue() -1);
					antList.remove(i);
					if(go.getMyhPher() <9000){
						this.setMyfPher(this.getMyfPher() + 1);
						go.setMyValue(go.getMyValue() + 1);
						go.antList.add(ant);
					}
					
				}
			}
			i++;
		}
		if(this.getMyValue() ==0){
			this.setMyColor("GREEN");
		}
		
	}

	@Override
	public boolean checkIfBlockedIn(Cell[][] myGrid) {
		ArrayList<Cell> nbs = this.getSurroundingCells(myGrid);
		for(int i = 0; i<nbs.size();i++){
			if(nbs.get(i).getMyValue()<10){
				return false;
			}
		}
		return true;
	}

	@Override
	public void changeCellType(Cell[][] myGrid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateIfBlocked(Cell[][] myGrid) {
		for(int i = 0; i<antList.size(); i++){
			if(antList.get(i).getMyState().equals("Hungry")){
				this.setMyhPher(this.getMyhPher()+1);
			}
			else if(antList.get(i).getMyState().equals("Homesick")){
				this.setMyfPher(this.getMyfPher()+1);
			}
		}
		
	}

}
