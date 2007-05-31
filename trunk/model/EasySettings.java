/**
 * 
 */
package model;

/**
 * @author Steen
 *
 */
public class EasySettings implements GameSettings {
	private int[] stdBoardArray;
	private int[] validValues;
	private int QuadrantDimension;
	private int BoardDimensions;
	private int BoardLength;
	private int numbersToRemove;
	
	public EasySettings()
	{
		stdBoardArray = new int[] {
					1, 2, 3, 4,
					4, 3, 2, 1,
					2, 1, 4, 3,
					3, 4, 1, 2
					};
		
		validValues = new int[] {1,2,3,4};
		
		QuadrantDimension = 2;
		BoardDimensions = QuadrantDimension * QuadrantDimension;
		BoardLength = BoardDimensions * BoardDimensions;
		/* 
		 * Makes the solver remove as many numbers as possible
		 * (because the board only contains 16 numbers, 14 will
		 * be impossible to remove).
		 */
		numbersToRemove = 14;
	}
	
	public int getQuadrantDimension() {
		return QuadrantDimension;
	}
	public int getBoardDimensions() {
			return BoardDimensions;
	}
	public int getBoardLength() {
		return BoardLength;
	}
	public int getNumbersToRemove() {
		return numbersToRemove;
	}
	public int[] getStdBoardArray() {
		return stdBoardArray;
	}
	public int[] getValidValues() {
		return validValues;
	}
}
