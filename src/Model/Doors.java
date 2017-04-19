package Model;

import java.util.ArrayList;

public class Doors
{
	ArrayList<String> doorList = new ArrayList<String>();
	
	public Doors(ArrayList doorList)
	{
		this.doorList = doorList;
	}

	public ArrayList<String> getDoorList()
	{
		return doorList;
	}

	public void setDoorList(ArrayList<String> doorList)
	{
		this.doorList = doorList;
	}
	
	String d01 = "Bathroom Hallway 1";
	String d02 = "Bathroom Hallway 2";
	String d03 = "Bathroom Hallway 3";
	String d04 = "Bathroom Hallway 4";
	
}
