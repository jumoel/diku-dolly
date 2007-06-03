/**
 * 
 */
package model;

/**
 * @author Julian
 *
 */
public class EasySettings extends General9x9Settings implements GameSettings {
	public static final int IDENTIFIER = 1;
	
	private int numbersToRemove;
	
	public EasySettings()
	{
		super();
		numbersToRemove = 20;
	}

	public int getNumbersToRemove() {
		return numbersToRemove;
	}
}
