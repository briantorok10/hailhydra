package Model;
import java.util.ArrayList;

/**
 * 
 * @author Jose Moreno
 *
 */
public class Player extends Character
{
	private static Rooms room;
	private static String username;
	private static int score;
	private ArrayList<Item> inventory;

	public Player()
	{
		super();
	}
	
	public Player(int characterID, String name, Rooms currentRoom) {
		super(characterID, name, currentRoom);
		// TODO Auto-generated constructor stub
	}
	
	public String getUsername()
	{
		return username;
	}
	public static void setUsername(String username)
	{
		Player.username = username;
	}
	public int getScore()
	{
		return score;
	}
	public static void setScore(int newScore)
	{
		score = newScore;
	}
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}
	
	public Rooms getCurrentRoom()
	{
		return currentRoom;
	}
	
	public void setCurrentRoom(Rooms currentRoom)
	{
		Player.room = currentRoom;
	}
	
	
	
	//Goes through the battle process
	public static void attack(Player p, Monsters m)
	{
		System.out.println(m.getEnterStatement());
		double playerChance = Math.random();
		if (playerChance >= m.getChance())
		{
			//Lose Condition
			Player.setScore(p.getScore() - m.getScoreLoss());
			System.out.println("Looks like you weren't so lucky this time 'round");
		}
		else
		{
			//win condition
			m.remove();
			System.out.println(m.getWinStatement());
		}
	}
	
	public void useItem(Item i)//uses effect from item objects
	{
		i.effect();
	}
	
	public void escape(Monsters m)
	{
		System.out.println(m.getExitStatement());
		//needs logic for selecting a valid room
	}
	
	//returns a string formatted for 
	public String readInventory()
	{
		if (!inventory.isEmpty())
		{
			return "Alright, this is what you've got" + inventory.toString();
		}
		else
		{
			return "It donesn't look like you've got anything there. Are you even trying?";
		}
	}
	
	public String toString()
	{
		String in = "";
		for(Item i: inventory)
		{
			in += ": " + i.getName();
		}
		return in;
	}
	
}
