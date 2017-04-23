package Model;

import Controller.*;
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
	private boolean locked;
	private int scoreNeeded;

	public Rooms(int ID, String name, String description, Puzzle puzzle, Monsters monster, Item item, boolean entered)
	{
		this.ID = ID;
		this.name = name;
		this.description = description;
		this.puzzle = puzzle;
		this.monster = monster;
		this.item = item;
		this.entered = entered;
		this.locked = false;
		exits = new HashMap<Integer, Rooms>();
	}
	
	public Rooms(int ID, String name, String description, Puzzle puzzle, Monsters monster, Item item, boolean entered, 
			boolean locked, int scoreNeeded)
	{
		this.ID = ID;
		this.name = name;
		this.description = description;
		this.puzzle = puzzle;
		this.monster = monster;
		this.item = item;
		this.entered = entered;
		this.locked = locked;
		this.scoreNeeded = scoreNeeded;
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
		return description;
		
	}
	public void setLocked(boolean b)
	{
		this.locked = b;
	}
	public boolean getLocked()
	{
		return locked;
	}
	public int getScoreNeeded()
	{
		return scoreNeeded;
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
		System.out.println();
		
		for(Rooms r : Game.getRooms())
		{
			if(r.getID() == move && r.getLocked() == false)
			{
				Game.setCurrentRoom(r);
				System.out.println(Game.currentRoom.getDescription());
			}
			else if(r.getID() == move && r.getLocked() == true)
			{
				if(Game.player.getScore() >= r.getScoreNeeded())
				{
						System.out.println("Congrats! You just unlocked this room with your amazing lockpicking skills!");
						Game.setCurrentRoom(r);
						System.out.println(Game.currentRoom.getDescription());
				}
				else
				{
					System.out.println("Looks like this door is locked. You need at least " + r.getScoreNeeded() + "gold to enter.");
					Menu.MainMenu();
				}
			}
		}
		
		if(Game.currentRoom.getPuzzle() != null && Game.currentRoom.getPuzzle().getIsSolved() == false)
		{
			System.out.println(Game.currentRoom.getPuzzle().getDescription());
			Menu.PuzzleMenu();
		}
		else if (Game.getCurrentRoom().hasMonsters())
		{
			Menu.CombatMenu();
		}
		else
			Menu.MainMenu();
	}


}
