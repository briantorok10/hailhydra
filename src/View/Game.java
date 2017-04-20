package View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Model.Player;
import Model.Rooms;
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
	
	public Game()
	{
		this.score = 0;
	}
	
	public static void initializeGame() 
	{
		Rooms C1_U, C1U_STE_1, C1U_BA_1, C1U_STE_2, C1U_PASS_1, C1U_BA_2, C1_L,
		C1L_KT_1, C1L_DIN_1, C1L_BA_3, C2_U, C2U_BA_4, C2U_STE_3, C2U_STE_4, C2U_BA_5,
		C2_L, C2L_BA_6, C2L_STE_10, C2L_STE_11, C2L_SIT_12, C3_U, C3U_BAR, C3U_LG_1,
		C3U_LG_2, C3U_BA_7, C3_L, C3L_COAL_RM, C3L_RM, C3_STF_2, C3U_BA_8;
		
		C1_U = new Rooms("C1_U", "Upper Hallway 1", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C1U_STE_1 = new Rooms("C1U_STE_1", "Master Bedroom Suite", "Sweet!  The Master Bedroom Suite, there are two large beds to your left and your right. There appears to be some jewelry on the left bed, and a sparkly item underneath the pillow on the right bed. The room appears deserted, but there seems to be some kind of noise coming from around the room.");
		C1U_BA_1 = new Rooms("C1U_BA_1", "Bathroom 1", "You have entered the bathroom. Someone is in here. Yo! Do you know how to knock first? That's rude. And I don't like rude people so...time to meet your maker!");
		C1U_STE_2 = new Rooms("C1U_STE_2", "Bedroom Suite 2", "Nice little bedroom for the back of the train.  It has one bed to the right of you; there might be something in there. You also see a dresser to the left, there appears to be a piece of paper attached to it, will you answer the riddle?");
		C1U_PASS_1 = new Rooms("C1U_PASS_1", "Passenger Seating", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C1U_BA_2 = new Rooms("C1U_BA_2", "Bathroom 2", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C1_L = new Rooms("C1_L", "Lower Hallway 1", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C1L_KT_1 = new Rooms("C1L_KT_1", "Kitchen", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C1L_DIN_1 = new Rooms("C1L_DIN_1", "Dining Room", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C1L_BA_3 = new Rooms("C1L_BA_3", "Bathroom 3", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C2_U = new Rooms("C2_U", "Upper Hallway 2", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C2U_BA_4 = new Rooms("C2U_BA_4", "Bathroom 4", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C2U_STE_3 = new Rooms("C2U_STE_3", "Bedroom Suite 3", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C2U_STE_4 = new Rooms("C2U_STE_4", "Bedroom Suite 4", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C2U_BA_5 = new Rooms("C2U_BA_5", "Bathroom 5", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C2_L = new Rooms("C2_L", "Lower Hallway 2", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C2L_BA_6 = new Rooms("C2L_BA_6", "Bathroom 6", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C2L_STE_10 = new Rooms("C2L_STE_10", "Bedroom Suite 5", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C2L_STE_11 = new Rooms("C2L_STE_11", "Bedroom Suite 6", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C2L_SIT_12 = new Rooms("C2L_SIT_12", "Sitting Area", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C3_U = new Rooms("C3_U", "Upper Hallway 3", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C3U_BAR = new Rooms("C3U_BAR", "Bar", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C3U_LG_1 = new Rooms("C3U_LG_1", "Lounge 1", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C3U_LG_2 = new Rooms("C3U_LG_2", "Lounge 2", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C3U_BA_7 = new Rooms("C3U_BA_7", "Bathroom 7", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C3_L = new Rooms("C3_L", "Lower Hallway 3", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C3L_COAL_RM = new Rooms("C3L_COAL_RM", "Coal Room", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C3L_RM = new Rooms("C3L_RM", "Engine Room", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C3_STF_2 = new Rooms("C3_STF_2", "Staff Lounge", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");
		C3U_BA_8 = new Rooms("C3U_BA_8", "Bathroom 8", "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?");

		//UPPER HALLWAY EXITS
		C1_U.setExit("1", C1U_STE_1);
		C1_U.setExit("2", C1U_BA_1);
		C1_U.setExit("3", C1U_STE_2);
		C1_U.setExit("4", C1U_PASS_1);
		C1_U.setExit("5", C1U_BA_2);
		C1_U.setExit("6", C1_L);

		
	}
	
}
