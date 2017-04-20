package View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Player;
import Model.Sleep;


/**
 * 
 * @author Jose Moreno
 *
 */
public class Game
{
	private static Game game;
	private Player player;
	private int score;
	
	public void create(Player p) throws IOException{
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter username: ");
			String user = input.next();
			Player.setUsername(user);
			String username = p.getUsername();
			File file = new File(username + ".txt");
			if(file.exists())
			{
				System.out.println("This name already exists, please use a different name!");
			} else {
				System.out.println("Profile being created, please wait....");
				PrintWriter writer = new PrintWriter(new FileWriter(file));
				writer.println(username);
				writer.close();
				Sleep.Delay(3000);
				System.out.println();
				System.out.println("Alright " + p.getUsername() + ", I need you to get on this\n" +
									"train and get as much loot as possible! Good Luck!");

			}input.close();
		}
		
	}

	public void save(Player p)
	{
		String username = p.getUsername();
		File file = new File(username + ".txt");
		if(file.exists())
		{
			try{
				PrintWriter writer = new PrintWriter(new FileWriter(file));
				writer.println(username);
				writer.close();
			}catch (FileNotFoundException fnfe)
			{
				System.out.println("File not found: " + fnfe.getLocalizedMessage());
			}catch (IOException e)
			{
				System.out.println("Other Error " + e.getLocalizedMessage());
			}
		}
	}

	public void load(Player p)

	{
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the username of the file you wish to load.");
		String username = input.next();
		File file = new File(username + ".txt");
		if(file.exists())
		{
			System.out.println("File found! Loading Game.....");
			try
			{
				String name;
				BufferedReader reader = new BufferedReader(new FileReader(file));
				name = reader.readLine();
				reader.close();
				
				Player.setUsername(name);
				
				System.out.println("Welcome back " + p.getUsername());
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		input.close();
		
	}
	
	public Game(Player player)
	{
		this.player = player;
		this.score = 0;
	}
	
	public static boolean initializeGame() 
	{
		Player p = new Player();
		if(game == null) 
		{
			game = new Game(p);
			return true;
		}
		else 
		{
			return false;
		}
	}
	
}
