import javafx.scene.text.Text;

/**Class: TrainRaid
 * @author Chris Brown
 * @version 1.0
 * Course: ITEC 3860 Software Development I Section 01 Spring 2017
 * Written: April 6, 2017
 *
 * This class: This class is the starter class for the system.
 *
 * Purpose: The purpose of this class is to start the game system. The user types into the console the name of the
 * class. This prints out the name "Train Raid" in asterisks. The user is given three options:
 * 1: To create or start a new game
 * 2: To load a previously saved game
 * 3: To exit the system
 *
 * The system employs a key listener to read the user's choice. The choices correspond to number keys.
 * Once the user makes a choice, a switch statement invokes the appropriate method in the CommandInterface class that
 * performs the user's desired action.
 *
 * The class is not used again throughout operation of the system.
 *
 */

class TrainRaid {

    public static void main(String[] args) {

        //This is an initialisation of the Player class. This is required as an instance is passed between methods in
        //the CommandInterface class in order to track, update and control the user's progress through the system.
        Player currentPlayer = new Player();

        //The following lines of code print out a splash screen of the title of the game, and the options menu.
        System.out.println("***** ****    *   *** *   *");
        System.out.println("  *   *   *  * *   *  *   *");
        System.out.println("  *   *   * *   *  *  **  *");
        System.out.println("  *   ****  *****  *  * * *");
        System.out.println("  *   * *   *   *  *  *  **");
        System.out.println("  *   *  *  *   *  *  *   *");
        System.out.println("  *   *   * *   * *** *   *");
        System.out.println("");
        System.out.println("   ****    *   *** ***");
        System.out.println("   *   *  * *   *  *  *");
        System.out.println("   *   * *   *  *  *   *");
        System.out.println("   ****  *****  *  *   *");
        System.out.println("   * *   *   *  *  *   *");
        System.out.println("   *  *  *   *  *  *  *");
        System.out.println("   *   * *   * *** ***");
        System.out.println("");
        System.out.println("");
        System.out.println("A Text-Based Adventure Game");
        System.out.println("             By");
        System.out.println("   Team Super Hero Squad");
        System.out.println("");
        System.out.println("       Developed by");
        System.out.println("        Team Hydra");
        System.out.println("");
        System.out.println("Please choose an option");
        System.out.println("1: Start Game");
        System.out.println("2: Load Game");
        System.out.println("3: Exit Game");

        Text event = new Text();

         event.setOnKeyPressed(e -> {

             switch (e.getCode()) {
                 case DIGIT1: CommandInterface.creator(currentPlayer); CommandInterface.control(currentPlayer,
                                                                                                   false); break;
                 case DIGIT2: CommandInterface.loadGame(currentPlayer); break;
                 case DIGIT3: CommandInterface.exitGame(); break;
                 default: CommandInterface.createGame(currentPlayer); CommandInterface.control(currentPlayer,false);
             }
        });
    }
}
