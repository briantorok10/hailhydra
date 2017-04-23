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
	public long getValue()
	{
		return value;
	}
	public void effect()
	{
	}//should be used by each item type (add points, increase luck, etc.)
		
}
