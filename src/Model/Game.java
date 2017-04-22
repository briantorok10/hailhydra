package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


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
	public static String begin;
	public static Rooms currentRoom;
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<Rooms> roomNames = new ArrayList<Rooms>();

	public static ArrayList<Rooms> getRooms()
	{
		return roomNames;
	}
	
	public static void setCurrentRoom(Rooms r)
	{
		currentRoom = r;
	}
	public void create(Player p) throws IOException{
		{
			//Scanner input = new Scanner(System.in);
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
						"train and get as much loot as possible! Good Luck!\n");

			}
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

	public static void printHelp()
	{
		System.out.println("---------HELP MENU---------");
		System.out.println("Select one of the options from the main menu!");
		System.out.println("Simple number input is required to progress!");
		System.out.println("That means enter a single number... like 1 or 2 or maybe even 3!");
		Menu.MainMenu();
	}

	public static void initializeGame() 
	{
		Puzzle P1;
		
		P1 = new Puzzle("Trial",0,"Skull","Skull is the answer","Correct!","Wrong!","I said the answer is Skull",false,null);
		
		Rooms C1_U, C1U_STE_1, C1U_BA_1, C1U_STE_2, C1U_PASS_1, C1U_BA_2, C1_L,
		C1L_KT_1, C1L_DIN_1, C1L_BA_3, C2_U, C2U_BA_4, C2U_STE_3, C2U_STE_4, C2U_BA_5,
		C2_L, C2L_BA_6, C2L_STE_10, C2L_STE_11, C2L_SIT_12, C3_U, C3U_BAR, C3U_LG_1,
		C3U_LG_2, C3U_BA_7, C3_L, C3L_COAL_RM, C3L_RM, C3_STF_2, C3U_BA_8;

		C1_U = new Rooms(0, "Upper Hallway 1", "You in the upper hallway of the first car. Plenty to get pillage through up here.  Let's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger Seating to watch a movie, and a guest bathroom. Where do you want to go first?",null,null,null,false);
		C1U_STE_1 = new Rooms(1, "Master Bedroom Suite", "Sweet!  The Master Bedroom Suite, there are two large beds to your left and your right. There appears to be some jewelry on the left bed, and a sparkly item underneath the pillow on the right bed. The room appears deserted, but there seems to be some kind of noise coming from around the room.",null,null,null,false);
		C1U_BA_1 = new Rooms(2, "Bathroom 1", "You have entered the bathroom. Someone is in here. Yo! Do you know how to knock first? That's rude. And I don't like rude people so...time to meet your maker!",P1,null,null,false);
		C1U_STE_2 = new Rooms(3, "Bedroom Suite 2", "Nice little bedroom for the back of the train.  It has one bed to the right of you; there might be something in there. You also see a dresser to the left, there appears to be a piece of paper attached to it, will you answer the riddle?",null,null,null,false);
		C1U_PASS_1 = new Rooms(4, "Passenger Seating", "Ah, they’re playing your favorite movie in the Passenger Seating area, Ocean's Eleven.  There are seats to your right and left. You could sit a finish the movie, but you'd be wasting precious time. You notice someone staring at you from the corner of your eye.  He stands between you and the door to the 2nd car.  There's also a bathroom you could hide in for awhile if that's your thing.",null,null,null,false);
		C1U_BA_2 = new Rooms(5, "Bathroom 2", "I hope you have to use the bathroom because there's nothing else in here to do.  Pick a better place to pillage next time won't you.",null,null,null,false);
		C1_L = new Rooms(6, "Lower Hallway 1", "Okay, you made it safely onto the train without a hitch.  Now its time to go to work finding the loot.  On your right is the kitchen.  Bound to be a weapon in there you could use to defend yourself in case someone recognizes you from American's Most Wanted show last month.  A safer route maybe the Dining Room Area to grab a bit to eat. Maybe you should head to the bathroom to freshen up....it may be a bumpy ride.",null,null,null,true);
		C1L_KT_1 = new Rooms(7, "Kitchen", "You walked into the kitchen where there appears to be spoons, forks, and other various utensils. There lies a riddle on the cutting table, will you answer it?",null,null,null,false);
		C1L_DIN_1 = new Rooms(8, "Dining Room", "Something really smells good in here.  You're in a wide area with plenty of tables around, this must be the dining room, there appears to be someone sitting at a table minding his own business.  He is holding something very valuable that you could really use on your quest, shall you engage, or move on?",null,null,null,false);
		C1L_BA_3 = new Rooms(9, "Bathroom 3", "Why in the world did you come in here?  There is an extremely angered and ornery man of about less than average height.  Get ready for a fight; he won't give up his porcelain throne so easily.",null,null,null,false);
		C2_U = new Rooms(10, "Upper Hallway 2", "Now you're getting somewhere.  Look around take it all in.  Where to now?",null,null,null,false);
		C2U_BA_4 = new Rooms(11, "Bathroom 4", "ARGHHHH!!!! OCCUPIED!!! You interrupted a rival train robber doing his business. His pants are at his ankles but a fight would still seem in his favor. You quickly scan the room for any object to give you the advantage. Toilet paper, no. Hand soap, no. A plunger is resting underneath the sink. Do you grab it and fight for your life or run back into the hallway in hopes of finding a hiding place?",null,null,null,false);
		C2U_STE_3 = new Rooms(12, "Bedroom Suite 3", "This bedroom has not been used for a while, looks more like an old creepy storage closet. Dust has collected on everything, extra furniture and decorations just thrown about. I wonder why they have not used this bedroom recently. Before exiting you notice a small hole that has developed in the corner, a Man is seemingly standing guard in front of the hole. You can hear loud deep bass music coming from the other side of the wall, probably one of those train diskotechs. Do you go and inspect the Bouncer or return to the hallway?",null,null,null,false);
		C2U_STE_4 = new Rooms(13, "Bedroom Suite 4", "This bedroom looks promising.  Nice comfortable sleeper sofa, full size bed.  It even has a marble round table with what looks like a wallet lying on top. Wait a minute; what is that stack of green in the corner by the wicker dresser?  It looks to be a stack of $100 bills.  No, it’s a special riddle to open the safe next to the bed.  You think you hear someone in the next room.  Do you stay and crack the safe or get out while you have the chance?",null,null,null,false);
		C2U_BA_5 = new Rooms(14, "Bathroom 5", "Almost there, but time for a pit stop. All this running through the train has got you hot and sweaty.  Sweat equals funk! Nasty! Hope in the grey porcelain shower to cool off.  Much better!  Wait...is this door looked for the outside? No, there's a riddle combination look to get out of here.  You can try to solve it or just kick down the door...but that may lead to trouble.",null,null,null,false);
		C2_L = new Rooms(15, "Lower Hallway 2", "Well done, you have successfully made it to the second car! Moving right along. Lets see what goodies are lying around in here.  This is odd!  Is this what I think it is?  Yep, it’s a sack of gold coins encased in a riddle box. Are you going to solve it or leave it be?  This room looks like there's a lot more loot laying are round than that.",null,null,null,false);
		C2L_BA_6 = new Rooms(16, "Bathroom 6", "This is a very nice bathroom to be on a train.  The shower stall to your left looks like it has fine Italian marble tiles on the floor.  There’s a tempered glass medicine cabinet above the sink to your right.  Wait!  What is that shiny piece of metal reflecting off the mosaic shower curtain?  Just as you reach to slide back the shower curtain out jumps CEO of SunnyDale Inc..  That shiny piece of metal turns out to be an old fashion razor blade.  And he is posed for a fight. Do you stay and fight? Act like your lost and try to quick exit the room? ",null,null,null,false);
		C2L_STE_10 = new Rooms(17, "Bedroom Suite 5", "O.K., another Bedroom Suite. There are twin beds to your left and right.  Tucked halfway under the bed on the right is a briefcase.  There’s bound to be some loot in it.  Suddenly you hear footsteps coming your way.  You could grab the briefcase and hide under the bed till the coast is clear or jump out of the window with the briefcase.  Your only other option is to attack the person with the briefcase if they come in.  Well?",null,null,null,false);
		C2L_STE_11 = new Rooms(18, "Bedroom Suite 6", "Dang, all these Bedroom Suites. Where is the loot? There are beds to your left and right. That’s it! Try another room.",null,null,null,false);
		C2L_SIT_12 = new Rooms(19, "Sitting Area", "Plenty of over-sized comfy couches in this Sitting Area.  One red, one blue.  Sit on the blue one it empty at the moment.  Surly you can afford to take a minute to catch your breath after everything you've been through on this train.  Ah, man...no rest for the weary.  Here comes trouble.  You could give up now or take your chances with this incompetent individual.  What's it going to be?",null,null,null,false);
		C3_U = new Rooms(20, "Upper Hallway 3", "Can you believe it....you can practically taste the gold you're so close.  You just need to scout out a few more rooms before you're home free.  Let's see here.....",null,null,null,false);
		C3U_BAR = new Rooms(21, "Bar", "Looking around, this looks like great place to stop. Everyone mingling at the bar have a great time.  Bartender is mix up Boiler Makers.  Yum! Might as well stop for a quick drink to blend in with the crowd.  The bartender, a Romanian beauty with long dark brown hair  says she’ll only serve you if you can solve a puzzle for her.  Are you game?",null,null,null,false);
		C3U_LG_1 = new Rooms(22, "Lounge 1", "You’ve set your sights on the Member’s Only Lounge. It has plush velvety lazy boy reclining seats. A 50-inch flat screen TV on the wall to your right.  Complimentary champagne on top of the curio cabinet to your left.  Do you enter the lounge and waste precious time? Do you make your way through the rest of the train and stop playing around.",null,null,null,false);
		C3U_LG_2 = new Rooms(23, "Lounge 2", "You are in the General Lounge for all passengers.  Try your best to blend in.  There is one open chair for you to seat down in to your left. To your right is the restroom. Suddenly you notice an odd looking fellow charging at you.  You can stay and fight.  Hide in the restroom or make a run for stairs either in front of you or behind you. ",null,null,null,false);
		C3U_BA_7 = new Rooms(24, "Bathroom 7", "The bathroom is not the safest place to hide.  There is no other way out of this room.  You have just lost “15” points.  You must now face the ugly dude that's been watching you since the last train car.  Who is now banging on the door outside?",null,null,null,false);
		C3_L = new Rooms(25, "Lower Hallway 3", "Well it is about time.  Took you long enough.  Now where exactly is the jackpot? Let's check the ....",null,null,null,false);
		C3L_COAL_RM = new Rooms(26, "Coal Room", "Man, Oh Man...you knew this would be easy.  Now its becoming hazardous to your health, breathing in all this toxic air from inside the coal room.  There's got to be something more than mounds of black, dirty coal in here.  You spot what look to be a golf ball size diamond perched up on the coverer belt to your left.  But to your right is the Train Engineer standing in your way.  That diamond maybe just to valuable to pass up...or is it?",null,null,null,false);
		C3L_RM = new Rooms(27, "Engine Room", "JACKPOT!!!! Finally, you have reached the mother load and you are almost home free.  Only thing stopping you is one pissed of engine Mechanic.  His whole purpose in life is to guard the door that’s guarding the loot.  You didn't come all this way for nothing did you?  Well, did you?",null,null,null,false);
		C3_STF_2 = new Rooms(28, "Staff Lounge", "One of the train staff bragged about a very rare artifact she hide in this room since no one ever cleans up in here. It is worth millions! You have only a few minutes to look for it before your detected by the staff. You can stay and search for the artifact or exit through the door and continue up the train.",null,null,null,false);
		C3U_BA_8 = new Rooms(29, "Bathroom 8", "People always hide the weirdest things in bathrooms.  I guess a train bathroom is no different.  What do we have here?  The rare Mother of Pearl bracelet.  However you need to so answer this question before you can get it out of its case. ",null,null,null,false);
		 
		//ArrayList<Rooms> roomNames = new ArrayList<Rooms>();
		roomNames.add(C1_U);
		roomNames.add(C1U_STE_1);
		roomNames.add(C1U_BA_1);
		roomNames.add(C1U_STE_2);
		roomNames.add(C1U_PASS_1);
		roomNames.add(C1U_BA_2);
		roomNames.add(C1_L);
		roomNames.add(C1L_KT_1);
		roomNames.add(C1L_DIN_1);
		roomNames.add(C1L_BA_3);
		roomNames.add(C2_U);
		roomNames.add(C2U_BA_4);
		roomNames.add(C2U_STE_3);
		roomNames.add(C2U_STE_4);
		roomNames.add(C2U_BA_5);
		roomNames.add(C2_L);
		roomNames.add(C2L_BA_6);
		roomNames.add(C2L_STE_10);
		roomNames.add(C2L_STE_11);
		roomNames.add(C2L_SIT_12);
		roomNames.add(C3_U);
		roomNames.add(C3U_BAR);
		roomNames.add(C3U_LG_1);
		roomNames.add(C3U_LG_2);
		roomNames.add(C3U_BA_7);
		roomNames.add(C3_L);
		roomNames.add(C3L_COAL_RM);
		roomNames.add(C3L_RM);
		roomNames.add(C3_STF_2);
		roomNames.add(C3U_BA_8);
		//UPPER HALLWAY EXITS
		C1_U.setExit(1, C1U_STE_1);
		C1_U.setExit(2, C1U_BA_1);
		C1_U.setExit(3, C1U_STE_2);
		C1_U.setExit(4, C1U_PASS_1);
		C1_U.setExit(6, C1_L);
		//MASTER BEDROOM SUITE EXITS
		C1U_STE_1.setExit(0, C1_U);
		//BATHROOM 1 EXITS
		C1U_BA_1.setExit(0, C1_U);

		C1U_STE_2.setExit(0, C1_U);

		C1U_PASS_1.setExit(0, C1_U);
		C1U_PASS_1.setExit(5, C1U_BA_2);

		C1U_BA_2.setExit(0, C1_U);

		C1_L.setExit(0, C1_U);
		C1_L.setExit(7, C1L_KT_1);
		C1_L.setExit(8, C1L_DIN_1);
		
		C1L_KT_1.setExit(6, C1_L);
		
		C1L_DIN_1.setExit(6, C1_L);
		C1L_DIN_1.setExit(0, C1_U);
		C1L_DIN_1.setExit(7, C1L_KT_1);
		C1L_DIN_1.setExit(9, C1L_BA_3);
		
		C1L_BA_3.setExit(8, C1L_DIN_1);
		
		
		
		
		
		

		//begin = "C1_U";
		currentRoom = C1_L;
		System.out.println(Game.currentRoom.getDescription());
		Menu.MainMenu();

	}

	public static void play()
	{
		boolean done = false;

		while(!done)
		{

		}
	}

}
