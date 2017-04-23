package Model;

import java.io.IOException;
import java.util.Scanner;
/**
 * 
 * @author Jose Moreno
 *
 */
public class Start
{	
	public void startMessage()
	{
		System.out.println();
		System.out.println("\t XXXXX  XXX    XX   XXX  X  X ");
		System.out.println("\t   X    X  X  X  X   X   X  X ");
		System.out.println("\t   X    X  X  X  X   X   XX X ");
		System.out.println("\t   X    XXX   XXXX   X   X XX ");
		System.out.println("\t   X    X  X  X  X   X   X  X ");
		System.out.println("\t   X    X  X  X  X  XXX  X  X ");
		System.out.println("\t------------------------------");
		System.out.println("\t     XXX    XX   XXX  XXX    ");
		System.out.println("\t     X  X  X  X   X   X  X   ");
		System.out.println("\t     X  X  X  X   X   X  X   ");
		System.out.println("\t     XXX   XXXX   X   X  X   ");
		System.out.println("\t     X  X  X  X   X   X  X   ");
		System.out.println("\t     X  X  X  X  XXX  XXX    ");
		
		Scanner input = new Scanner(System.in);
		Game game = new Game();
		Player p = new Player(0, null);
		System.out.println("*++++++++++++++++++++++++++++++++++++++++++++*");
		System.out.println();
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
				Game.initializeGame();
				break;
			case 2:
				game.load(p);
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Please enter 1 to create a new game, 2 to load a game, 3 to exit the game.");
				startMessage();
				break;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}input.close();
		
	}
		
		
	
}
