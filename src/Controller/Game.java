package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Item;
import Model.Monsters;
import Model.Player;
import Model.Puzzle;
import Model.Rooms;
import Model.Sleep;


/**
 * 
 * @author Jose Moreno
 *
 */
public class Game
{
	static Player player;
	public static String begin;
	public static Rooms currentRoom;
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<Rooms> roomNames = new ArrayList<Rooms>();

	public static ArrayList<Rooms> getRooms()
	{
		return roomNames;
	}
	public static Rooms getCurrentRoom()
	{
		return currentRoom;
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
				create(p);
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
		System.out.println();
		System.out.println("---------Help Menu---------");
		System.out.println("Select one of the options from the main menu!");
		System.out.println("Simple number input is required to progress!");
		System.out.println("That means enter a single number... like 1 or 2 or maybe even 3!");
		Menu.MainMenu();
	}

	public static void initializeGame() 
	{
		
		Item A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,A11;
		
		A01 = new Item("Copper Coin",0,"A coin made of copper that holds a small value.","Add 10 gold to your bag",10);
		A02 = new Item("Silver Coin",1,"A coin made of silver that holds a medium value.","Add 50 gold to your bag",50);
		A03 = new Item("Gold Coin",2,"A coin made of pure gold that holds a high value.","Add 100 gold to your bag",100);
		A04 = new Item("Short Pants",3,"Incredibly short pants. This will be found when fighting the Shorty Pants monster (E03) and will allow you to progress forward.","Puzzle item",0);
		A05 = new Item("Revolver",4,"A 6 shot revolver","Add 25% chance to your favor in battle.",400);
		A06 = new Item("Crystal Skull",5,"Skull made of pure crystal. Has a sort of mystical glow about it. When you stare deep into the eyes of the skull you can hear the voices of ancient beings calling you to the other side.","Add 1000 gold to your bag",1000);
		A07 = new Item("Snakeskin Oil",6,"There's a snake in my boot!","One time consumable to increase battle chance in your favor by 5%",20);
		A08 = new Item("Conductor's Key",7,"Use this key to gain access to areas on the train","Open a locked door to move forward.",0);
		A09 = new Item("Queen Elizabeth's Diamond Broach",8,"Queen Elizabeth of England’s priceless diamond broach. Worth and extremely large sum of money to the right buyer. Useless otherwise.","Sell for an extremely large amount of money.",1000000);
		A10 = new Item("Miniscule Kitchen Knife",9,"An extremely small knife maybe used for cutting carrots.Could be a weapon against small mice.","Add 5% chance to your favor in battle",50);
		A11 = new Item("Bag O'Coins", 10, "A bag full of wonders... and money", "Special Item which contains 10 Gold Coins",1000);
		
		Puzzle P1,P2,P3,P4,P5,P6,P7,P8;
		
		P1 = new Puzzle("Coin",0,"Coin","What has a head and a tail, but no body?","Congratulations! You have received a Copper Coin for solving the puzzle!","This riddle ain't worth a cent of my time!","Small, round, and jingles in your pocket.",false, A01,7);
		P2 = new Puzzle("Food",1,"Egg","What has to be broken before you can use it?","Congratulations! You have received a miniscule kitchen knife for solving the puzzle!","Ah well I might come back later, it's not like it's too important.","Golden Goose",false,A10,14);
		P3 = new Puzzle("Dessert",2,"Doughnut","What has no beginning, end, or middle?","Congratulations! You passed the test and you may proceed.","There might be a delicacy behind this riddle, but it may just not be the time or place for such things.","Policeman's favorite food.",false,A10,20);
		P4 = new Puzzle("Key",3,"Key","What force and strength cannot get through, I with my unique teeth can do. What am I?","Nice work! You got the Conductor's Key for solving the puzzle.","I know there's some kind of trick to this puzzle, I'll come back later.","The only way to a door's heart.",false,A08,29);
		P5 = new Puzzle("History",4,"History","You will always find me in the past. I can be created in the present, but the future can never taint me. What am I?","Congratulations! You got the Silver Coin for solving the puzzle.","Well to my prior knowledge, sometimes its just not worth losing on this kind of gamble. I just lost a 2 points.","...repeats itself.",false,A02,40);
		P6 = new Puzzle("Stamp",5,"Stamp","I sit in a corner while traveling around the world. What am I?","Congratulations! You passed the test you may proceed.","Eh doesn't hurt to come back in a bit.","25 cents for a sticker?!",false,null,50);
		P7 = new Puzzle("Breath",6,"Breath","I'm light as a feather, yet the strongest man can't hold me for more than 5 minutes. What am I?","Congratulations! You got a Gold Coin for your troubles.","You should really have entertained the Romanian beauty, she was really nice. Oh, well, that just cost you 5 points.","Water is not good for the lungs.",false,A03,65);
		P8 = new Puzzle("Telephone",7,"Telephone","You answer me, although I never ask you questions. What am I?","Congrats, you just acquired 10 gold coins to add to your collection","Too much dead air, I'll move on for now.","Ring ring, who is it?",false,A11,70);
		//I said the answer is skull!
		
		Monsters e00 = new Monsters(0, "Train Lackey", A01, 5, .95, "A slender Train Lackey holds a wrench in front of you what shall you do?", "You got the copper coin from the pocket of the knocked out lackey! RECIEVED: Copper Coin", "The Lackey can live another day.");
		Monsters e01 = new Monsters(1, "Train Engineer", A02, 10, .85, "A grease monkey appears in front of you, it must be a Train Engineer.", "You got the silver coin that the engineer dropped!", "Eh, I don't want to get any oil on my clothes today, I just stole these.");
		Monsters e02 = new Monsters(2, "Mechanic", A07, 15, .80, "A mildly clean man in overalls stands before me, he looks a bit smart, I'll have to take him head on.", "The engineer gave you his snakeskin oil, and ran away, strange lot they are...", "Those glasses are throwing me off a bit, I'll leave for now.");
		Monsters e03 = new Monsters(3, "Shorty Pants", A04, 50, .65, "", "You got the short pants?!", "You'll get 'em next time.");
		Monsters e04 = new Monsters(4, "Rival Robber", A03, 15, .85, "Ah a business rival, I don't think this rival robber has a chance against me.", "It appears that this thief was fortuitous enough to have a gold coin on his persons.", "I'll get the slimy sucker later, he's infringing on my business.");
		Monsters e05 = new Monsters(5, "Bouncer", A05, 15, .75, "Short, buff dude, this bouncer won't get the best of me", "The bouncer dropped a revolver, strange he didn't use it, must be something to it.", "This ankle-biter ain't worth it for now.");
		Monsters e06 = new Monsters(6, "Bodyguard", A07, 20, .70, "I want this kind of bodyguard on my side when I make it big.", "What's this guy doing with a bottle of snakeskin stuffs", "I'll take this guy on later.");
		Monsters e07 = new Monsters(7, "CEO of Sunnydale, Inc.", A09, 100, .50, "", "My oh my, quite a fancy item you have you Mr.CEO, that'll fetch a nice price.", "");
			
		Rooms C1_U, C1U_STE_1, C1U_BA_1, C1U_STE_2, C1U_PASS_1, C1U_BA_2, C1_L,
		C1L_KT_1, C1L_DIN_1, C1L_BA_3, C2_U, C2U_BA_4, C2U_STE_3, C2U_STE_4, C2U_BA_5,
		C2_L, C2L_BA_6, C2L_STE_10, C2L_STE_11, C2L_SIT_12, C3_U, C3U_BAR, C3U_LG_1,
		C3U_LG_2, C3U_BA_7, C3_L, C3L_COAL_RM, C3L_RM, C3_STF_2, C3U_BA_8;

		C1_U = new Rooms(0, "Upper Hallway 1", "You are in the upper hallway of the first car. \nPlenty to get pillage through up here. \nLet's see, to the left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. \nTo the right is the Passenger Seating to watch a movie, and a guest bathroom. \nWhere do you want to go first?",null,null,null,false);
		C1U_STE_1 = new Rooms(1, "Master Bedroom Suite", "Sweet!  The Master Bedroom Suite, there are two large beds to your left and your right. \nThere appears to be some jewelry on the left bed, and a sparkly item underneath the pillow on the right bed. \nThe room appears deserted, but there seems to be some kind of noise coming from around the room.",null,null,A06,false);
		C1U_BA_1 = new Rooms(2, "Bathroom 1", "You have entered the bathroom. Someone is in here. \nYo! Do you know how to knock first? That's rude. \nAnd I don't like rude people so...time to meet your maker!",null,e00,A01,false);
		C1U_STE_2 = new Rooms(3, "Bedroom Suite 2", "Nice little bedroom for the back of the train.  \nIt has one bed to the right of you. There might be something in there. \nYou also see a dresser to the left, there appears to be a piece of paper attached to it. \nWill you answer the riddle?",P1,null,A01,false);
		C1U_PASS_1 = new Rooms(4, "Passenger Seating", "Ah, they’re playing your favorite movie in the Passenger Seating area, Ocean's Eleven. \nThere are seats to your right and left. \nYou could sit a finish the movie, but you'd be wasting precious time. \nYou notice someone staring at you from the corner of your eye. \nHe stands between you and the door to the 2nd car. \nThere's also a bathroom you could hide in for awhile if that's your thing.",null,e00,A01,false);
		C1U_BA_2 = new Rooms(5, "Bathroom 2", "I hope you have to use the bathroom because there's nothing else in here to do. \nPick a better place to pillage next time won't you.",null,null,null,false);
		C1_L = new Rooms(6, "Lower Hallway 1", "Okay, you made it safely onto the train without a hitch. \nNow its time to go to work finding the loot. \nOn your right is the kitchen. \nBound to be a weapon in there you could use to defend yourself in case \nsomeone recognizes you from American's Most Wanted show last month. \nA safer route maybe the Dining Room Area to grab a bit to eat. \nMaybe you should head to the bathroom to freshen up....it may be a bumpy ride.",null,null,null,true);
		C1L_KT_1 = new Rooms(7, "Kitchen", "You walked into the kitchen where there appears to be spoons, forks, and other various utensils. \nThere lies a riddle on the cutting table, will you answer it?",P2,null,A07,false);
		C1L_DIN_1 = new Rooms(8, "Dining Room", "Something really smells good in here.  You're in a wide area with plenty of tables around, \nthis must be the dining room, there appears to be someone sitting \nat a table minding his own business. \nHe is holding something very valuable that you could really \nuse on your quest, shall you engage, or move on?",null,e00,A01,false);
		C1L_BA_3 = new Rooms(9, "Bathroom 3", "Why in the world did you come in here? \nThere is an extremely angered and ornery man of about less than average height. \nGet ready for a fight, he won't give up his porcelain throne so easily.",null,e03,null,false);
		C2_U = new Rooms(10, "Upper Hallway 2", "Now you're getting somewhere. \nLook around take it all in. \nWhere to now?",null,null,null,false);
		C2U_BA_4 = new Rooms(11, "Bathroom 4", "ARGHHHH!!!! OCCUPIED!!! You interrupted a rival train robber doing his business. \nHis pants are at his ankles but a fight would still seem in his favor. \nYou quickly scan the room for any object to give you the advantage. \nToilet paper, no. Hand soap, no. A plunger is resting underneath the sink. \nDo you grab it and fight for your life or run back into the hallway in hopes of finding a hiding place?",null,e04,A03,false);
		C2U_STE_3 = new Rooms(12, "Bedroom Suite 3", "This bedroom has not been used for a while, looks more like an old creepy storage closet. \nDust has collected on everything, extra furniture and decorations just thrown about. \nI wonder why they have not used this bedroom recently. \nBefore exiting you notice a small hole that has developed in the corner, \na Man is seemingly standing guard in front of the hole. \nYou can hear loud deep bass music coming from the other side of the wall, \nprobably one of those train diskotechs. \nDo you go and inspect the Bouncer or return to the hallway?",null,e05,null,false);
		C2U_STE_4 = new Rooms(13, "Bedroom Suite 4", "This bedroom looks promising. \nNice comfortable sleeper sofa, full size bed. \nIt even has a marble round table with what looks like a wallet lying on top. \nWait a minute, what is that stack of green in the corner by the wicker dresser? \nIt looks to be a stack of $100 bills. No, it’s a special riddle to open the safe next to the bed. \nYou think you hear someone in the next room. \nDo you stay and crack the safe or get out while you have the chance?",P4,null,null,false);
		C2U_BA_5 = new Rooms(14, "Bathroom 5", "Almost there, but time for a pit stop. \nAll this running through the train has got you hot and sweaty. \nSweat equals funk! Nasty! Hope in the grey porcelain shower to cool off. \nMuch better!  Wait...is this door looked from the outside? \nNo, there's a riddle combination lock to get out of here. \nYou can try to solve it or just kick down the door...but that may lead to trouble.",P5,null,A02,false);
		C2_L = new Rooms(15, "Lower Hallway 2", "Well done, you have successfully made it to the second car! \nMoving right along. Lets see what goodies are lying around in here. \nThis is odd!  Is this what I think it is?  Yep, it’s a sack of gold coins encased in a riddle box. \nAre you going to solve it or leave it be?  This room looks like there's a lot more loot laying are round than that.",P8,null,A02,false);
		C2L_BA_6 = new Rooms(16, "Bathroom 6", "This is a very nice bathroom to be on a train.  \nThe shower stall to your left looks like it has fine Italian marble tiles on the floor. \nThere’s a tempered glass medicine cabinet above the sink to your right.  \nWait!  What is that shiny piece of metal reflecting off the mosaic shower curtain?  \nJust as you reach to slide back the shower curtain out jumps CEO of SunnyDale Inc...  \nThat shiny piece of metal turns out to be an old fashion razor blade.  And he is posed for a fight. \nDo you stay and fight? Act like your lost and try to quick exit the room? ",null,e07,null,false);
		C2L_STE_10 = new Rooms(17, "Bedroom Suite 5", "O.K., another Bedroom Suite. There are twin beds to your left and right. \nTucked halfway under the bed on the right is a briefcase. \nThere’s bound to be some loot in it.  Suddenly you hear footsteps coming your way. \nYou could grab the briefcase and hide under the bed till \nthe coast is clear or jump out of the window with the briefcase. \nYour only other option is to attack the person with the briefcase if they come in. \nWell?",null,e06,null,false);
		C2L_STE_11 = new Rooms(18, "Bedroom Suite 6", "Dang, all these Bedroom Suites. Where is the loot? \nThere are beds to your left and right. That’s it! Try another room.",null,null,null,false);
		C2L_SIT_12 = new Rooms(19, "Sitting Area", "Plenty of over-sized comfy couches in this Sitting Area. \nOne red, one blue. Sit on the blue one, it's empty at the moment. \nSurely you can afford to take a minute to catch your breath after everything you've been through on this train. \nAh, man...no rest for the weary. Here comes trouble. \nYou could give up now or take your chances with this incompetent individual. \nWhat's it going to be?",null,e06,null,false);
		C3_U = new Rooms(20, "Upper Hallway 3", "Can you believe it....you can practically taste the gold you're so close. \nYou just need to scout out a few more rooms before you're home free. \nLet's see here.....",null,null,null,false);
		C3U_BAR = new Rooms(21, "Bar", "Looking around, this looks like a great place to stop. \nEveryone mingling at the bar having a great time. \nBartender is mixing up Boiler Makers. Yum! \nMight as well stop for a quick drink to blend in with the crowd. \nThe bartender, a Romanian beauty with long dark brown hair says \nshe’ll only serve you if you can solve a puzzle for her. \nAre you game?",P7,null,A03,false);
		C3U_LG_1 = new Rooms(22, "Lounge 1", "You’ve set your sights on the Member’s Only Lounge. It has plush velvety lazy boy reclining seats. A 50-inch flat screen TV on the wall to your right.  Complimentary champagne on top of the curio cabinet to your left.  Do you enter the lounge and waste precious time? Do you make your way through the rest of the train and stop playing around.",null,null,null,false);
		C3U_LG_2 = new Rooms(23, "Lounge 2", "You are in the General Lounge for all passengers. \nTry your best to blend in. There is one open chair for you to sit down in to your left. \nTo your right is the restroom. Suddenly you notice an odd looking fellow charging at you. \nYou can stay and fight, hide in the restroom, \nor make a run for stairs either in front of you or behind you. ", null, e00, A01, false);
		C3U_BA_7 = new Rooms(24, "Bathroom 7", "The bathroom is not the safest place to hide. \nThere is no other way out of this room. You have just lost 15 points. \nYou must now face the ugly dude that's been watching you since the last train car. \nWho is now banging on the door outside?",null,null,null,false);
		C3_L = new Rooms(25, "Lower Hallway 3", "Well it is about time. Took you long enough. \nNow where exactly is the jackpot? Let's check the ....",null,null,null,false);
		C3L_COAL_RM = new Rooms(26, "Coal Room", "Man, Oh Man...who knew this would be easy. \nNow its becoming hazardous to your health, \nbreathing in all this toxic air from inside the coal room. \nThere's got to be something more than mounds of black, dirty coal in here. \nYou spot what look to be a golf ball size diamond perched up on the coverer belt to your left. \nBut to your right is the Train Engineer standing in your way. \nThat diamond maybe just too valuable to pass up...or is it?",null,e01,A02,false);
		C3L_RM = new Rooms(27, "Engine Room", "JACKPOT!!!! Finally, you have reached the mother load \nand you are almost home free. Only thing stopping you is one pissed of engine Mechanic. \nHis whole purpose in life is to guard the door that’s guarding the loot. \nYou didn't come all this way for nothing did you? \nWell, did you?",null,e02,null,false);
		C3_STF_2 = new Rooms(28, "Staff Lounge", "One of the train staff bragged about a very rare artifact \nshe hid in this room since no one ever cleans up in here. It is worth millions! You have only a few minutes \nto look for it before you are detected by the staff. \nYou can stay and search for the artifact or \nexit through the door and continue up the train.",P3,null,null,false);
		C3U_BA_8 = new Rooms(29, "Bathroom 8", "People always hide the weirdest things in bathrooms. \nI guess a train bathroom is no different. \nWhat do we have here? The rare Mother of Pearl bracelet. \nHowever you need to so answer this question before you can get it out of its case. ",P6,null,null,false);
		 
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
		
		//UPPER LEVEL CAR 1 EXITS
		C1_U.setExit(1, C1U_STE_1);
		C1_U.setExit(2, C1U_BA_1);
		C1_U.setExit(3, C1U_STE_2);
		C1_U.setExit(4, C1U_PASS_1);
		C1_U.setExit(6, C1_L);
		C1U_STE_1.setExit(0, C1_U);
		C1U_BA_1.setExit(0, C1_U);
		C1U_STE_2.setExit(0, C1_U);
		C1U_PASS_1.setExit(0, C1_U);
		C1U_PASS_1.setExit(5, C1U_BA_2);
		C1U_PASS_1.setExit(10, C2_U);
		C1U_BA_2.setExit(0, C1_U);
		
		//LOWER LEVEL CAR 1 EXITS
		C1_L.setExit(0, C1_U);
		C1_L.setExit(7, C1L_KT_1);
		C1_L.setExit(8, C1L_DIN_1);		
		C1L_KT_1.setExit(6, C1_L);		
		C1L_DIN_1.setExit(6, C1_L);
		C1L_DIN_1.setExit(0, C1_U);
		C1L_DIN_1.setExit(9, C1L_BA_3);
		C1L_DIN_1.setExit(15, C2_L);
		C1L_BA_3.setExit(8, C1L_DIN_1);
		
		//UPPER LEVEL CAR 2 EXITS
		C2_U.setExit(0, C1_U);
		C2_U.setExit(11, C2U_BA_4);
		C2_U.setExit(12, C2U_STE_3);
		C2_U.setExit(13, C2U_STE_4);
		C2_U.setExit(14, C2U_BA_5);
		C2_U.setExit(20, C3_U);
		C2_U.setExit(15, C2_L);
		C2U_BA_4.setExit(10, C2_U);
		C2U_STE_3.setExit(10, C2_U);
		C2U_STE_4.setExit(10, C2_U);
		C2U_BA_5.setExit(10, C2_U);
		
		//LOWER LEVEL CAR 2 EXITS
		C2_L.setExit(8, C1L_DIN_1);
		C2_L.setExit(16, C2L_BA_6);
		C2_L.setExit(17, C2L_STE_10);
		C2_L.setExit(18, C2L_STE_11);
		C2_L.setExit(19, C2L_SIT_12);
		C2_L.setExit(25, C3_L);
		C2_L.setExit(10, C2_U);
		C2L_BA_6.setExit(15, C2_L);
		C2L_STE_10.setExit(15, C2_L);
		C2L_STE_11.setExit(15, C2_L);
		C2L_SIT_12.setExit(15, C2_L);
		
		//UPPER LEVEL CAR 3 EXITS
		C3_U.setExit(10, C2_U);
		C3_U.setExit(21, C3U_BAR);
		C3_U.setExit(22, C3U_LG_1);
		C3_U.setExit(23, C3U_LG_2);
		C3_U.setExit(24, C3U_BA_7);
		C3_U.setExit(25, C3_L);
		C3U_BAR.setExit(20, C3_U);
		C3U_LG_1.setExit(20, C3_U);
		C3U_LG_2.setExit(20, C3_U);
		C3U_BA_7.setExit(20, C3_U);
		
		//LOWER LEVEL CAR 3 EXITS
		C3_L.setExit(15, C2_L);
		C3_L.setExit(26, C3L_COAL_RM);
		C3_L.setExit(27, C3L_RM);
		C3_L.setExit(28, C3_STF_2);
		C3_L.setExit(29, C3U_BA_8);
		C3L_COAL_RM.setExit(25, C3_L);
		C3L_RM.setExit(25, C3_L);
		C3_STF_2.setExit(25, C3_L);
		C3U_BA_8.setExit(25, C3_L);

		//STARTING POINT OF GAME
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
