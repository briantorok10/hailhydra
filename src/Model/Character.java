package Model;

import java.io.Serializable;

/**
 * 
 * @author Jose Moreno
 *
 */

public abstract class Character implements Serializable
{
	protected int characterID;
	protected String name;
	protected static Rooms currentRoom;
	protected static Rooms room;
	
	protected Character()
	{
		this.characterID = 000;
		this.name = null;
		Character.currentRoom = null;
	}
	
	protected Character(int characterID, String name, Rooms currentRoom)
	{
		this.characterID = characterID;
		this.name = name;
		Character.currentRoom = currentRoom;
	}

	public int getCharacterID()
	{
		return characterID;
	}

	public String getName()
	{
		return name;
	}
	
	public Rooms getCurrentRoom()
	{
		return currentRoom;
	}
	
	public void setCurrentRoom(Rooms currentRoom)
	{
		Character.room = currentRoom;
	}
	
}
