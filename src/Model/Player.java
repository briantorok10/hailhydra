package Model;

/**
 * 
 * @author Jose Moreno
 *
 */
public class Player extends Character
{
	public Player(int characterID, String name, Room currentRoom)
	{
		super(characterID, name, currentRoom);

	}

	public static String username;

	public static String getUsername()
	{
		return username;
	}

	public static void setUsername(String username)
	{
		Player.username = username;
	}
	
}
