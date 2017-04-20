package Model;

/**
 * 
 * @author Jose Moreno
 *
 */
public class Sleep
{
	public static void Delay(long time)
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
