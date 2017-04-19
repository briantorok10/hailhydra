package Model;

public class Sleep
{
	public void Delay(long time)
	{
		try
		{
			Thread.sleep(time);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
