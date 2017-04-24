package Model;
import java.io.Serializable;
import java.util.ArrayList;
import Controller.*;


import Controller.Game;
import Controller.Menu;

/**
 * 
 * @author Brian Torok
 *
 */
public class Player extends Character implements Serializable
{
	private static String username;
	private static int score;
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static double increaseChance = 0;

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
	public static double getIncreaseChance()
	{
		return increaseChance;
	}
	public static void setIncreaseChance(double x)
	{
		increaseChance = x;
	}
	

	
	
	
	//Goes through the battle process
	public static void attack(Player p, Monsters m)
	{
		double playerChance = Math.random() - (m.getChance()*increaseChance);
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
			increaseScore(Game.currentRoom.getMonsters().getScoreLoss());
			setIncreaseChance(getIncreaseChance() + Game.currentRoom.getMonsters().getDropItems().getIncChance());
			System.out.println(m.getWinStatement());
			Game.currentRoom.getMonsters().setIsDefeated(true);
			setInventory(Game.currentRoom.getMonsters().getDropItems());
			Menu.MainMenu();
		}
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
