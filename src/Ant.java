
public class Ant {
	private String myState;
	private String myPher;
	private boolean myDest;
	public Ant(String state, String pher, boolean Dest){
		myState = state;
		myPher = pher;
		myDest = Dest;
	}
	public String getMyState(){
		return myState;
	}
	public void setMyState(String newstate){
		myState = newstate;
	}
	public String getMyPher(){
		return myPher;
	}
	public void setMyPher(String pher){
		myPher = pher;
	}
	public boolean getMyDest(){
		return myDest;
	}
	public void setMyDest(){
		myDest = !myDest;
	}
}
