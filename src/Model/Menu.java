package Model;

import java.util.Scanner;

/**
 * 
 * @author Jose Moreno
 *
 */

public class Menu
{
	public static Scanner input = new Scanner(System.in);

	public static void MainMenu()
	{
		System.out.println("What would you like to do?");
		System.out.println("1. Move Rooms");
		System.out.println("2. Check Inventory");
		System.out.println("3. Help Menu");
		System.out.println("4. Exit Game");


		int options = input.nextInt();

		switch(options)	{

		case 1:
			Rooms.moveRooms();
			break;
		case 2:
			
			break;
		case 3:
			Game.printHelp();
			break;
		case 4:
			System.out.println("Do you want to save the game? Y / N");			
			if (Game.input.next() == "Y")
			{

			}
			else
				System.exit(0);
			break;
		default:
			System.out.println("Please enter 1 to create a new game, 2 to load a game, 3 to exit the game.");
			break;

		}


	}
	
	public static void CombatMenu()
	{
		
	}
}