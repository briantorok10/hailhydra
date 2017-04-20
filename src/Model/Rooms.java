package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Rooms
{
	private String ID, name, description;
	private HashMap<String, Rooms> exits;
	private HashMap<String, Item> itemList;
	private ArrayList<Monsters> monsters;
	private ArrayList<Item> items;

	public Rooms(String ID, String name, String description)
	{
		this.ID = ID;
		this.name = name;
		this.description = description;
		exits = new HashMap<String, Rooms>();
		items = new ArrayList<Item>();
	}

	public void setExit(String direction, Rooms connecting)
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
	
	private String getExits()
	{
		String returnString = "Exits: ";
		Set<String> keys = exits.keySet();
		for (String exit : keys)
		{
			returnString += " " + exit;
		}
		return returnString;
	}
	
	public Room getExit(String direction)
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
}
