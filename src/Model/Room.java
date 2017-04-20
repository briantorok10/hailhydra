package Model;
import java.util.ArrayList;
public class Room {

	private int roomID;
	private String roomName;
	private String roomDescription;
	private boolean hasBeenEntered;
	//private ArrayList<Item> itemList;
	private ArrayList<Monsters> possibleMonsters;
	private Puzzle puzzle;
	private ArrayList<Room> roomExits;
	
	public Room(int roomID, String roomName, String roomDescription, Puzzle puzzle, ArrayList<Monsters> possibleMonsters,
			ArrayList<Room> roomExits) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomDescription = roomDescription;
		this.puzzle = puzzle;
		this.hasBeenEntered = false; //should be false upon game start
		this.possibleMonsters = possibleMonsters;
		this.roomExits = roomExits;
	}
	
	public ArrayList<Room> selectRoomOptions() {
		return this.roomExits;
	}
	
	public String selectRoom() {
		return this.selectRoomOptions().toString(); //Must be changed for clear user format
	}
	
	public void enterRoom() { //more to be added
		this.hasBeenEntered = true;
	}
	
	public void exitRoom() {
		//see system document for details
	}

	public int getRoomID()
	{
		return roomID;
	}

	public Puzzle getPuzzle()
	{
		return puzzle;
	}

	public void setPuzzle(Puzzle puzzle)
	{
		this.puzzle = puzzle;
	}
	
	
	

	
	
}
