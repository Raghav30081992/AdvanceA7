package genericlib;

import java.util.Random;

/**
 * 
 * @author Raghav Maheshwari
 *
 */
public class JavaUtil {
	/**
	 * Method to generate random number.
	 * @return
	 */
	
	public int getRandomNo()
	{
		Random r = new Random();
		return r.nextInt(100);
	}
}
