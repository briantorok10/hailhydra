package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import View.Game;

public class Rooms
{
	private String ID, name, description;
	private HashMap<Integer, Rooms> exits;
	private HashMap<Integer, Item> itemList;
	private ArrayList<Monsters> monsters;
	private ArrayList<Item> items;

	public Rooms(String ID, String name, String description)
	{
		this.ID = ID;
		this.name = name;
		this.description = description;
		exits = new HashMap<Integer, Rooms>();
		items = new ArrayList<Item>();
	}

	public String getID()
	{
		return ID;
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
	
	public String getExits()
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
	
	public String getExit(int direction)
	{
		return exits.get(direction).getDescription();
	}
	
	public Rooms getNewRoom(String direction)
	{
		return exits.get(direction);
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
		System.out.println(Game.currentRoom.getExits());
		int move = Game.input.nextInt();
		System.out.println(Game.currentRoom.getExit(move));
		Game.currentRoom = Game.currentRoom.getNewRoom(Game.currentRoom.getID());
		System.out.println(Game.currentRoom.getID());
		Menu.MainMenu();
	}
}
