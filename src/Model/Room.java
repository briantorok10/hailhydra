package Model;
import java.util.ArrayList;


public class Room {

	private int roomID;
	private String roomName;
	private String roomDescription;
	private boolean hasBeenEntered;
	//private ArrayList<Item> itemList;
	private ArrayList<Monsters> possibleMonsters;
	private Puzzle roomPuzzle;
	private ArrayList<Room> roomExits;
	
	public Room(int roomID, String roomName, String roomDescription, ArrayList<Monsters> possibleMonsters,
			ArrayList<Room> roomExits) {
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomDescription = roomDescription;
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

	
	
}
