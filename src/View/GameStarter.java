package View;

import java.io.IOException;
import java.util.Scanner;
import View.Game;
import Model.Player;

/**
 * 
 * @author Jose Moreno
 *
 */
public class GameStarter
{
	public static void main (String [] args)
	{
		Scanner input = new Scanner(System.in);
		Game game = new Game();
		Player p = new Player();
		System.out.println("*+++++++++++++++++++++++++++++++++++++++*");
		System.out.println("Please make a selection:");
		System.out.println("< 1 > Start New Game");
		System.out.println("< 2 > Load Existing Game");
		System.out.println("< 3 > Exit Game");
		int options = input.nextInt();
		try{
			switch(options)	
			{
			case 1:
				game.create(p);
				break;
			case 2:
				game.load(p);
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Please enter 1 to create a new game, 2 to load a game, 3 to exit the game.");
				break;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}



