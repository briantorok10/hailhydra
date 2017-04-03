import java.util.ArrayList;

public class Monsters
{
	private String name;
//	private Item dropItems;
	private int scoreLoss;
	private double chance;
	private String enterStatement;
	private String winStatement;
	private String exitStatement;
	
	
	public Monsters(String name, /*Item dropItems,*/ int scoreLoss, double chance, String enterStatement,
			String winStatement, String exitStatement)
	{
		super();
		this.name = name;
//		this.dropItems = dropItems;
		this.scoreLoss = scoreLoss;
		this.chance = chance;
		this.enterStatement = enterStatement;
		this.winStatement = winStatement;
		this.exitStatement = exitStatement;
	}
}
