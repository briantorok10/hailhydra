package Model;

import java.io.Serializable;
import java.util.Random;

/**
 * 
 * @author Jose Moreno
 *
 */

public abstract class Character implements Serializable
{
	protected int characterID;
	protected String name;
	protected Room currentRoom;
	
	protected Character(int characterID, String name, Room currentRoom)
	{
		this.characterID = characterID;
		this.name = name;
		this.currentRoom = currentRoom;
	}

	public int getCharacterID()
	{
		return characterID;
	}

	public String getName()
	{
		return name;
	}

	public Room getRoom()
	{
		return currentRoom;
	}
	
	public String gamble(double probability)
	{
		Random r = new Random();
		double d = r.nextDouble();
		
		if(1 - probability >= d )
		{
			return "You lose!";
		}
		return "Winner";
	}
	
	
}
