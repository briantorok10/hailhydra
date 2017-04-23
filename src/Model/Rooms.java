package Model;


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
	private Puzzle puzzle;
	private Item item;
	private Monsters monster;
	private HashMap<Integer, Rooms> exits;
	private boolean entered;

	public Rooms(int ID, String name, String description, Puzzle puzzle, Monsters monster, Item item, boolean entered)
	{
		this.ID = ID;
		this.name = name;
		this.description = description;
		this.puzzle = puzzle;
		this.monster = monster;
		this.item = item;
		this.entered = entered;
		exits = new HashMap<Integer, Rooms>();
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
	public Monsters getMonsters()
	{
		return monster;
	}
	
	public Puzzle getPuzzle()
	{
		return puzzle;
	}

	public boolean isEntered()
	{
		return entered;
	}

	public void setEntered(boolean entered)
	{
		this.entered = entered;
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
		for (int exit : keys)
		{
			returnString += "\n" + exit + ". " + displayName(exit);
		}
		return returnString;
	}

	public int displayID(int direction)
	{
		return exits.get(direction).getID();
	}
	public String displayName(int direction)
	{
		return exits.get(direction).getName();
	}
	public String displayDescription(int direction)
	{
		return exits.get(direction).getDescription();
		//return exits.get(direction).getID();
	}

	public Rooms getNewRoom(Rooms rooms)
	{
		return exits.get(rooms);
	}
	
	public boolean hasMonsters()
	{
		if(monster == null)
		{
			return false;
		}
		else
			return true;
	}

		
	//public String getItem()
	//{
		//return items.toString();
	//}


	public static void moveRooms()
	{
		System.out.println(Game.currentRoom.displayExits());
		int move = Game.input.nextInt();
	
		System.out.println(Game.currentRoom.displayDescription(move));
		
		for(Rooms r : Game.getRooms())
		{
			if(r.getID() == move)
			{
				Game.setCurrentRoom(r);		
			}
		}
		
		if (Game.getCurrentRoom().hasMonsters() && Game.currentRoom.getMonsters().getIsDefeated() == false)
		{
			Menu.CombatMenu();
		}
		else if(Game.currentRoom.getPuzzle() != null && Game.currentRoom.getPuzzle().getIsSolved() == false)
		{
			System.out.println(Game.currentRoom.getPuzzle().getDescription());
			Menu.PuzzleMenu();
		}
		else
			Menu.MainMenu();
	}


}
