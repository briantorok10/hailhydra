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
	//private HashMap<Integer, Item> itemList;
	//private ArrayList<Monsters> monsters;
	//private ArrayList<Item> items;

	public Rooms(int ID, String name, String description)
	{
		this.ID = ID;
		this.name = name;
		this.description = description;
		exits = new HashMap<Integer, Rooms>();
		//items = new ArrayList<Item>();
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

		//		if(items.size() > 0)
		//		{
		//			description += "\nThe following items are in this room: \n";
		//			for(Item item : items)
		//			{
		//				description += "\t" + item.getName() + "\n";
		//			}
		//		}
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

	public int displayDescription(int direction)
	{
		//return exits.get(direction).getDescription();
		return exits.get(direction).getID();
	}

	public Rooms getNewRoom(Rooms rooms)
	{
		return exits.get(rooms);
	}

	//	public void addItem(Item i)
	//	{
	//		items.add(i);
	//	}
	//	
	//	public String getItem()
	//	{
	//		return items.toString();
	//	}


	public static void moveRooms()
	{
		ArrayList<String> roomNames = new ArrayList<String>();
		roomNames.add("C1_U");
		roomNames.add("C1U_STE_1");
		roomNames.add("C1U_BA_1");
		roomNames.add("C1U_STE_2");
		roomNames.add("C1U_PASS_1");
		roomNames.add("C1U_BA_2");
		roomNames.add("C1_L");
		roomNames.add("C1L_KT_1");
		roomNames.add("C1L_DIN_1");
		roomNames.add("C1L_BA_3");
		roomNames.add("C2_U");
		roomNames.add("C2U_BA_4");
		roomNames.add("C2U_STE_3");
		roomNames.add("C2U_STE_4");
		roomNames.add("C2U_BA_5");
		roomNames.add("C2_L");
		roomNames.add("C2L_BA_6");
		roomNames.add("C2L_STE_10");
		roomNames.add("C2L_STE_11");
		roomNames.add("C2L_SIT_12");
		roomNames.add("C3_U");
		roomNames.add("C3U_BAR");
		roomNames.add("C3U_LG_1");
		roomNames.add("C3U_LG_2");
		roomNames.add("C3U_BA_7");
		roomNames.add("C3_L");
		roomNames.add("C3L_COAL_RM");
		roomNames.add("C3L_RM");
		roomNames.add("C3_STF_2");
		roomNames.add("C3U_BA_8");
		//System.out.println(Game.currentRoom.getID());
		System.out.println(Game.currentRoom.displayExits());
		int move = Game.input.nextInt();

		System.out.println(Game.currentRoom.displayDescription(move));
		Game.currentRoom = Game.currentRoom.getNewRoom(Game.currentRoom.exits.get(move));
		//Game.currentRoom = roomNames.get(move);

		//System.out.println(Game.currentRoom.getID());
		Menu.MainMenu();
	}
}
