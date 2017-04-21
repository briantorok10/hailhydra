package Model;
import java.util.ArrayList;

public class Monsters extends Character
{
	private Item dropItems;
	private int scoreLoss;
	private double chance;
	private String enterStatement;
	private String winStatement;
	private String exitStatement;
	private boolean isDefeated;
	
	Monsters()
	{
		super();
	}
	
	public Monsters(int characterID, String name, Rooms currentRoom, Item dropItems, int scoreLoss, double chance,
			String enterStatement, String winStatement, String exitStatement) {
		super(characterID, name, currentRoom);
		this.dropItems = dropItems;
		this.scoreLoss = scoreLoss;
		this.chance = chance;
		this.enterStatement = enterStatement;
		this.winStatement = winStatement;
		this.exitStatement = exitStatement;
		this.isDefeated = false;
	}
	
	public Item getDropItems() {
		return dropItems;
	}
	public void setDropItems(Item dropItems) {
		this.dropItems = dropItems;
	}
	public int getScoreLoss() {
		return scoreLoss;
	}
	public void setScoreLoss(int scoreLoss) {
		this.scoreLoss = scoreLoss;
	}
	public double getChance() {
		return chance;
	}
	public void setChance(double chance) {
		this.chance = chance;
	}
	public String getEnterStatement() {
		return enterStatement;
	}
	public String getWinStatement() {
		return winStatement;
	}
	public String getExitStatement() {
		return exitStatement;
	}
	public boolean getIsDefeated() {
		return isDefeated;
	}
	public void setIsDefeated(boolean b)
	{
		this.isDefeated = b;
	}
	
	public void remove()//disables enemy
	{
		setIsDefeated(true);
	}
}
