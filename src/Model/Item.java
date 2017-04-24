package Model;

import Controller.Menu;

/**
 * 
 * @author Jose Moreno
 *
 */
public class Item //needs to be abstract for effect() method
{
	private String name,description,use;
	private int itemID, value;
	private double incChance;

	public Item(String name, int itemID, String description, String use, int value)
	{
		this.name = name;
		this.description = description;
		this.itemID = itemID;
		this.use = use;
		this.value = value;
	}
	public Item(String name, int itemID, String description, String use, int value, double incChance)
	{
		this.name = name;
		this.description = description;
		this.itemID = itemID;
		this.use = use;
		this.value = value;
		this.incChance = incChance;
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
	public static void cashOut()
	{
		if(Player.inventory.size() > 1)
		{
			for(int i = 0; i < Player.inventory.size(); i++)
			{
				if(Player.inventory.get(i).name.equals("Copper Coin") || Player.inventory.get(i).name.equals("Silver Coin") || Player.inventory.get(i).name.equals("Gold Coin"))
				{
					Player.increaseScore(Player.inventory.get(i).getValue());
					Player.inventory.remove(i);
				}

			}
		}
		else System.out.println("We require at least 20 gold worth of items before cashing out!");
		Menu.MainMenu();
	}
	public double getIncChance() {
		// TODO Auto-generated method stub
		return incChance;
	}
}
