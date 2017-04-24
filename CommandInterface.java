import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


/**Class: CommandInterface
 * @author Chris Brown
 * @version 1.0
 * Course: ITEC 3860 Software Development I Section 01 Spring 2017
 * Written: April 6, 2017
 *
 * This class: This is the controller class for the system.
 *
 * Purpose: This class is the control class between the user interface and the model classes. This class operates on
 * the input of the user, which then invokes the appropriate methods. This class controls and updates the user
 * interface, reads the user input, tracks, controls and updates the Player class, and sends the user's input to the
 * model classes.
 * This class creates, loads and saves games, updates inventory, and exits to the console.
 *
 */
@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
public class CommandInterface {

    public static void main(String[] args) {

        Player currentPlayer;
        boolean exitFlag = false;

        static Player createGame(Player currentPlayer) {
            Scanner input = new Scanner(System.in);
            System.out.print("\nWhat is your Name: ");
            String newPlayerName = input.nextLine();
            currentPlayer.setPlayerName(newPlayerName);
            currentPlayer.setScore(0);
            currentPlayer.setCurrentRoom("C1U");
            currentPlayer.setC1U(true);
            currentPlayer.setC1U_STE_1(false);
            currentPlayer.setC1U_BA_1(false);
            currentPlayer.setC1U_STE_2(false);
            currentPlayer.setC1U_PASS_1(false);
            currentPlayer.setC1U_BA_2(false);
            currentPlayer.setC1_L(false);
            currentPlayer.setC1L_KT_1(false);
            currentPlayer.setC1L_DIN_1(false);
            currentPlayer.setC1L_BA_3(false);
            currentPlayer.setC2_U(false);
            currentPlayer.setC2U_BA_4(false);
            currentPlayer.setC2U_STE_3(false);
            currentPlayer.setC2U_STE_4(false);
            currentPlayer.setC2U_BA_5(false);
            currentPlayer.setC2_L(false);
            currentPlayer.setC2L_BA_6(false);
            currentPlayer.setC2L_STE_10(false);
            currentPlayer.setC2L_STE_11(false);
            currentPlayer.setC2L_SIT_12(false);
            currentPlayer.setC3_U(false);
            currentPlayer.setC3U_BAR(false);
            currentPlayer.setC3U_LG_1(false);
            currentPlayer.setC3U_LG_2(false);
            currentPlayer.setC3U_BA_7(false);
            currentPlayer.setC3_L(false);
            currentPlayer.setC3L_COAL_RM(false);
            currentPlayer.setC3L_RM(false);
            currentPlayer.setC3_STF_2(false);
            currentPlayer.setC3U_BA_8(false);
            currentPlayer.setA04(false);
            currentPlayer.setA05(false);
            currentPlayer.setA06(false);
            currentPlayer.setA07(false);
            currentPlayer.setA08(false);
            currentPlayer.setA09(false);
            currentPlayer.setA10(false);
            currentPlayer.setRoomCount(0);
            return currentPlayer;
            }

        static void creator(Player currentPlayer) {
            Player newPlayer = new Player();
            createGame(newPlayer);
            CommandInterface.control(currentPlayer, false);
            }

        static void loadGame(Player currentPlayer) {
            System.out.println("\nAre you sure?");
            System.out.println("1: Yes");
            System.out.println("2: No");

            javafx.scene.text.Text loadChoice = new javafx.scene.text.Text();

            loadChoice.setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case DIGIT1:
                        Player oldGame = new Player();
                        CommandInterface.gameLoader(oldGame);
                        CommandInterface
                                .control();
                        break;
                    case DIGIT2:
                        CommandInterface.control(currentPlayer, false);
                        break;
                }
            });
        }

        private static Player gameLoader(Player currentPlayer) {
            Scanner gameName = new Scanner(System.in);
            System.out.println("\nWhat is the player name?");
            String oldPlayerName = gameName.nextLine();

            File fileName = new File(oldPlayerName + ".game");

            if (! fileName.exists()) {
                System.out.println("\nUnable to find a file listed with that name");
                CommandInterface.control(currentPlayer, false);
            }

            try (
                    DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))
            ) {
                currentPlayer.setPlayerName(input.readUTF());
                currentPlayer.setScore(input.readInt());
                currentPlayer.setCurrentRoom(input.readUTF());
                currentPlayer.setLastRoom(input.readUTF());
                currentPlayer.setC1U(input.readBoolean());
                currentPlayer.setC1U_STE_1(input.readBoolean());
                currentPlayer.setC1U_BA_1(input.readBoolean());
                currentPlayer.setC1U_PASS_1(input.readBoolean());
                currentPlayer.setC1U_BA_2(input.readBoolean());
                currentPlayer.setC1_L(input.readBoolean());
                currentPlayer.setC1L_KT_1(input.readBoolean());
                currentPlayer.setC1L_DIN_1(input.readBoolean());
                currentPlayer.setC1L_BA_3(input.readBoolean());
                currentPlayer.setC2_U(input.readBoolean());
                currentPlayer.setC2U_BA_4(input.readBoolean());
                currentPlayer.setC2U_STE_3(input.readBoolean());
                currentPlayer.setC2U_STE_4(input.readBoolean());
                currentPlayer.setC2U_BA_5(input.readBoolean());
                currentPlayer.setC2_L(input.readBoolean());
                currentPlayer.setC2L_BA_6(input.readBoolean());
                currentPlayer.setC2L_STE_10(input.readBoolean());
                currentPlayer.setC2L_STE_11(input.readBoolean());
                currentPlayer.setC2L_SIT_12(input.readBoolean());
                currentPlayer.setC3_U(input.readBoolean());
                currentPlayer.setC3U_BAR(input.readBoolean());
                currentPlayer.setC3U_LG_1(input.readBoolean());
                currentPlayer.setC3U_LG_2(input.readBoolean());
                currentPlayer.setC3U_BA_7(input.readBoolean());
                currentPlayer.setC3_L(input.readBoolean());
                currentPlayer.setC3L_COAL_RM(input.readBoolean());
                currentPlayer.setC3L_RM(input.readBoolean());
                currentPlayer.setC3_STF_2(input.readBoolean());
                currentPlayer.setC3U_BA_8(input.readBoolean());
                currentPlayer.setA04(input.readBoolean());
                currentPlayer.setA05(input.readBoolean());
                currentPlayer.setA06(input.readBoolean());
                currentPlayer.setA07(input.readBoolean());
                currentPlayer.setA08(input.readBoolean());
                currentPlayer.setA09(input.readBoolean());
                currentPlayer.setA10(input.readBoolean());
                currentPlayer.setRoomCount(input.readInt());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Sorry, was unsuccessful in loading file");
            }
            return currentPlayer;

        }

        private static void saveGame(Player currentPlayer) {
            System.out.println("\nAre you sure?");
            System.out.println("1: Yes");
            System.out.println("2: No");

            javafx.scene.text.Text saveChoice = new javafx.scene.text.Text();

            saveChoice.setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case DIGIT1:
                        Player currentGame = new Player();
                        CommandInterface.gameSaver(currentGame, false);
                        break;
                    case DIGIT2:
                        CommandInterface.control(currentPlayer, false);
                        break;
                }
            });
        }

        private static void gameSaver(Player currentPlayer, boolean exitFlag) {

            File fileName = new File(currentPlayer.getPlayerName() + ".game");

            if (fileName.exists()) {
                //noinspection ResultOfMethodCallIgnored
                fileName.delete();
            }

            try (
                    DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream
                                                                                                    (fileName)))
            ) {
                output.writeUTF(currentPlayer.getPlayerName());
                output.writeInt(currentPlayer.getScore());
                output.writeUTF(currentPlayer.getCurrentRoom());
                output.writeUTF(currentPlayer.getLastRoom());
                output.writeBoolean(currentPlayer.isC1U());
                output.writeBoolean(currentPlayer.isC1U_STE_1());
                output.writeBoolean(currentPlayer.isC1U_BA_1());
                output.writeBoolean(currentPlayer.isC1U_STE_2());
                output.writeBoolean(currentPlayer.isC1U_PASS_1());
                output.writeBoolean(currentPlayer.isC1U_BA_2());
                output.writeBoolean(currentPlayer.isC1_L());
                output.writeBoolean(currentPlayer.isC1L_KT_1());
                output.writeBoolean(currentPlayer.isC1L_DIN_1());
                output.writeBoolean(currentPlayer.isC1L_BA_3());
                output.writeBoolean(currentPlayer.isC2_U());
                output.writeBoolean(currentPlayer.isC2U_BA_4());
                output.writeBoolean(currentPlayer.isC2U_STE_3());
                output.writeBoolean(currentPlayer.isC2U_STE_4());
                output.writeBoolean(currentPlayer.isC2U_BA_5());
                output.writeBoolean(currentPlayer.isC2_L());
                output.writeBoolean(currentPlayer.isC2L_BA_6());
                output.writeBoolean(currentPlayer.isC2L_STE_10());
                output.writeBoolean(currentPlayer.isC2L_STE_11());
                output.writeBoolean(currentPlayer.isC2L_SIT_12());
                output.writeBoolean(currentPlayer.isC3_U());
                output.writeBoolean(currentPlayer.isC3U_BAR());
                output.writeBoolean(currentPlayer.isC3U_LG_1());
                output.writeBoolean(currentPlayer.isC3U_LG_2());
                output.writeBoolean(currentPlayer.isC3U_BA_7());
                output.writeBoolean(currentPlayer.isC3_L());
                output.writeBoolean(currentPlayer.isC3L_COAL_RM());
                output.writeBoolean(currentPlayer.isC3L_RM());
                output.writeBoolean(currentPlayer.isC3_STF_2());
                output.writeBoolean(currentPlayer.isC3U_BA_8());
                output.writeBoolean(currentPlayer.isA04());
                output.writeBoolean(currentPlayer.isA05());
                output.writeBoolean(currentPlayer.isA06());
                output.writeBoolean(currentPlayer.isA07());
                output.writeBoolean(currentPlayer.isA08());
                output.writeBoolean(currentPlayer.isA09());
                output.writeBoolean(currentPlayer.isA10());
                output.writeInt(currentPlayer.getRoomCount());
            } catch (FileNotFoundException e) {
                System.out.println("Unable to save player file");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            CommandInterface.control(currentPlayer, exitFlag);
        }

        @SuppressWarnings("ConstantConditions")
        static void exitGame() {
            System.out.println("\nAre you sure?");
            System.out.println("1: Yes");
            System.out.println("2: No");

            javafx.scene.text.Text exitChoice = new javafx.scene.text.Text();

            exitChoice.setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case DIGIT1:
                        System.out.println("\nWould you like to save your progress before you go?");
                        System
                                .out.println("1: Yes");
                        System.out.println("2: No");
                        javafx.scene.text.Text saveChoice =
                                new javafx.scene.text.Text();
                        saveChoice.setOnKeyPressed(e -> {
                            switch (e.getCode()) {
                                case DIGIT1:
                                    boolean exitFlag = true;
                                    Player currentGame = new Player();
                                    CommandInterface.gameSaver(currentGame, exitFlag);
                                    break;
                                case DIGIT2:
                                    System.out.println("\nSad to see you go.");
                                    System.out.println
                                            ("Too-da-loo!");
                                    System.exit(0);
                            }
                        });
                    case DIGIT2:
                        System.out.println("\nSad to see you go.");
                        System.out.println("Too-da-loo!");
                        System.exit(0);
                }
            });

        }

        private static void viewScore(Player currentPlayer) {
            int scoreDisplay = currentPlayer.getScore();
            float completionPercentage = (currentPlayer.getRoomCount() / 29) * 100;
            System.out.println("\nYour current score is: " + scoreDisplay);
            System.out.println("You have completed " + completionPercentage + "% of the game.");
            System.out.println("1: Exit Score");

            javafx.scene.text.Text exitScore = new javafx.scene.text.Text();

            exitScore.setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case DIGIT1:
                        CommandInterface.control(currentPlayer, false);
                        break;
                    default:
                        System.out.println("\nI said press 1!");
                        CommandInterface.viewScore(currentPlayer);
                }
            });
        }

        @SuppressWarnings("CodeBlock2Expr")
        private static void viewHelp(Player currentPlayer) {
            System.out.println("");
            System.out.println("Your objective is to navigate the train while encountering enemies, solving puzzles,"
                                       + " and finding items.");
            System.out.println("When you first enter a new room, a description of your surroundings is displayed.");
            System.out.println("You will then be provided with a basic menu that allows you enter another room, " +
                                       "attack or flee an enemy, solve puzzles, and investigate the room. ");
            System.out.println("You will always be presented with the Main Command Menu. This menu consist of:");
            System.out.println("C: Create Game - This option allows you to create a new game.");
            System.out.println("L: Load Game - This option allows you to load a previously save game.");
            System.out.println("S: Save Game - This option allows you to load a previously saved game.");
            System.out.println("Q: Quit Game - This option allows you to quit the game, with an option to save first.");
            System.out.println("H: Display Help - This option allows you to display this Help Menu.");
            System.out.println("I: Display Inventory - This option allows you to display your current inventory.");
            System.out.println("G: Display Score - This option allows you to display your current score.\n");
            System.out.println("Press any key to exit.");

            javafx.scene.text.Text exitHelp = new javafx.scene.text.Text();

            exitHelp.setOnKeyPressed(e -> {
                CommandInterface.control(currentPlayer, false);
            });
        }

        private static void viewInventory(Player currentPlayer) {
            ArrayList<String> itemName = new ArrayList<>();
            int inventoryCounter = 0;
            boolean a04 = currentPlayer.isA04();
            boolean a05 = currentPlayer.isA05();
            boolean a06 = currentPlayer.isA06();
            boolean a07 = currentPlayer.isA07();
            boolean a08 = currentPlayer.isA08();
            boolean a09 = currentPlayer.isA09();
            boolean a10 = currentPlayer.isA10();

            System.out.println("");

            if (a04) {
                itemName.add("Short Pants");
                inventoryCounter = inventoryCounter + 1;
                System.out.println(inventoryCounter + ": " + UserInterface.A04);
            }
            if (a05) {
                itemName.add("Revolver");
                inventoryCounter = inventoryCounter + 1;
                System.out.println(inventoryCounter + ": " + UserInterface.A05);
            }
            if (a06) {
                itemName.add("Crystal Skull");
                inventoryCounter = inventoryCounter + 1;
                System.out.println(inventoryCounter + ": " + UserInterface.A06);
            }
            if (a07) {
                itemName.add("Snakeskin Oil");
                inventoryCounter = inventoryCounter + 1;
                System.out.println(inventoryCounter + ": " + UserInterface.A07);
            }
            if (a08) {
                itemName.add("Conductors Key");
                inventoryCounter = inventoryCounter + 1;
                System.out.println(inventoryCounter + ": " + UserInterface.A08);
            }
            if (a09) {
                itemName.add("Queen Elizabeth's Diamond Broach");
                inventoryCounter = inventoryCounter + 1;
                System.out.println(inventoryCounter + ": " + UserInterface.A09);
            }
            if (a10) {
                itemName.add("Miniscule Kitchen Knife");
                inventoryCounter = inventoryCounter + 1;
                System.out.println(inventoryCounter + ": " + UserInterface.A10);
            }

            final int inventory = inventoryCounter;

            System.out.println("\n1: Consume Item");
            System.out.println("2: Fence Item");
            System.out.println("3: Exit Inventory");

            javafx.scene.text.Text inventoryChoice = new javafx.scene.text.Text();

            inventoryChoice.setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case DIGIT1:
                        System.out.println("");
                        for (int i = 0; i < inventory; i++) {
                            System.out
                                    .println(i + ": " + itemName.get(i));
                        }
                        System.out.println("Choose which item to consume," +
                                                   " press ENTER after your selection.");
                        Scanner consumeChoice = new Scanner(System.in);
                        int consumedItem = consumeChoice.nextInt();
                        System.out.println("Consume " + itemName.get
                                (consumedItem - 1) + ", are you sure?");
                        System.out.println("1: Yes");
                        System.out.println
                                ("2:" +
                                         " No");
                        javafx.scene.text.Text choice = new javafx.scene.text.Text();
                        choice
                                .setOnKeyPressed(e -> {
                                    switch (e.getCode()) {
                                        case DIGIT1: {
                                            String item = itemName.get(consumedItem - 1);
                                            if (Objects.equals(item, "Short Pants")) {
                                                currentPlayer.setA04(false);
                                                CommandInterface.viewInventory(currentPlayer);
                                                break;
                                            }
                                            if (Objects.equals(item, "Revolver")) {
                                                currentPlayer.setA05(false);
                                                CommandInterface.viewInventory(currentPlayer);
                                                break;
                                            }
                                            if (Objects.equals(item, "Crystal Skull")) {
                                                currentPlayer.setA06(false);
                                                CommandInterface.viewInventory(currentPlayer);
                                                break;
                                            }
                                            if (Objects.equals(item, "Snakeskin Oil")) {
                                                currentPlayer.setA07(false);
                                                CommandInterface.viewInventory(currentPlayer);
                                                break;
                                            }
                                            if (Objects.equals(item, "Conductors Key")) {
                                                currentPlayer.setA08(false);
                                                CommandInterface.viewInventory(currentPlayer);
                                                break;
                                            }
                                            if (Objects.equals(item, "Queen Elizabeth's Diamond Broach")) {
                                                currentPlayer.setA09(false);
                                                CommandInterface.viewInventory(currentPlayer);
                                                break;
                                            }
                                            if (Objects.equals(item, "Miniscule Kitchen Knife")) {
                                                currentPlayer.setA10(false);
                                                CommandInterface.viewInventory(currentPlayer);
                                                break;
                                            }
                                        }
                                        break;
                                        case DIGIT2:
                                            CommandInterface.viewInventory(currentPlayer);

                                    }
                                });


                    case DIGIT2: {
                        System.out.println("");
                        for (int i = 0; i < inventory; i++) {
                            System.out.println(i + ": " + itemName.get(i));
                        }
                        System.out.println("Choose which item to " +
                                                   "fence, press ENTER after"
                                                   + "your selection.");
                        Scanner fenceChoice = new Scanner(System.in);
                        int fencedItem = fenceChoice.nextInt();
                        System.out.println("Fence " + itemName.get(fencedItem - 1) + ", are you sure?");
                        System.out.println("1: Yes");
                        System.out.println("2: No");
                        javafx.scene.text.Text choice = new javafx.scene.text.Text();
                        choice.setOnKeyPressed(ex -> {
                            switch (ex.getCode()) {
                                case DIGIT1: {
                                    String item = itemName.get(fencedItem - 1);
                                    if (Objects.equals(item, "Short Pants")) {
                                        currentPlayer.setA04(false);
                                        CommandInterface.viewInventory(currentPlayer);
                                        break;
                                    }
                                    if (Objects.equals(item, "Revolver")) {
                                        currentPlayer.setA05(false);
                                        CommandInterface.viewInventory(currentPlayer);
                                        break;
                                    }
                                    if (Objects.equals(item, "Crystal Skull")) {
                                        currentPlayer.setA06(false);
                                        CommandInterface.viewInventory(currentPlayer);
                                        break;
                                    }
                                    if (Objects.equals(item, "Snakeskin Oil")) {
                                        currentPlayer.setA07(false);
                                        CommandInterface.viewInventory(currentPlayer);
                                        break;
                                    }
                                    if (Objects.equals(item, "Conductors Key")) {
                                        currentPlayer.setA08(false);
                                        CommandInterface.viewInventory(currentPlayer);
                                        break;
                                    }
                                    if (Objects.equals(item, "Queen Elizabeth's Diamond Broach")) {
                                        currentPlayer.setA09(false);
                                        CommandInterface.viewInventory(currentPlayer);
                                        break;
                                    }
                                    if (Objects.equals(item, "Miniscule Kitchen Knife")) {
                                        currentPlayer.setA10(false);
                                        CommandInterface.viewInventory(currentPlayer);
                                        break;
                                    }
                                }
                                break;
                            }
                        });
                    }
                    case DIGIT3:
                        CommandInterface.control(currentPlayer, false);
                        break;
                }
            });
        }

        @SuppressWarnings("WeakerAccess")
        boolean attackResult;

        @SuppressWarnings("unused")
        boolean puzzleResult;

        @SuppressWarnings("WeakerAccess")
        public static void roomAlert(String roomID) {
            this.roomID = roomID;
        }

        @SuppressWarnings("WeakerAccess")
        public static boolean getAttackResult() {
            return attackResult;
        }

        @SuppressWarnings("unused")
        public void setAttackResult(boolean result) {
            this.attackResult = result;
        }

        @SuppressWarnings("WeakerAccess")
        public static void puzzleResult(boolean answer) {
            this.answer = answer;
        }

        @SuppressWarnings("unused")
        public static boolean getPuzzleResult() {
            return answer;
        }

        @SuppressWarnings("ResultOfMethodCallIgnored")
        static void control(Player currentPlayer, boolean exitFlag) {
            if (exitFlag) {
                System.out.println("Sorry to see you go.");
                System.out.println("Too-da-loo!");
                System.exit(0);
            }

            UserInterface.displayRoom(currentPlayer.getCurrentRoom());
            roomAlert(currentPlayer.getCurrentRoom());
            boolean yesMonster = UserInterface.displayMonsterEnter(currentPlayer.getCurrentRoom());
            if (yesMonster) {
                System.out.println("");
                System.out.println("A: Attack Monster");
                System.out.println("N: No way Jose, run away");
            }

            boolean yesPuzzle = UserInterface.displayPuzzleName(currentPlayer.getCurrentRoom());
            if (yesPuzzle) {
                System.out.println("");
                System.out.println("P: Solve Puzzle");
            }
            UserInterface.setRoomList(currentPlayer.getCurrentRoom());
            UserInterface.displayRooms(UserInterface.roomList);
            System.out.println("\nWhen selecting rooms, please press ENTER.");
            UserInterface.displayMainCommand();

            javafx.scene.text.Text playerInput = new javafx.scene.text.Text();

            playerInput.setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case C:
                        CommandInterface.creator(currentPlayer);
                        break;
                    case L:
                        CommandInterface.loadGame(currentPlayer);
                        break;
                    case G:
                        CommandInterface.viewScore(currentPlayer);
                        break;
                    case S:
                        CommandInterface.saveGame(currentPlayer);
                        break;
                    case E:
                        CommandInterface.exitGame();
                        break;
                    case H:
                        CommandInterface.viewHelp(currentPlayer);
                        break;
                    case I:
                        CommandInterface.viewInventory(currentPlayer);
                        break;
                    case N:
                        if (yesMonster) {
                            UserInterface.displayMonsterExit(currentPlayer.getCurrentRoom());
                            currentPlayer.setCurrentRoom(currentPlayer.getLastRoom());
                            CommandInterface.control
                                    (currentPlayer,
                                     false);
                        }
                        break;
                    case A:
                        if (yesMonster) {
                            CommandInterface.getAttackResult();
                            if (getAttackResult()) {
                                UserInterface.displayMonsterWin(currentPlayer.getCurrentRoom());
                            }
                        }
                        break;
                    case P:
                        if (yesPuzzle) {
                            UserInterface.checkPuzzle(currentPlayer.getCurrentRoom());
                            puzzleResult(UserInterface.checkPuzzle(currentPlayer.getCurrentRoom()));
                        }
                        break;
                    case R:
                        if (Objects.equals(currentPlayer.getCurrentRoom(), "C1U_STE_1")) {
                            System.out.println("\n" + UserInterface.A06);
                            System.out.println(UserInterface.A06Description);
                        } else if (Objects.equals(currentPlayer.getCurrentRoom(), "C1L_KT_1")) {
                            System.out.println("\n" + UserInterface.A07);
                            System.out.println(UserInterface.A07Description);
                        } else {
                            System.out.println("Nothing left in here.");
                        }
                }
            });


            Scanner input = new Scanner(System.in);
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C1_U")) {
                currentPlayer.setLastRoom("C1_U");
                if (input.nextInt() == 1) {
                    currentPlayer.setCurrentRoom("C1U_STE_2");
                    currentPlayer.setC1U_STE_2(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 2) {
                    currentPlayer.setCurrentRoom("C1U_BA_1");
                    currentPlayer.setC1U_BA_1(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 3) {
                    currentPlayer.setCurrentRoom("C1U_STE_1");
                    currentPlayer.setC1U_STE_1(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 4) {
                    currentPlayer.setCurrentRoom("C1U_PASS_1");
                    currentPlayer.setC1U_PASS_1(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 5) {
                    currentPlayer.setCurrentRoom("C1U_BA_2");
                    currentPlayer.setC1U_BA_2(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 6) {
                    currentPlayer.setCurrentRoom("C1_L");
                    currentPlayer.setC1_L(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 7) {
                    currentPlayer.setCurrentRoom("C2U");
                    currentPlayer.setC2_U(true);
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C1U_STE_1")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C1U_STE_1");
                    currentPlayer.setCurrentRoom("C1_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C1U_BA_1")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C1U_BA_1");
                    currentPlayer.setCurrentRoom("C1_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C1U_STE_2")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C1U_STE_2");
                    currentPlayer.setCurrentRoom("C1_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C1U_PASS_1")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C1U_PASS_1");
                    currentPlayer.setCurrentRoom("C1_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C1U_BA_2")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C1U_BA_2");
                    currentPlayer.setCurrentRoom("C1_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C1_L")) {
                currentPlayer.setLastRoom("C1_L");
                if (input.nextInt() == 1) {
                    currentPlayer.setCurrentRoom("C1L_KT_1");
                    currentPlayer.setC1L_KT_1(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 2) {
                    currentPlayer.setCurrentRoom("C1L_DIN_1");
                    currentPlayer.setC1L_DIN_1(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 3) {
                    currentPlayer.setCurrentRoom("C1L_BA_3");
                    currentPlayer.setC1L_BA_3(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 4) {
                    currentPlayer.setCurrentRoom("C1_U");
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 5) {
                    currentPlayer.setCurrentRoom("C2_L");
                    currentPlayer.setC2_L(true);
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C1L_KT_1")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C1L_KT_1");
                    currentPlayer.setCurrentRoom("C1_L");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C1L_DIN_1")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C1L_DIN_1");
                    currentPlayer.setCurrentRoom("C1_L");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C1L_BA_3")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C1L_BA_3");
                    currentPlayer.setCurrentRoom("C1_L");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C2_U")) {
                currentPlayer.setLastRoom("C2_U");
                if (input.nextInt() == 1) {
                    currentPlayer.setCurrentRoom("C2U_BA_4");
                    currentPlayer.setC2U_BA_4(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 2) {
                    currentPlayer.setCurrentRoom("C2U_STE_3");
                    currentPlayer.setC2U_STE_3(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 3) {
                    currentPlayer.setCurrentRoom("C2U_STE_4");
                    currentPlayer.setC2U_STE_4(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 4) {
                    currentPlayer.setCurrentRoom("C2U_BA_5");
                    currentPlayer.setC2U_BA_5(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 5) {
                    currentPlayer.setCurrentRoom("C2_L");
                    currentPlayer.setC2_L(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 6) {
                    currentPlayer.setCurrentRoom("C1_U");
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 7) {
                    currentPlayer.setCurrentRoom("C3_U");
                    currentPlayer.setC3_U(true);
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C2U_BA_4")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C2U_BA_4");
                    currentPlayer.setCurrentRoom("C2_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C2U_STE_3")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C2U_STE_3");
                    currentPlayer.setCurrentRoom("C2_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C2U_STE_4")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C2U_STE_4");
                    currentPlayer.setCurrentRoom("C2_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C2U_BA_5")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C2U_BA_5");
                    currentPlayer.setCurrentRoom("C2_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C2_L")) {
                currentPlayer.setLastRoom("C2_L");
                if (input.nextInt() == 1) {
                    currentPlayer.setCurrentRoom("C2L_BA_6");
                    currentPlayer.setC2L_BA_6(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 2) {
                    currentPlayer.setCurrentRoom("C2L_STE_10");
                    currentPlayer.setC2L_STE_10(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 3) {
                    currentPlayer.setCurrentRoom("C2L_STE_11");
                    currentPlayer.setC2L_STE_11(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 4) {
                    currentPlayer.setCurrentRoom("C2L_SIT_12");
                    currentPlayer.setC2L_SIT_12(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 5) {
                    currentPlayer.setCurrentRoom("C2_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C2L_BA_6")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C2l_BA_6");
                    currentPlayer.setCurrentRoom("C2_L");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C2L_STE_10")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C2L_STE_10");
                    currentPlayer.setCurrentRoom("C2_L");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C2L_STE_11")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C2L_STE_11");
                    currentPlayer.setCurrentRoom("C2_L");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C2L_SIT_12")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C2L_SIT_12");
                    currentPlayer.setCurrentRoom("C2_L");
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 2) {
                    currentPlayer.setLastRoom("C2L_SIT_12");
                    currentPlayer.setCurrentRoom("C2_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C3_U")) {
                currentPlayer.setLastRoom("C3_U");
                if (input.nextInt() == 1) {
                    currentPlayer.setCurrentRoom("C3U_BAR");
                    currentPlayer.setC3U_BAR(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 2) {
                    currentPlayer.setCurrentRoom("C3U_LG_1");
                    currentPlayer.setC3U_LG_1(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 3) {
                    currentPlayer.setCurrentRoom("C3U_LG_2");
                    currentPlayer.setC3U_LG_2(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 4) {
                    currentPlayer.setCurrentRoom("C3U_BA_7");
                    currentPlayer.setC3U_BA_7(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 5) {
                    currentPlayer.setCurrentRoom("C3_U");
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 6) {
                    currentPlayer.setCurrentRoom("C2_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C3U_BAR")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C3U_BAR");
                    currentPlayer.setCurrentRoom("C3_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C3U_LG_1")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C3U_LG_1");
                    currentPlayer.setCurrentRoom("C3_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C3U_LG_2")) {
                currentPlayer.setLastRoom("C3U_LG_2");
                if (input.nextInt() == 1) {
                    currentPlayer.setCurrentRoom("C3U_BA_7");
                    currentPlayer.setC3U_BA_7(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 2) {
                    currentPlayer.setCurrentRoom("C3_L");
                    currentPlayer.setC3_L(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 3) {
                    currentPlayer.setCurrentRoom("C3_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C3U_BA_7")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setCurrentRoom("C3_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C3_L")) {
                currentPlayer.setLastRoom("C3_L");
                if (input.nextInt() == 1) {
                    currentPlayer.setCurrentRoom("C3L_COAL_RM");
                    currentPlayer.setC3L_COAL_RM(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 2) {
                    currentPlayer.setCurrentRoom("C3L_RM");
                    currentPlayer.setC3L_RM(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 3) {
                    currentPlayer.setCurrentRoom("C3_STF_2");
                    currentPlayer.setC3_STF_2(true);
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 4) {
                    currentPlayer.setCurrentRoom("C3U_BA_8");
                    currentPlayer.setC3U_BA_8(true);
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C3L_COAL_RM")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C3L_COAL_RM");
                    currentPlayer.setCurrentRoom("C3_L");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C3L_RM")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C3L_RM");
                    currentPlayer.setCurrentRoom("C3_L");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C3_STF_2")) {
                if (input.nextInt() == 1) {
                    currentPlayer.setLastRoom("C3_STF_2");
                    currentPlayer.setCurrentRoom("C3_L");
                    CommandInterface.control(currentPlayer, false);
                }
            }
            if (Objects.equals(currentPlayer.getCurrentRoom(), "C3U_BA_8")) {
                currentPlayer.setLastRoom("C3U_BA_8");
                if (input.nextInt() == 1) {
                    currentPlayer.setCurrentRoom("C3_L");
                    CommandInterface.control(currentPlayer, false);
                }
                if (input.nextInt() == 2) {
                    currentPlayer.setCurrentRoom("C3_U");
                    CommandInterface.control(currentPlayer, false);
                }
            }
        }
    }
}





