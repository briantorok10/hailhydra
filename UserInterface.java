import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**Class:
 * @author Chris Brown
 * @version 1.0
 * Course: ITEC 3860 Software Development I Section 01 Spring 2017
 * Written: April 6, 2017
 *
 * This class:
 *
 * Purpose:
 *
 */
@SuppressWarnings({"FieldCanBeLocal", "CanBeFinal"})
class UserInterface {

    /**Each type of description is stored in a string. Each particular string will be accessed and passed to the
     * display method. String names will be based the ID of the room, puzzle, item or command in which the
     * corresponds.
     *
     */

    private static String C1_U = "You in the upper hallway of the first car.  Plenty to get pillage through up here.  Let's " +
            "see, to" +
            "\nthe left is the Master Bedroom, Bathroom, and a secondary Bedroom Suite. To the right is the Passenger" +
            "\nSeating to watch a movie, and a guest bathroom. Where do you want to go first?";

    private static String C1U_STE_1 = "Sweet!  The Master Bedroom Suite, there are two large beds to your left and your right" +
            "." +
            " There " +
            "\nappears to be some jewelry on the left bed, and a sparkly item underneath the pillow on the right bed." +
            "\nThe room appears deserted, but there seems to be some kind of noise coming from around the room.";

    private static String C1U_BA_1 = "You have entered the bathroom. Someone is in here. \"Yo! Do you know how to knock " +
            "first?" +
            " That's" +
            "\nrude. And I don't like rude people so...time to meet your maker!";

    private static String C1U_STE_2 = "Nice little bedroom for the back of the train.  It has one bed to the right of you; " +
            "there " +
            "\nmight be something in there. You also see a dresser to the left, there appears to be a piece of paper" +
            "\nattached to it, will you answer the riddle? ";

    private static String C1U_PASS_1 = "Ah, they’re playing your favorite movie in the Passenger Seating area, Ocean's Eleven" +
            ". There" +
            "\nare seats to your right and left. You could sit a finish the movie, but you'd be wasting precious time."
            +"\nYou notice someone staring at you from the corner of your eye.  He stands between you and the door to"
            +"\nthe 2nd car. There's also a bathroom you could hide in for awhile if that's your thing.";

    private static String C1U_BA_2 = "I hope you have to use the bathroom because there's nothing else in here to do.  Pick a" +
            " better" +
            "\nplace to pillage next time won't you.";

    private static String C1_L = "Okay, you made it safely onto the train without a hitch.  Now its time to go to work " +
            "finding the" +
            "\nloot.  On your right is the kitchen.  Bound to be a weapon in there you could use to defend yourself " +
            "\nin case someone recognizes you from American's Most Wanted show last month.  A safer route maybe the " +
            "\nDining Room Area to grab a bit to eat. Maybe you should head to the bathroom to freshen up....it may " +
            "\nbe a bumpy ride.";

    private static String C1L_KT_1 = "You walked into the kitchen where there appears to be spoons, forks, and other various " +
            "utensils."
           + "\nThere lies a riddle on the cutting table, will you answer it?";

    private static String C1L_DIN_1 = "Something really smells good in here.  You're in a wide area with plenty of tables " +
            "around, " +
            "\nthis must be the dining room, there appears to be someone sitting at a table minding his own business." +
            "\nHe is holding something very valuable that you could really use on your quest, shall you engage, or " +
            "\nmove on?";

    private static String C1L_BA_3 = "Why in the world did you come in here?  There is an extremely angered and ornery man of" +
            " about" +
            "\nless than average height.  Get ready for a fight; he won't give up his porcelain throne so easily.";

    private static String C2_U = "Now you're getting somewhere.  Look around take it all in.  Where to now?";

    private static String C2U_BA_4 = "\"ARGHHHH!!!! OCCUPIED!!!\" You interrupted a rival train robber doing his business. " +
            "His pants" +
            "\nare at his ankles but a fight would still seem in his favor. You quickly scan the room for any object " +
            "\nto give you the advantage. Toilet paper, no. Hand soap, no. A plunger is resting underneath the sink. " +
            "\nDo you grab it and fight for your life or run back into the hallway in hopes of finding a hiding place?";

    private static String C2U_STE_3 = "This bedroom has not been used for a while, looks more like an old creepy storage " +
            "closet. Dust" +
            "\nhas collected on everything, extra furniture and decorations just thrown about. I wonder why they have" +
            "\nnot used this bedroom recently. Before exiting you notice a small hole that has developed in the " +
            "\ncorner, a Man is seemingly standing guard in front of the hole. You can hear loud deep bass music " +
            "\ncoming from the other side of the wall, probably one of those train discotheque. Do you go and inspect " +
            "\nthe Bouncer or return to the hallway?";

    private static String C2U_STE_4 = "This bedroom looks promising.  Nice comfortable sleeper sofa, full size bed.  It even " +
            "has a " +
            "\nmarble round table with what looks like a wallet lying on top. Wait a minute; what is that stack of " +
            "\ngreen in the corner by the wicker dresser?  It looks to be a stack of $100 bills.  No, it’s a special " +
            "\nriddle to open the safe next to the bed.  You think you hear someone in the next room.  Do you stay " +
            "\nand crack the safe or get out while you have the chance?";

    private static String C2U_BA_5 = "Almost there, but time for a pit stop. All this running through the train has got you " +
            "hot and" +
            "\nsweaty.  Sweat equals funk! Nasty! Hope in the grey porcelain shower to cool off.  Much better!  " +
            "\nWait...is this door looked for the outside? No, there's a riddle combination look to get out of here. " +
            "\nYou can try to solve it or just kick down the door...but that may lead to trouble.";

    private static String C2_L = "Well done, you have successfully made it to the second car! Moving right along. Lets see " +
            "what" +
            "\ngoodies are lying around in here.  This is odd!  Is this what I think it is?  Yep, it’s a sack of gold" +
            "\ncoins encased in a riddle box. Are you going to solve it or leave it be?  This room looks like there's" +
            "\na lot more loot laying are round than that.";

    private static String C2l_BA_6 = "This is a very nice bathroom to be on a train.  The shower stall to your left looks " +
            "like it " +
            "\nhas fine Italian marble tiles on the floor.  There’s a tempered glass medicine cabinet above the sink" +
            "\nto your right.  Wait!  What is that shiny piece of metal reflecting off the mosaic shower curtain?  " +
            "\nJust as you reach to slide back the shower curtain out jumps CEO of SunnyDale Inc..  That shiny piece " +
            "\nof metal turns out to be an old fashion razor blade.  And he is posed for a fight. Do you stay and " +
            "\nfight? Act like your lost and try to quick exit the room? ";

    private static String C2L_STE_10 = "O.K., another Bedroom Suite. There are twin beds to your left and right. Tucked " +
            "halfway " +
            "\nunder the bed on the right is a briefcase.  There’s bound to be some loot in it. Suddenly you hear" +
            "\nfootsteps coming your way.  You could grab the briefcase and hide under the bed till the coast is " +
            "\nclear or jump out of the window with the briefcase.  Your only other option is to attack the person " +
            "\nwith the briefcase if they come in.  Well?";

    private static String C2L_STE_11 = "Dang, all these Bedroom Suites. Where is the loot? There are beds to your left and " +
            "right. " +
            "\nThat’s it! Try another room.";

    private static String C2L_SIT_12 = "Plenty of over-sized comfy couches in this Sitting Area.  One red, one blue.  Sit on " +
            "the " +
            "\nblue one it empty at the moment.  Surly you can afford to take a minute to catch your breath after" +
            "\neverything you've been through on this train.  \"Ah, man...no rest for the weary. Here comes trouble." +
            "\nYou could give up now or take your chances with this incompetent individual. What's it going to be?";

    private static String C3_U = "Can you believe it....you can practically taste the gold you're so close.  You just need to" +
            " scout" +
           "\nout a few more rooms before you're home free.  Let's see here.....";

    private static String C3U_BAR = "Looking around, this looks like great place to stop. Everyone mingling at the bar have a" +
            " great" +
           "\ntime.  Bartender is mix up Boiler Makers.  \"Yum!\" Might as well stop for a quick drink to blend in " +
           "\nwith the crowd.  The bartender, a Romanian beauty with long dark brown hair  says she’ll only serve " +
           "\nyou if you can solve a puzzle for her.  Are you game?";

    private static String C3U_LG_1 = "You’ve set your sights on the Member’s Only Lounge. It has plush velvety lazy boy " +
            "reclining" +
           "\nseats. A 50-inch flat screen TV on the wall to your right.  Complimentary champagne on top of the curio" +
           "\ncabinet to your left.  Do you enter the lounge and waste precious time? Do you make your way through " +
           "\nthe rest of the train and stop playing around.";

    private static String C3U_LG_2 = "You are in the General Lounge for all passengers.  Try your best to blend in.  There is" +
            " one" +
           "\nopen chair for you to seat down in to your left. To your right is the restroom. Suddenly you notice an " +
           "\nodd looking fellow charging at you.  You can stay and fight.  Hide in the restroom or make a run for " +
           "\nstairs either in front of you or behind you. ";

    private static String C3U_BA_7 = "The bathroom is not the safest place to hide. There is no other way out of this room. " +
            "You " +
           "\nhave just lost “15” points.  You must now face the ugly dude that's been watching you since the last" +
           "\ntrain car.  Who is now banging on the door outside?";

    private static String C3_L = "Well it is about time.  Took you long enough.  Now where exactly is the jackpot? Let's " +
            "check" +
           "\nthe ....";

    private static String C3L_COAL_RM = "Man, Oh Man...you knew this would be easy.  Now its becoming hazardous to your " +
            "health," +
           "\nbreathing in all this toxic air from inside the coal room.  There's got to be something more than " +
           "\nmounds of black, dirty coal in here.  You spot what look to be a golf ball size diamond perched up on " +
           "\nthe conveyor belt to your left.  But to your right is the Train Engineer standing in your way.  That " +
           "\ndiamond maybe just to valuable to pass up...or is it?";

    private static String C3L_RM = "JACKPOT!!!! Finally, you have reached the mother load and you are almost home free. Only " +
            "thing " +
           "\nstopping you is one pissed of engine Mechanic.  His whole purpose in life is to guard the door that’s " +
           "\nguarding the loot.  You didn't come all this way for nothing did you?  Well, did you?";

    private static String C3_STF_2 = "One of the train staff bragged about a very rare artifact she hide in this room since " +
            "no one" +
           "\never cleans up in here. It is worth millions! You have only a few minutes to look for it before your " +
           "\ndetected by the staff. You can stay and search for the artifact or exit through the door and continue " +
           "\nup the train.";

    private static String C3U_BA_8 = "People always hide the weirdest things in bathrooms. I guess a train bathroom is no " +
            "different." +
           "\nWhat do we have here?  The rare Mother of Pearl bracelet.  However you need to so answer this question" +
           "\n before you can get it out of its case. ";

    private static String C1_Uname = "Upper Hallway 1";
    private static String C1U_STE_1name = "Master Bedroom Suite";
    private static String C1U_BA_1name = "Bathroom 1";
    private static String C1U_STE_2name = "Bedroom Suite 2";
    private static String C1U_PASS_1name = "Passenger Seating";
    private static String C1U_BA_2name = "Bathroom 2";
    private static String C1_Lname = "Lower Hallway 1";
    private static String C1L_KT_1name = "Kitchen";
    private static String C1L_DIN_1name = "Dining Room";
    private static String C1L_BA_3name = "Bathroom 3";
    private static String C2_Uname = "Upper Hallway 2";
    private static String C2U_BA_4name = "Bathroom 4";
    private static String C2U_STE_3name = "Bedroom Suite 3";
    private static String C2U_STE_4name = "Bedroom Suite 4";
    private static String C2U_BA_5name = "Bathroom 5";
    private static String C2_Lname = "Lower Hallway 2";
    private static String C2L_BA_6name = "Bathroom 6";
    private static String C2L_STE_10name = "Bedroom Suite 5";
    private static String C2L_STE_11name = "Bedroom Suite 6";
    private static String C2L_SIT_12name = "Sitting Area";
    private static String C3_Uname = "Upper Hallway 3";
    private static String C3U_BARname = "Bar";
    private static String C3U_LG_1name = "Lounge 1";
    private static String C3U_LG_2name = "Lounge 2";
    private static String C3U_BA_7name = "Bathroom 7";
    private static String C3_Lname = "Lower Hallway 3";
    private static String C3L_COAL_RMname = "Coal Room";
    private static String C3L_RMname = "Engine Room";
    private static String C3_STF_2name = "Staff Lounge";
    private static String C3U_BA_8name = "Bathroom 8";

    private static String E00 = "Train Lackey";
    private static String E03 = "Shorty Pants";
    private static String E04 = "Rival Robber";
    private static String E05 = "Bouncer";
    private static String E07 = "CEO of SunnyDale Inc.";
    private static String E06 = "Bodyguard";
    private static String E01 = "Train Engineer";
    private static String E02 = "Mechanic";

    private static String E00Enter = "A slender Train Lackey holds a wrench in front of you, what shall you do?";
    private static String E00Win = "You got the copper coin from the pocket of the knocked out lackey!";
    private static String E00Exit = "The Lackey can live another day.";
    private static String E01Enter = "A grease monkey appears in front of you, it must be a Train Engineer.";
    private static String E01Win = "You got the silver coin that the engineer dropped!";
    private static String E01Exit = "Eh, I don't want to get any oil on my clothes today, I just stole these.";
    private static String E02Enter = "A mildly clean man in overalls stands before me, he looks a bit smart, I'll have to " +
            "\ntake him head on.";
    private static String E02Win = "The engineer gave you his snakeskin oil, and ran away, strange lot they are...";
    private static String E02Exit = "Those glasses are throwing me off a bit, I'll leave for now.";
    private static String E03Enter = "";
    private static String E03Win = "You got the short pants?!";
    private static String E03Exit = "You'll get 'em next time.";
    private static String E04Enter = "Ah a business rival, I don't think this rival robber has a chance against me.";
    private static String E04Win = "It appears that this thief was fortuitous enough to have a gold coin on his persons.";
    private static String E04Exit = "I'll get the slimy sucker later, he's infringing on my business.";
    private static String E05Enter = "Short, buff dude, this bouncer won't get the best of me.";
    private static String E05Win = "The bouncer dropped a revolver, strange he didn't use it, must be something to it.";
    private static String E05Exit = "This ankle-biter ain't worth it for now.";
    private static String E06Enter = "I want this kind of bodyguard on my side when I make it big.";
    private static String E06Win = "What's this guy doing with a bottle of snakeskin stuffs?";
    private static String E06Exit = "I'll take this guy on later.";
    private static String E07Enter = "";
    private static String E07Win = "My oh my, quite a fancy item you have you Mr. CEO, that'll fetch a nice price.";



    private static String A01 = "Copper Coin";
    private static String A02 = "Silver Coin";
    static String A07 = "Snakeskin Oil";
    static String A04 = "Short Pants;";
    private static String A03 = "Gold Coin";
    static String A05 = "Revolver";
    static String A09 = "Queen Elizabeth's Diamond Broach";
    static String A06 = "Crystal Skull";
    static String A08 = "Conductor's Key";
    static String A10 = "Miniscule Kitchen Knife";

    private static String A01Description = "A coin made of copper that holds a small value.";
    private static String A02Description = "A coin made of silver that holds a medium value.";
    private static String A03Description = "A coin made of pure gold that holds a high value";
    private static String A04Description = "Incredibly short pants. This will be found when fighting the Shorty Pants" +
            "\nmonster and will allow you to progress forward.";
    private static String A05Description = "A 6 shot Revolver.";
    static String A06Description = "Skull made of pure crystal. Has a sort of mystical glow about it. When you stare"
            + "\ndeep into the eyes of the skull you can hear the voices of ancient beings calling you to the" +
            "\nother side.";
    static String A07Description = "There's a snake in my boot!";
    private static String A08Description = "Use this key to gain access to an area on the train.";
    private static String A09Description = "Queen Elizabeth of England's priceless diamond broach. Worth and extremely" +
            "\nlarge sum of money to the right buyer. Useless otherwise.";
    private static String A10Description = "An extremely small knife maybe used for cutting carrots. Could be weapon" +
            "\nagainst small mice.";

    private static String PUZ_1 = "Coin";
    private static String PUZ_2 = "Food";
    private static String PUZ_3 = "Dessert";
    private static String PUZ_4 = "Key";
    private static String PUZ_5 = "History";
    private static String PUZ_6 = "Stamp";
    private static String PUZ_7 = "Breath";
    private static String PUZ_8 = "Telephone";

    private static String PUZ_1Question = "What has a head and a tail, but no body?";
    private static String PUZ_1Hint = "Small, round and jingles in your pocket.";
    private static String PUZ_1Solved = "Congratulations you received Copper Coin for solving the puzzle.";
    private static String PUZ_1Wrong = "This riddle ain't worth a cent of my time.";
    private static String PUZ_1Answer = "Coin";
    private static String PUZ_2Question = "What has to broken before you can use it?";
    private static String PUZ_2Hint = "Golden Goose.";
    private static String PUZ_2Solved = "Congratulations you got the miniscule kitchen knife for solving the puzzle.";
    private static String PUZ_2Wrong = "Ah well I might come back later, it's not like its too important.";
    private static String PUZ_2Answer = "Egg";
    private static String PUZ_3Question = "What has no beginning, end, or middle?";
    private static String PUZ_3Hint = "Policeman's favorite food.";
    private static String PUZ_3Solved = "Congratulations you passed the test and you may proceed.";
    private static String PUZ_3Wrong = "There might be a delicacy behind this riddle, but it may just not be the time or" +
            "\nfor such things.";
    private static String PUZ_3Answer = "Doughnut";
    private static String PUZ_4Question = "What force and strength cannot get through, I with my unique teeth can do. What" +
            "\nam I?";
    private static String PUZ_4Hint = "The only way to a door's heart.";
    private static String PUZ_4Solved = "Nice work, you got the Conductor's Key for solving the puzzle.";
    private static String PUZ_4Wrong = "I know there's some kind of trick to this puzzle, I'll come back later.";
    private static String PUZ_4Answer = "Key";
    private static String PUZ_5Question = "You will always find me in the past. I can be created in the present, but the" +
            "\nfuture can never taint me. What am I?";
    private static String PUZ_5Hint = "...repeats itself.";
    private static String PUZ_5Solved = "Congratulations you got the Silver Coin for solving the puzzle.";
    private static String PUZ_5Wrong = "Well to my prior knowledge, sometimes its just not worth losing on this kind of" +
            "\ngamble. I just lost a 2 points.";
    private static String PUZ_5Answer = "History";
    private static String PUZ_6Question = "I sit in a corner while traveling around the world. What am I?";
    private static String PUZ_6Hint = "25 cents for a sticker?!";
    private static String PUZ_6Solved = "Congratulations you passed the test you may proceed.";
    private static String PUZ_6Wrong = "Eh doesn't hurt to come back in a bit.";
    private static String PUZ_6Answer = "Stamp";
    private static String PUZ_7Question = "I'm light as a feather, yet the strongest man can't hold me for more than 5" +
            "\nminutes. What am I?";
    private static String PUZ_7Hint = "Water is not good for the lungs.";
    private static String PUZ_7Solved = "Congratulations you got a Gold coin for your troubles.";
    private static String PUZ_7Wrong = "You should really have entertained the Romanian beauty. She was really nice. Oh," +
            "\nwell, that just cost you 5 points/2 gold coins.";
    private static String PUZ_7Answer = "Breath";
    private static String PUZ_8Question = "You answer me, although I never ask you questions. What am I?";
    private static String PUZ_8Hint = "Ring ring, who is it?";
    private static String PUZ_8Solved = "Congrats, you just acquired 10 gold coins to add to your collection.";
    private static String PUZ_8Wrong = "Too much dead air, I'll move on for now.";
    private static String PUZ_8Answer = "Telephone";

    static ArrayList<String> roomList = new ArrayList<>();

    static void displayRoom(String roomID) {

        System.out.println("");
        if (Objects.equals(roomID, "C1_U")) {
            System.out.println(C1_Uname);
            System.out.println(C1_U);
        }

        if (Objects.equals(roomID, "C1U_STE_1")) {
            System.out.println(C1U_STE_1name);
            System.out.println(C1U_STE_1);
        }

        if (Objects.equals(roomID, "C1U_BA_1")) {
            System.out.println(C1U_BA_1name);
            System.out.println(C1U_BA_1);
        }

        if (Objects.equals(roomID, "C1U_STE_2")) {
            System.out.println(C1U_STE_2name);
            System.out.println(C1U_STE_2);
        }

        if (Objects.equals(roomID, "C1U_PASS_1")) {
            System.out.println(C1U_PASS_1name);
            System.out.println(C1U_PASS_1);
        }

        if (Objects.equals(roomID, "C1U_BA_2")) {
            System.out.println(C1U_BA_2name);
            System.out.println(C1U_BA_2);
        }

        if (Objects.equals(roomID, "C1_L")) {
            System.out.println(C1_Lname);
            System.out.println(C1_L);
        }

        if (Objects.equals(roomID, "C1L_KT_1")) {
            System.out.println(C1L_KT_1name);
            System.out.println(C1L_KT_1);
        }

        if (Objects.equals(roomID, "C1L_DIN_1")) {
            System.out.println(C1L_DIN_1name);
            System.out.println(C1L_DIN_1);
        }

        if (Objects.equals(roomID, "C1L_BA_3")) {
            System.out.println(C1L_BA_3name);
            System.out.println(C1L_BA_3);
        }

        if (Objects.equals(roomID, "C2_U")) {
            System.out.println(C2_Uname);
            System.out.println(C2_U);
        }

        if (Objects.equals(roomID, "C2U_BA_4")) {
            System.out.println(C2U_BA_4name);
            System.out.println(C2U_BA_4);
        }

        if (Objects.equals(roomID, "C2U_STE_3")) {
            System.out.println(C2U_STE_3name);
            System.out.println(C2U_STE_3);
        }

        if (Objects.equals(roomID, "C2U_STE_4")) {
            System.out.println(C2U_STE_4name);
            System.out.println(C2U_STE_4);
        }

        if (Objects.equals(roomID, "C2U_BA_5")) {
            System.out.println(C2U_BA_5name);
            System.out.println(C2U_BA_5);
        }

        if (Objects.equals(roomID, "C2_L")) {
            System.out.println(C2_Lname);
            System.out.println(C2_L);
        }

        if (Objects.equals(roomID, "C2L_BA_6")) {
            System.out.println(C2L_BA_6name);
            System.out.println(C2l_BA_6);
        }

        if (Objects.equals(roomID, "C2L_STE_10")) {
            System.out.println(C2L_STE_10name);
            System.out.println(C2L_STE_10);
        }

        if (Objects.equals(roomID, "C2L_STE_11")) {
            System.out.println(C2L_STE_11name);
            System.out.println(C2L_STE_11);
        }

        if (Objects.equals(roomID, "C2L_SIT_12")) {
            System.out.println(C2L_SIT_12name);
            System.out.println(C2L_SIT_12);
        }

        if (Objects.equals(roomID, "C3_U")) {
            System.out.println(C3_Uname);
            System.out.println(C3_U);
        }

        if (Objects.equals(roomID, "C3U_BAR")) {
            System.out.println(C3U_BARname);
            System.out.println(C3U_BAR);
        }

        if (Objects.equals(roomID, "C3U_LG_1")) {
            System.out.println(C3U_LG_1name);
            System.out.println(C3U_LG_1);
        }

        if (Objects.equals(roomID, "C3U_LG_2")) {
            System.out.println(C3U_LG_2name);
            System.out.println(C3U_LG_2);
        }

        if (Objects.equals(roomID, "C3U_BA_7")) {
            System.out.println(C3U_BA_7name);
            System.out.println(C3U_BA_7);
        }

        if (Objects.equals(roomID, "C3_L")) {
            System.out.println(C3_Lname);
            System.out.println(C3_L);
        }

        if (Objects.equals(roomID, "C3L_COAL_RM")) {
            System.out.println(C3L_COAL_RMname);
            System.out.println(C3L_COAL_RM);
        }

        if (Objects.equals(roomID, "C3L_RM")) {
            System.out.println(C3L_RMname);
            System.out.println(C3L_RM);
        }

        if (Objects.equals(roomID, "C3_STF_2")) {
            System.out.println(C3_STF_2name);
            System.out.println(C3_STF_2);
        }

        if (Objects.equals(roomID, "C3U_BA_8")) {
            System.out.println(C3U_BA_8name);
            System.out.println(C3U_BA_8);
        }
    }

    static ArrayList setRoomList(String roomID) {
        if (Objects.equals(roomID, "C1_U")) {
            roomList.add("Bedroom Suite 2");
            roomList.add("Bathroom 1");
            roomList.add("Master Bedroom Suite");
            roomList.add("Passenger Seating");
            roomList.add("Bathroom 2");
            roomList.add("Lower Hallway 1");
            roomList.add("Upper Hallway 2");
        }

        if (Objects.equals(roomID, "C1U_STE_1")) {
            roomList.add("Upper Hallway 1");
        }

        if (Objects.equals(roomID, "C1U_BA_1")) {
            roomList.add("Upper Hallway 1");
        }

        if (Objects.equals(roomID, "C1U_STE_2")) {
            roomList.add("Upper Hallway 1");
        }

        if (Objects.equals(roomID, "C1U_PASS_1")) {
            roomList.add("Upper Hallway 1");
        }

        if (Objects.equals(roomID, "C1U_BA_2")) {
            roomList.add("Upper Hallway 1");
        }

        if (Objects.equals(roomID, "C1_L")) {
            roomList.add("Kitchen");
            roomList.add("Dining Room");
            roomList.add("Bathroom 3");
            roomList.add("Upper Hallway 1");
            roomList.add("Lower Hallway 2");
        }

        if (Objects.equals(roomID, "C1L_KT_1")) {
            roomList.add("Lower Hallway 1");
        }

        if (Objects.equals(roomID, "C1L_DIN_1")) {
            roomList.add("Upper Hallway 1");
            roomList.add("Lower Hallway 1");
        }

        if (Objects.equals(roomID, "C1L_BA_3")) {
            roomList.add("Lower Hallway 1");
        }

        if (Objects.equals(roomID, "C2_U")) {
            roomList.add("Bathroom 4");
            roomList.add("Bedroom Suite 3");
            roomList.add("Bedroom Suite 4");
            roomList.add("Bathroom 5");
            roomList.add("Lower Hallway 2");
            roomList.add("Upper Hallway 1");
            roomList.add("Upper Hallway 3");
        }

        if (Objects.equals(roomID, "C2U_BA_4")) {
            roomList.add("Upper Hallway 2");
        }

        if (Objects.equals(roomID, "C2U_STE_3")) {
            roomList.add("Upper Hallway 2");
        }

        if (Objects.equals(roomID, "C2U_STE_4")) {
            roomList.add("Upper Hallway 2");
        }

        if (Objects.equals(roomID, "C2U_BA_5")) {
            roomList.add("Upper Hallway 2");
        }

        if (Objects.equals(roomID, "C2_L")) {
            roomList.add("Bathroom 6");
            roomList.add("Bedroom Suite 5");
            roomList.add("Bedroom Suite 6");
            roomList.add("Sitting Area");
            roomList.add("Upper Hallway 2");
        }

        if (Objects.equals(roomID, "C2L_BA_6")) {
            roomList.add("Lower Hallway 2");
        }

        if (Objects.equals(roomID, "C2L_STE_10")) {
            roomList.add("Lower Hallway 2");
        }

        if (Objects.equals(roomID, "C2L_STE_11")) {
            roomList.add("Lower Hallway 2");
        }

        if (Objects.equals(roomID, "C2L_SIT_12")) {
            roomList.add("Lower Hallway 2");
            roomList.add("Upper Hallway 2");
        }

        if (Objects.equals(roomID, "C3_U")) {
            roomList.add("Bar");
            roomList.add("Lounge 1");
            roomList.add("Lounge 2");
            roomList.add("Bathroom 7");
            roomList.add("Upper Hallway 3");
            roomList.add("Upper Hallway 2");
        }

        if (Objects.equals(roomID, "C3U_BAR")) {
            roomList.add("Upper Hallway 3");
        }

        if (Objects.equals(roomID, "C3U_LG_1")) {
            roomList.add("Upper Hallway 3");
        }

        if (Objects.equals(roomID, "C3U_LG_2")) {
            roomList.add("Bathroom 7");
            roomList.add("Lower Hallway 3");
            roomList.add("Upper Hallway 3");
        }

        if (Objects.equals(roomID, "C3U_BA_7")) {
            roomList.add("Upper Hallway 3");
        }

        if (Objects.equals(roomID, "C3_L")) {
            roomList.add("Coal Room");
            roomList.add("Engine Room");
            roomList.add("Staff Lounge");
            roomList.add("Bathroom 8");
        }

        if (Objects.equals(roomID, "C3L_COAL_RM")) {
            roomList.add("Lower Hallway 3");
        }

        if (Objects.equals(roomID, "C3L_RM")) {
            roomList.add("Lower Hallway 3");
        }

        if (Objects.equals(roomID, "C3_STF_2")) {
            roomList.add("Lower Hallway 3");
        }

        if (Objects.equals(roomID, "C3U_BA_8")) {
            roomList.add("Lower Hallway 3");
            roomList.add("Upper Hallway 3");
        }
        return roomList;
    }

    static int displayRooms(ArrayList roomList) {
        for (int i = 0; i < roomList.size(); i++) {
            System.out.println(i + ": " + roomList.get(i));
        }
    }

    static boolean displayMonsterEnter(String roomID) {
        boolean monsterFlag;
        System.out.println("");
        if (Objects.equals(roomID, "C1U_BA_1") || Objects.equals(roomID, "C1U_PASS_1") || Objects.equals(roomID, "C1L_DIN_1") || Objects.equals(roomID, "C3U_LG_2")) {
            System.out.println(E00);
            System.out.println(E00Enter);
            monsterFlag = true;
        }

        if (Objects.equals(roomID, "C3L_COAL_RM")) {
            System.out.println(E01);
            System.out.println(E01Enter);
            monsterFlag = true;
        }

        if (Objects.equals(roomID, "C3L_RM")) {
            System.out.println(E02);
            System.out.println(E02Enter);
            monsterFlag = true;
        }

        if (Objects.equals(roomID, "C1L_BA_3")) {
            System.out.println(E03);
            System.out.println(E03Enter);
            monsterFlag = true;
        }

        if (Objects.equals(roomID, "C2U_BA_4")) {
            System.out.println(E04);
            System.out.println(E04Enter);
            monsterFlag = true;
        }

        if (Objects.equals(roomID, "C2U_STE_3")) {
            System.out.println(E05);
            System.out.println(E05Enter);
            monsterFlag = true;
        }

        if (Objects.equals(roomID, "C2L_STE_10") || Objects.equals(roomID, "C2L_SIT_12")) {
            System.out.println(E06);
            System.out.println(E06Enter);
        }

        if (Objects.equals(roomID, "C2L_BA_6")) {
            System.out.println(E07);
            System.out.println(E07Enter);
            monsterFlag = true;
        }
        return monsterFlag;

    }

    static void displayMonsterWin(String roomID) {
        System.out.println("");
        if (Objects.equals(roomID, "C1U_BA_1") || Objects.equals(roomID, "C1U_PASS_1") || Objects.equals(roomID, "C1L_DIN_1") || Objects.equals(roomID, "C3U_LG_2")) {
            System.out.println(E00Win);
            System.out.println(A01);
            System.out.println(A01Description);
        }

        if (Objects.equals(roomID, "C3L_COAL_RM")) {
            System.out.println(E01Win);
            System.out.println(A02);
            System.out.println(A02Description);
        }

        if (Objects.equals(roomID, "C3L_RM")) {
            System.out.println(E02Win);
            System.out.println(A07);
            System.out.println(A07Description);
        }

        if (Objects.equals(roomID, "C1L_BA_3")) {
            System.out.println(E03Win);
            System.out.println(A04);
            System.out.println(A04Description);
        }

        if (Objects.equals(roomID, "C2U_BA_4")) {
            System.out.println(E04Win);
            System.out.println(A03);
            System.out.println(A03Description);
        }

        if (Objects.equals(roomID, "C2U_STE_3")) {
            System.out.println(E05Win);
            System.out.println(A05);
            System.out.println(A05Description);
        }

        if (Objects.equals(roomID, "C2L_STE_10") || Objects.equals(roomID, "C2L_SIT_12")) {
            System.out.println(E06Win);
            System.out.println(A07);
            System.out.println(A07Description);
        }

        if (Objects.equals(roomID, "C2L_BA_6")) {
            System.out.println(E07Win);
            System.out.println(A09);
            System.out.println(A09Description);
        }
    }

    static void displayMonsterExit(String roomID) {
        System.out.println("");
        if (Objects.equals(roomID, "C1U_BA_1") || Objects.equals(roomID, "C1U_PASS_1") || Objects.equals(roomID, "C1L_DIN_1") || Objects.equals(roomID, "C3U_LG_2")) {
            System.out.println(E00Exit);
        }

        if (Objects.equals(roomID, "C3L_COAL_RM")) {
            System.out.println(E01Exit);
        }

        if (Objects.equals(roomID, "C3L_RM")) {
            System.out.println(E02Exit);
        }

        if (Objects.equals(roomID, "C1L_BA_3")) {
            System.out.println(E03Exit);
        }

        if (Objects.equals(roomID, "C2U_BA_4")) {
            System.out.println(E04Exit);
        }

        if (Objects.equals(roomID, "C2U_STE_3")) {
            System.out.println(E05Exit);
        }

        if (Objects.equals(roomID, "C2L_STE_10") || Objects.equals(roomID, "C2L_SIT_12")) {
            System.out.println(E06Exit);
        }

        if (Objects.equals(roomID, "C2L_BA_6")) {
            System.out.println("");
        }

    }

    static boolean displayPuzzleName(String roomID) {
        boolean puzzleFlag;
        System.out.println("");
        if (Objects.equals(roomID, "C1U_STE_2")) {
            System.out.println(PUZ_1);
            puzzleFlag = true;
        }

        if (Objects.equals(roomID, "C1L_KT_1")) {
            System.out.println(PUZ_2);
            puzzleFlag = true;
        }

        if (Objects.equals(roomID, "C3_STF_2")) {
            System.out.println(PUZ_3);
            puzzleFlag = true;
        }

        if (Objects.equals(roomID, "C2U_STE_4")) {
            System.out.println(PUZ_4);
            puzzleFlag = true;
        }

        if (Objects.equals(roomID, "C2U_BA_5")) {
            System.out.println(PUZ_5);
            puzzleFlag = true;
        }

        if (Objects.equals(roomID, "C3U_BA_7")) {
            System.out.println(PUZ_6);
            puzzleFlag = true;
        }

        if (Objects.equals(roomID, "C3U_BAR")) {
            System.out.println(PUZ_7);
            puzzleFlag = true;
        }

        if (Objects.equals(roomID, "C2_L")) {
            System.out.println(PUZ_8);
            puzzleFlag = true;
        }
        return puzzleFlag;
    }

    private static void displayPuzzleQuestion(String roomID) {
        System.out.println("");
        if (Objects.equals(roomID, "C1U_STE_2")) {
            System.out.println(PUZ_1Question);
        }

        if (Objects.equals(roomID, "C1L_KT_1")) {
            System.out.println(PUZ_2Question);
        }

        if (Objects.equals(roomID, "C3_STF_2")) {
            System.out.println(PUZ_3Question);
        }

        if (Objects.equals(roomID, "C2U_STE_4")) {
            System.out.println(PUZ_4Question);
        }

        if (Objects.equals(roomID, "C2U_BA_5")) {
            System.out.println(PUZ_5Question);
        }

        if (Objects.equals(roomID, "C3U_BA_7")) {
            System.out.println(PUZ_6Question);
        }

        if (Objects.equals(roomID, "C3U_BAR")) {
            System.out.println(PUZ_7Question);
        }

        if (Objects.equals(roomID, "C2_L")) {
            System.out.println(PUZ_8Question);
        }
    }

    private static void displayPuzzleSolved(String roomID) {
        System.out.println("");
        if (Objects.equals(roomID, "C1U_STE_2")) {
            System.out.println(PUZ_1Solved);
        }

        if (Objects.equals(roomID, "C1L_KT_1")) {
            System.out.println(PUZ_2Solved);
        }

        if (Objects.equals(roomID, "C3_STF_2")) {
            System.out.println(PUZ_3Solved);
        }

        if (Objects.equals(roomID, "C2U_STE_4")) {
            System.out.println(PUZ_4Solved);
        }

        if (Objects.equals(roomID, "C2U_BA_5")) {
            System.out.println(PUZ_5Solved);
        }

        if (Objects.equals(roomID, "C3U_BA_7")) {
            System.out.println(PUZ_6Solved);
        }

        if (Objects.equals(roomID, "C3U_BAR")) {
            System.out.println(PUZ_7Solved);
        }

        if (Objects.equals(roomID, "C2_L")) {
            System.out.println(PUZ_8Solved);
        }

    }

    private static void displayPuzzleWrong(String roomID) {
        System.out.println("");
        if (Objects.equals(roomID, "C1U_STE_2")) {
            System.out.println(PUZ_1Wrong);
        }

        if (Objects.equals(roomID, "C1L_KT_1")) {
            System.out.println(PUZ_2Wrong);
        }

        if (Objects.equals(roomID, "C3_STF_2")) {
            System.out.println(PUZ_3Wrong);
        }

        if (Objects.equals(roomID, "C2U_STE_4")) {
            System.out.println(PUZ_4Wrong);
        }

        if (Objects.equals(roomID, "C2U_BA_5")) {
            System.out.println(PUZ_5Wrong);
        }

        if (Objects.equals(roomID, "C3U_BA_7")) {
            System.out.println(PUZ_6Wrong);
        }

        if (Objects.equals(roomID, "C3U_BAR")) {
            System.out.println(PUZ_7Wrong);
        }

        if (Objects.equals(roomID, "C2_L")) {
            System.out.println(PUZ_8Wrong);
        }

    }

    private static void displayPuzzleHint(String roomID) {
        System.out.println("");
        if (Objects.equals(roomID, "C1U_STE_2")) {
            System.out.println(PUZ_1Hint);
        }

        if (Objects.equals(roomID, "C1L_KT_1")) {
            System.out.println(PUZ_2Hint);
        }

        if (Objects.equals(roomID, "C3_STF_2")) {
            System.out.println(PUZ_3Hint);
        }

        if (Objects.equals(roomID, "C2U_STE_4")) {
            System.out.println(PUZ_4Hint);
        }

        if (Objects.equals(roomID, "C2U_BA_5")) {
            System.out.println(PUZ_5Hint);
        }

        if (Objects.equals(roomID, "C3U_BA_7")) {
            System.out.println(PUZ_6Hint);
        }

        if (Objects.equals(roomID, "C3U_BAR")) {
            System.out.println(PUZ_7Hint);
        }

        if (Objects.equals(roomID, "C2_l")) {
            System.out.println(PUZ_8Hint);
        }

    }

    static boolean checkPuzzle(String roomID) {
        UserInterface.displayPuzzleQuestion(roomID);
        boolean answer = false;
        Scanner numberInput = new Scanner(System.in);
        Scanner puzzleInput = new Scanner(System.in);
        int numberAnswer = numberInput.nextInt();
        String puzzleAnswer = puzzleInput.next();
        System.out.println("");
        if (Objects.equals(roomID, "C1U_STE_2")) {
            System.out.println("1: Answer");
            System.out.println("2: Hint");
            System.out.println("Press ENTER");
            if (numberAnswer == 1) {
                System.out.println("What is your answer?");
                if (puzzleAnswer.equalsIgnoreCase(PUZ_1Answer)) {
                    UserInterface.displayPuzzleSolved(roomID);
                    System.out.println(A01);
                    System.out.println(A01Description);
                    answer = true;
                }
                if (!puzzleAnswer.equalsIgnoreCase(PUZ_1Answer)) {
                    UserInterface.displayPuzzleWrong(roomID);
                }
            }
            if (numberAnswer == 2) {
                    UserInterface.displayPuzzleHint(roomID);
                    UserInterface.checkPuzzle(roomID);
            }
        }
        if (Objects.equals(roomID, "C1L_KT_1")) {
            System.out.println("1: Answer");
            System.out.println("2: Hint");
            System.out.println("Press ENTER");
            if (numberAnswer == 1) {
                System.out.println("What is your answer?");
                if (puzzleAnswer.equalsIgnoreCase(PUZ_2Answer)) {
                    UserInterface.displayPuzzleSolved(roomID);
                    System.out.println(A10);
                    System.out.println(A10Description);
                    answer = true;
                }
                if (!puzzleAnswer.equalsIgnoreCase(PUZ_2Answer)) {
                    UserInterface.displayPuzzleWrong(roomID);
                }
            }
            if (numberAnswer == 2) {
                UserInterface.displayPuzzleHint(roomID);
                UserInterface.checkPuzzle(roomID);
            }
        }
        if (Objects.equals(roomID, "C3_STF_2")) {
            System.out.println("1: Answer");
            System.out.println("2: Hint");
            System.out.println("Press ENTER");
            if (numberAnswer == 1) {
                System.out.println("What is your answer?");
                if (puzzleAnswer.equalsIgnoreCase(PUZ_3Answer)) {
                    UserInterface.displayPuzzleSolved(roomID);
                    answer = true;
                }
                if (!puzzleAnswer.equalsIgnoreCase(PUZ_3Answer)) {
                    UserInterface.displayPuzzleWrong(roomID);
                }
            }
            if (numberAnswer == 2) {
                UserInterface.displayPuzzleHint(roomID);
                UserInterface.checkPuzzle(roomID);
            }
        }
        if (Objects.equals(roomID, "C2U_STE_4")) {
            System.out.println("1: Answer");
            System.out.println("2: Hint");
            System.out.println("Press ENTER");
            if (numberAnswer == 1) {
                System.out.println("What is your answer?");
                if (puzzleAnswer.equalsIgnoreCase(PUZ_4Answer)) {
                    UserInterface.displayPuzzleSolved(roomID);
                    System.out.println(A08);
                    System.out.println(A08Description);
                    answer = true;
                }
                if (!puzzleAnswer.equalsIgnoreCase(PUZ_4Answer)) {
                    UserInterface.displayPuzzleWrong(roomID);
                }
            }
            if (numberAnswer == 2) {
                UserInterface.displayPuzzleHint(roomID);
                UserInterface.checkPuzzle(roomID);
            }
        }
        if (Objects.equals(roomID, "C2U_BA_5")) {
            System.out.println("1: Answer");
            System.out.println("2: Hint");
            System.out.println("Press ENTER");
            if (numberAnswer == 1) {
                System.out.println("What is your answer?");
                if (puzzleAnswer.equalsIgnoreCase(PUZ_5Answer)) {
                    UserInterface.displayPuzzleSolved(roomID);
                    System.out.println(A02);
                    System.out.println(A02Description);
                    answer = true;
                }
                if (!puzzleAnswer.equalsIgnoreCase(PUZ_5Answer)) {
                    UserInterface.displayPuzzleWrong(roomID);
                }
            }
            if (numberAnswer == 2) {
                UserInterface.displayPuzzleHint(roomID);
                UserInterface.checkPuzzle(roomID);
            }
        }
        if (Objects.equals(roomID, "C3U_BA_7")) {
            System.out.println("1: Answer");
            System.out.println("2: Hint");
            System.out.println("Press ENTER");
            if (numberAnswer == 1) {
                System.out.println("What is your answer?");
                if (puzzleAnswer.equalsIgnoreCase(PUZ_6Answer)) {
                    UserInterface.displayPuzzleSolved(roomID);
                    answer = true;
                }
                if (!puzzleAnswer.equalsIgnoreCase(PUZ_6Answer)) {
                    UserInterface.displayPuzzleWrong(roomID);
                }
            }
            if (numberAnswer == 2) {
                UserInterface.displayPuzzleHint(roomID);
                UserInterface.checkPuzzle(roomID);
            }
        }
        if (Objects.equals(roomID, "C3U_BAR")) {
            System.out.println("1: Answer");
            System.out.println("2: Hint");
            System.out.println("Press ENTER");
            if (numberAnswer == 1) {
                System.out.println("What is your answer?");
                if (puzzleAnswer.equalsIgnoreCase(PUZ_7Answer)) {
                    UserInterface.displayPuzzleSolved(roomID);
                    System.out.println(A03);
                    System.out.println(A03Description);
                    answer = true;
                }
                if (!puzzleAnswer.equalsIgnoreCase(PUZ_7Answer)) {
                    UserInterface.displayPuzzleWrong(roomID);
                }
            }
            if (numberAnswer == 2) {
                UserInterface.displayPuzzleHint(roomID);
                UserInterface.checkPuzzle(roomID);
            }
        }
        if (Objects.equals(roomID, "C2_L")) {
            System.out.println("1: Answer");
            System.out.println("2: Hint");
            System.out.println("Press ENTER");
            if (numberAnswer == 1) {
                System.out.println("What is your answer?");
                if (puzzleAnswer.equalsIgnoreCase(PUZ_8Answer)) {
                    UserInterface.displayPuzzleSolved(roomID);
                    answer = true;
                }
                if (!puzzleAnswer.equalsIgnoreCase(PUZ_8Answer)) {
                    UserInterface.displayPuzzleWrong(roomID);
                }
            }
            if (numberAnswer == 2) {
                UserInterface.displayPuzzleHint(roomID);
                UserInterface.checkPuzzle(roomID);
            }
        }
        return answer;
    }

    static void displayMainCommand() {
        System.out.println("");
        System.out.println("R: Search Room");
        System.out.println("");
        System.out.println("C: Create Game");
        System.out.println("L: Load Game");
        System.out.println("S: Save Game");
        System.out.println("E: Exit Game");
        System.out.println("G: View Score");
        System.out.println("H: View Help");
        System.out.println("I: View Inventory");
    }
}
