package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * 
 * @author Jose Moreno
 */
public class Rooms
{
	int ID;
	private String name, description;
	private HashMap<Integer, Rooms> exits;
	private HashMap<Integer, Item> itemList;
	private ArrayList<Monsters> monsters;
	private ArrayList<Item> items;

	public Rooms(int ID, String name, String description)
	{
		this.ID = ID;
		this.name = name;
		this.description = description;
		exits = new HashMap<Integer, Rooms>();
		items = new ArrayList<Item>();
	}

	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return name;
	}

	public void setExit(int direction, Rooms connecting)
	{
		exits.put(direction, connecting);
		
	}
	
	public String getDescription()
	{
		
		if(items.size() > 0)
		{
			description += "\nThe following items are in this room: \n";
			for(Item item : items)
			{
				description += "\t" + item.getName() + "\n";
			}
		}
		return description;
	}
	
	public String displayExits()
	{
		String returnString = "Exits: ";
		Set<Integer> keys = exits.keySet();
		int i = 1;
		for (int exit : keys)
		{
			returnString += "\n" + i + ". " + exit;
			i++;
		}
		return returnString;
	}
	
	public String displayDescription(int direction)
	{
		return exits.get(direction).getDescription();
	}
	
	public Rooms getNewRoom(Rooms rooms)
	{
		return exits.get(rooms);
	}
	
	public void addItem(Item i)
	{
		items.add(i);
	}
	
	public String getItem()
	{
		return items.toString();
	}
	
	public static void moveRooms()
	{
		//System.out.println(Game.currentRoom.getID());
		System.out.println(Game.currentRoom.displayExits());
		int move = Game.input.nextInt();
		System.out.println(Game.currentRoom.displayDescription(move));
		Game.currentRoom = Game.currentRoom.getNewRoom(Game.currentRoom.exits.get(move));
		//System.out.println(Game.currentRoom.getID());
		Menu.MainMenu();
	}
}
