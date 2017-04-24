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
		int total = 0;
		if(!Player.inventory.isEmpty())
		{
			for(int i = 0; i < Player.inventory.size(); i++)
			{
				if(Player.inventory.get(i).name.equals("Copper Coin") || Player.inventory.get(i).name.equals("Silver Coin") || Player.inventory.get(i).name.equals("Gold Coin"))
				{
					Player.increaseScore(Player.inventory.get(i).getValue());
					Player.inventory.remove(i);
					total += Player.inventory.get(i).getValue();
					Player.inventory.remove(i);			
				}

			}
			System.out.println();
			System.out.println("You cashed all your coins out for a total of: " + total + "G");
			System.out.println();
			System.out.println("Your Score: " + Player.getScore() + "G");
			System.out.println("This is what you're lugging around:");
			//Still needs some work

			if (Player.inventory.isEmpty())
			{
				System.out.println("You don't seem to be carrying anything but the clothes on your back.\nWhat kind of a thief are ya?");
			}
			else
			{
				for (Item i: Player.inventory)
				{
					System.out.println(i.getName() + " - " + i.getUse());
				}
			}
			Menu.InventoryMenu();
		}
		else System.out.println("We require at least 20 gold worth of items before cashing out!");
		Menu.MainMenu();
	}
	public double getIncChance() {
		// TODO Auto-generated method stub
		return incChance;
	}
}
