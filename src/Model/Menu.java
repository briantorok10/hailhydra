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
			System.out.println("Your Score: " + Game.player.getScore());
			System.out.println("This is what you're lugging around:");
			//Still needs some work
			/*
			if (Game.player.getInventory().isEmpty())
			{
				System.out.println("You don't seem to be carrying anything but the clothes on your back.\nWhat kind of a thief are ya?");
			}
			else
			{
				for (Item i: Game.player.getInventory())
				{
					System.out.println(i.getName());
				}
			}
			*/
			Menu.MainMenu();
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
		System.out.println(Game.currentRoom.getMonsters().getEnterStatement());
		System.out.println("What would you like to do?");
		System.out.println("1. Attack " + Game.currentRoom.getMonster().getName());
		System.out.println("2. Run");
		System.out.println("3. Use Item");


		int options = input.nextInt();

		switch(options)	{

		case 1:
			Player.attack(Game.player, Game.currentRoom.getMonster());
			break;
		case 2:
			Rooms.moveRooms();
			break;
		case 3:
			Game.printHelp();
			break;
		default:
			System.out.println("Please enter 1 to create a new game, 2 to load a game, 3 to exit the game.");
			break;
		}
	}
}