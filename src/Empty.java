import java.util.ArrayList;

public class Empty extends Cell{

	public Empty(int x, int y, int sizeX, int sizeY, String value) {
		super(x, y, sizeX, sizeY, value);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean checkSurroundings(ArrayList<Integer> parameters, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
