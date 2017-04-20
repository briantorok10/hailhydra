package Model;


/* Author: Jose Moreno */

public class Puzzle
{
	private String puzzleName, puzzleID, solution, description, correctMSG, incorrectMSG, hint;
	private boolean isSolved;
	//private Item item;
	public Puzzle(String puzzleName, String puzzleID, String solution, String description, String correctMSG,
			String incorrectMSG, String hint, boolean isSolved/*, Item item*/)
	{
		this.puzzleName = puzzleName;
		this.puzzleID = puzzleID;
		this.solution = solution;
		this.description = description;
		this.correctMSG = correctMSG;
		this.incorrectMSG = incorrectMSG;
		this.hint = hint;
		this.isSolved = isSolved;
		//this.item = item;
	}
	public String getPuzzleName()
	{
		return puzzleName;
	}
	public void setPuzzleName(String puzzleName)
	{
		this.puzzleName = puzzleName;
	}
	public String getPuzzleID()
	{
		return puzzleID;
	}
	public void setPuzzleID(String puzzleID)
	{
		this.puzzleID = puzzleID;
	}
	public String getSolution()
	{
		return solution;
	}
	public void setSolution(String solution)
	{
		this.solution = solution;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getCorrectMSG()
	{
		return correctMSG;
	}
	public void setCorrectMSG(String correctMSG)
	{
		this.correctMSG = correctMSG;
	}
	public String getIncorrectMSG()
	{
		return incorrectMSG;
	}
	public void setIncorrectMSG(String incorrectMSG)
	{
		this.incorrectMSG = incorrectMSG;
	}
	public String getHint()
	{
		return hint;
	}
	public void setHint(String hint)
	{
		this.hint = hint;
	}
	public boolean isSolved()
	{
		return isSolved;
	}
	public void setSolved(boolean isSolved)
	{
		this.isSolved = isSolved;
	}
	/*
	public Item getItem()
	{
		return item;
	}
	public void setItem(Item item)
	{
		this.item = item;
	}
	*/
	
	
	
		
}