package Model;
import java.util.ArrayList;
import Controller.*;


/**
 * 
 * @author Brian Torok
 *
 */
public class Player extends Character
{
	private static String username;
	private static int score;
	public static ArrayList<Item> inventory = new ArrayList<Item>();

	public Player()
	{
		super();
	}
	
	public Player(int characterID, String name) {
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
	public static int getScore()
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
	
	public static void setInventory(Item item)
	{
		inventory.add(item);
	}
	
	public static void increaseScore(int x)
	{
		score += x;
	}
	
	public static void decreaseScore(int x)
	{
		score -= x;
	}
	

	
	
	
	//Goes through the battle process
	public static void attack(Player p, Monsters m)
	{
		double playerChance = Math.random();
		if (playerChance >= m.getChance())
		{
			//Lose Condition
			Player.setScore(Player.getScore() - m.getScoreLoss());
			System.out.println("Looks like you weren't so lucky this time 'round");
			Menu.CombatMenu();
		}
		else
		{
			//win condition
			m.remove();
			Player.increaseScore(Game.currentRoom.getMonsters().getScoreLoss());
			System.out.println(m.getWinStatement());
			Game.currentRoom.getMonsters().setIsDefeated(true);
			Player.setInventory(Game.currentRoom.getMonsters().getDropItems());
			Menu.MainMenu();
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
			return "It doesn't look like you've got anything there. Are you even trying?";
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
