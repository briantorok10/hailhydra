package Controller;

import java.util.Scanner;
import Model.Item;
import Model.Player;
import Model.Rooms;
import Model.*;

import Controller.Game;
import Model.*;

/**
 * 
 * @author Jose Moreno & Brian Torok
 *
 */

public class Menu
{
	public static Scanner input = new Scanner(System.in);

	public static void MainMenu()
	{
		System.out.println();
		System.out.println("\n-----Main Menu-----");
		System.out.println("What would you like to do?");
		System.out.println("1. Move Rooms");
		System.out.println("2. Check Inventory and Score");
		System.out.println("3. Help Menu");
		System.out.println("4. Exit Game");

		int options = input.nextInt();

		switch (options) {
		case 1:
			Rooms.moveRooms();
			break;
		case 2:

			System.out.println("Your Score: " + Player.getScore() + "G");
			System.out.println("This is what you're lugging around:");
			// Still needs some work

			if (Player.inventory.isEmpty())
			{
				System.out.println(
						"You don't seem to be carrying anything but the clothes on your back.\nWhat kind of a thief are ya?");
			} else
			{
				for (Item i : Player.inventory)
				{
					System.out.println(i.getName() + " - " + i.getUse());
				}
			}

			Menu.InventoryMenu();

			break;
		case 3:
			Game.printHelp();
			break;
		case 4:
			System.out.println("\nDo you want to save the game? Y / N");
			if (Game.input.next().equalsIgnoreCase("Y"))
			{
				Game.save();
			} else
				System.exit(0);
			break;
		default:
			System.out.println("Please enter 1 to create a new game, 2 to load a game, 3 to exit the game.");
			break;

		}

	}

	public static void PuzzleMenu()
	{
		System.out.println("-----Puzzle Menu-----");
		System.out.println("1. Enter Answer");
		System.out.println("2. Repeat Question");
		System.out.println("3. Hint");
		System.out.println("4. Exit Puzzle");

		int options = input.nextInt();

		switch (options) {

		case 1:
			System.out.println("\nWhat is your guess?");
			String answer = Game.input.next();
			if (answer.equalsIgnoreCase(Game.currentRoom.getPuzzle().getSolution()))
			{
				System.out.println("\n" + Game.currentRoom.getPuzzle().getCorrectMSG());
				Game.currentRoom.getPuzzle().setSolved(true);
				Player.setIncreaseChance(
						Player.getIncreaseChance() + Game.currentRoom.getPuzzle().getItem().getIncChance());
				Player.increaseScore(Game.currentRoom.getPuzzle().getGold());
				Player.setInventory(Game.currentRoom.getPuzzle().getItem());
				MainMenu();
			} else
				System.out.println("\n" + Game.currentRoom.getPuzzle().getIncorrectMSG());
			PuzzleMenu();
			break;
		case 2:
			System.out.println(Game.currentRoom.getPuzzle().getDescription());
			PuzzleMenu();
			break;
		case 3:
			System.out.println(Game.currentRoom.getPuzzle().getHint());
			PuzzleMenu();
			break;
		case 4:
			System.out.println(Game.currentRoom.getDescription());
			MainMenu();
			break;
		default:
			System.out.println();
			break;
		}
	}

	public static void CombatMenu()
	{
		System.out.println();
		System.out.println(Game.currentRoom.getMonsters().getEnterStatement());
		System.out.println("What would you like to do?");
		System.out.println("1. Attack " + Game.currentRoom.getMonsters().getName());
		System.out.println("2. Run");
		System.out.println("3. Use Item");

		String options = input.next();

		if (options.equals("1"))
		{
			Player.attack(Game.player, Game.currentRoom.getMonsters());
		} else if (options.equals("2"))
		{
			Rooms.moveRooms();
		} else if (options.equals("3"))
		{
			Item.useItem();
			Menu.CombatMenu();
		} else
		{
			System.out.println("That's not a valid option. Try typing 1, 2, or 3.\n");
			Menu.CombatMenu();
		}

	}

	public static void InventoryMenu()
	{
		System.out.println();
		System.out.println("\n-----Inventory Menu-----");
		System.out.println("What would you like to do?");
		System.out.println("1. Cash Out Coins");
		System.out.println("2. Exit Inventory");

		int options = input.nextInt();

		switch (options) {

		case 1:
			Item.cashOut();
			break;
		case 2:
			MainMenu();
		}
	}
}