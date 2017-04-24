/**Class:Player
 * @author Chris Brown
 * @version 1.0
 * Course: ITEC 3860 Software Development I Section 01 Spring 2017
 * Written: April 6, 2017
 *
 * This class: This class is the user control class of the system
 *
 * Purpose: This class is used to track, update, and control the user's progress throughout the system. This class is
 * passed to the appropriate methods that must modify the parameters of the class. This class tracks the user's name,
 * score, current and past locations, and inventory items.
 *
 */
class Player {

    public Player() {
    }

    //Following are the getters and setters for each parameter of the Player class. These getters and setters are the
    //means in which the system will update the player class. All updating will be provided by the CommandInterface
    // class methods.
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getLastRoom() {
        return lastRoom;
    }

    public void setLastRoom(String lastRoom) {
        this.lastRoom = lastRoom;
    }

    private String playerName;
    private int score;
    private String currentRoom;
    private String lastRoom;

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    private int roomCount;

    public boolean isC1U() {
        return C1U;
    }

    public void setC1U(boolean c1U) {
        C1U = c1U;
    }

    public boolean isC1U_STE_1() {
        return C1U_STE_1;
    }

    public void setC1U_STE_1(boolean c1U_STE_1) {
        C1U_STE_1 = c1U_STE_1;
    }

    public boolean isC1U_BA_1() {
        return C1U_BA_1;
    }

    public void setC1U_BA_1(boolean c1U_BA_1) {
        C1U_BA_1 = c1U_BA_1;
    }

    public boolean isC1U_PASS_1() {
        return C1U_PASS_1;
    }

    public void setC1U_PASS_1(boolean c1U_PASS_1) {
        C1U_PASS_1 = c1U_PASS_1;
    }

    public boolean isC1U_BA_2() {
        return C1U_BA_2;
    }

    public void setC1U_BA_2(boolean c1U_BA_2) {
        C1U_BA_2 = c1U_BA_2;
    }

    public boolean isC1_L() {
        return C1_L;
    }

    public void setC1_L(boolean c1_L) {
        C1_L = c1_L;
    }

    public boolean isC1L_KT_1() {
        return C1L_KT_1;
    }

    public void setC1L_KT_1(boolean c1L_KT_1) {
        C1L_KT_1 = c1L_KT_1;
    }

    public boolean isC1L_DIN_1() {
        return C1L_DIN_1;
    }

    public void setC1L_DIN_1(boolean c1L_DIN_1) {
        C1L_DIN_1 = c1L_DIN_1;
    }

    public boolean isC1L_BA_3() {
        return C1L_BA_3;
    }

    public void setC1L_BA_3(boolean c1L_BA_3) {
        C1L_BA_3 = c1L_BA_3;
    }

    public boolean isC2_U() {
        return C2_U;
    }

    public void setC2_U(boolean c2_U) {
        C2_U = c2_U;
    }

    public boolean isC2U_BA_4() {
        return C2U_BA_4;
    }

    public void setC2U_BA_4(boolean c2U_BA_4) {
        C2U_BA_4 = c2U_BA_4;
    }

    public boolean isC2U_STE_3() {
        return C2U_STE_3;
    }

    public void setC2U_STE_3(boolean c2U_STE_3) {
        C2U_STE_3 = c2U_STE_3;
    }

    public boolean isC2U_STE_4() {
        return C2U_STE_4;
    }

    public void setC2U_STE_4(boolean c2U_STE_4) {
        C2U_STE_4 = c2U_STE_4;
    }

    public boolean isC2U_BA_5() {
        return C2U_BA_5;
    }

    public void setC2U_BA_5(boolean c2U_BA_5) {
        C2U_BA_5 = c2U_BA_5;
    }

    public boolean isC2_L() {
        return C2_L;
    }

    public void setC2_L(boolean c2_L) {
        C2_L = c2_L;
    }

    public boolean isC2L_BA_6() {
        return C2L_BA_6;
    }

    public void setC2L_BA_6(boolean c2L_BA_6) {
        C2L_BA_6 = c2L_BA_6;
    }

    public boolean isC2L_STE_10() {
        return C2L_STE_10;
    }

    public void setC2L_STE_10(boolean c2L_STE_10) {
        C2L_STE_10 = c2L_STE_10;
    }

    public boolean isC2L_STE_11() {
        return C2L_STE_11;
    }

    public void setC2L_STE_11(boolean c2L_STE_11) {
        C2L_STE_11 = c2L_STE_11;
    }

    public boolean isC2L_SIT_12() {
        return C2L_SIT_12;
    }

    public void setC2L_SIT_12(boolean c2L_SIT_12) {
        C2L_SIT_12 = c2L_SIT_12;
    }

    public boolean isC3_U() {
        return C3_U;
    }

    public void setC3_U(boolean c3_U) {
        C3_U = c3_U;
    }

    public boolean isC3U_BAR() {
        return C3U_BAR;
    }

    public void setC3U_BAR(boolean c2U_BAR) {
        C3U_BAR = c2U_BAR;
    }

    public boolean isC3U_LG_1() {
        return C3U_LG_1;
    }

    public void setC3U_LG_1(boolean c3U_LG_1) {
        C3U_LG_1 = c3U_LG_1;
    }

    public boolean isC3U_LG_2() {
        return C3U_LG_2;
    }

    public void setC3U_LG_2(boolean c3U_LG_2) {
        C3U_LG_2 = c3U_LG_2;
    }

    public boolean isC3U_BA_7() {
        return C3U_BA_7;
    }

    public void setC3U_BA_7(boolean c3U_BA_7) {
        C3U_BA_7 = c3U_BA_7;
    }

    public boolean isC3_L() {
        return C3_L;
    }

    public void setC3_L(boolean c3_L) {
        C3_L = c3_L;
    }

    public boolean isC3L_COAL_RM() {
        return C3L_COAL_RM;
    }

    public void setC3L_COAL_RM(boolean c3L_COAL_RM) {
        C3L_COAL_RM = c3L_COAL_RM;
    }

    public boolean isC3L_RM() {
        return C3L_RM;
    }

    public void setC3L_RM(boolean c3L_RM) {
        C3L_RM = c3L_RM;
    }

    public boolean isC3_STF_2() {
        return C3_STF_2;
    }

    public void setC3_STF_2(boolean c3_STF_2) {
        C3_STF_2 = c3_STF_2;
    }

    private boolean C1U;
    private boolean C1U_STE_1;
    private boolean C1U_BA_1;
    private boolean C1U_PASS_1;
    private boolean C1U_BA_2;
    private boolean C1_L;
    private boolean C1L_KT_1;
    private boolean C1L_DIN_1;
    private boolean C1L_BA_3;
    private boolean C2_U;
    private boolean C2U_BA_4;
    private boolean C2U_STE_3;
    private boolean C2U_STE_4;
    private boolean C2U_BA_5;
    private boolean C2_L;
    private boolean C2L_BA_6;
    private boolean C2L_STE_10;
    private boolean C2L_STE_11;
    private boolean C2L_SIT_12;
    private boolean C3_U;
    private boolean C3U_BAR;
    private boolean C3U_LG_1;
    private boolean C3U_LG_2;
    private boolean C3U_BA_7;
    private boolean C3_L;
    private boolean C3L_COAL_RM;
    private boolean C3L_RM;
    private boolean C3_STF_2;

    public boolean isC3U_BA_8() {
        return C3U_BA_8;
    }

    public void setC3U_BA_8(boolean c3U_BA_8) {
        C3U_BA_8 = c3U_BA_8;
    }

    private boolean C3U_BA_8;

    public boolean isC1U_STE_2() {
        return C1U_STE_2;
    }

    public void setC1U_STE_2(boolean c1U_STE_2) {
        C1U_STE_2 = c1U_STE_2;
    }

    private boolean C1U_STE_2;

    private boolean A04;
    private boolean A05;

    public boolean isA04() {
        return A04;
    }

    public void setA04(boolean a04) {
        A04 = a04;
    }

    public boolean isA05() {
        return A05;
    }

    public void setA05(boolean a05) {
        A05 = a05;
    }

    public boolean isA06() {
        return A06;
    }

    public void setA06(boolean a06) {
        A06 = a06;
    }

    public boolean isA07() {
        return A07;
    }

    public void setA07(boolean a07) {
        A07 = a07;
    }

    public boolean isA08() {
        return A08;
    }

    public void setA08(boolean a08) {
        A08 = a08;
    }

    public boolean isA09() {
        return A09;
    }

    public void setA09(boolean a09) {
        A09 = a09;
    }

    public boolean isA10() {
        return A10;
    }

    public void setA10(boolean a10) {
        A10 = a10;
    }

    private boolean A06;
    private boolean A07;
    private boolean A08;
    private boolean A09;
    private boolean A10;

}
