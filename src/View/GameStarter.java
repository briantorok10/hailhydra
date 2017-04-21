package View;

import Model.Game;
import Model.Start;

/**
 * 
 * @author Jose Moreno
 *
 */
public class GameStarter
{
	static Start start = new Start();
	public static void main (String [] args)
	{
		start.startMessage();
		Game.play();
	}
		

}



