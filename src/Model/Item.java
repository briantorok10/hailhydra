package Model;


/**
 * 
 * @author Jose Moreno
 *
 */
public class Item //needs to be abstract for effect() method
{
	private String name,description,use;
	private int itemID, value;

	public Item(String name, int itemID, String description, String use, int value)
	{
		this.name = name;
		this.description = description;
		this.itemID = itemID;
		this.use = use;
		this.value = value;
	}
	public String getName()
	{
		return name;
	}
	public String getDescription()
	{
		return description;
	}
	public int getItemID()
	{
		return itemID;
	}

	public String getUse()
	{
		return use;
	}
	public int getValue()
	{
		return value;
	}
	public void effect()
	{
	}//should be used by each item type (add points, increase luck, etc.)
	public static void cashOut()
	{
		if(Player.inventory.size() > 1)
		{
			for(int i = 0; i < Player.inventory.size(); i++)
			{
				if(Player.inventory.get(i).name.equals("Copper Coin") || Player.inventory.get(i).name.equals("Silver Coin") || Player.inventory.get(i).name.equals("Gold Coin"))
				{
					Player.inventory.remove(i);
					Player.increaseScore(Player.inventory.get(i).getValue());
				}

			}
		}
		else System.out.println("We require at least 20 gold worth of items before cashing out!");
	}
}
