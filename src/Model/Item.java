package Model;

import java.io.Serializable;

/**
 * 
 * @author Jose Moreno
 *
 */
public abstract class Item implements Serializable //needs to be abstract for effect() method
{
	private String name;
	private String description;
	private int itemID;
	public Item(String name, String description, int itemID)
	{
		this.name = name;
		this.description = description;
		this.itemID = itemID;
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
	
	public abstract void effect();//should be used by each item type (add points, increase luck, etc.)
		
}
