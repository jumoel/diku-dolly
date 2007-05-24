/**
 * 
 */
package model;

/**
 * @author Julian
 *
 */
public class NormalSettings implements GameSettings {
	private int[] stdBoardArray;
	private int[] validValues;
	private int QuadrantDimension;
	private int BoardDimensions;
	private int BoardLength;
	private int numbersToRemove;
	
	public NormalSettings()
	{
		/*
		board = new int[] {
					1, 2, 3, 4, 5, 6, 7, 8, 9,
					4, 5, 6, 7, 8, 9, 1, 2, 3,
					7, 8, 9, 1, 2, 3, 4, 5, 6,
					2, 3, 4, 5, 6, 7, 8, 9, 1,
					5, 6, 7, 8, 9, 1, 2, 3, 4,
					8, 9, 1, 2, 3, 4, 5, 6, 7,
					3, 4, 5, 6, 7, 8, 9, 1, 2,
					6, 7, 8, 9, 1, 2, 3, 4, 5,
					9, 1, 2, 3, 4, 5, 6, 7, 8
					};
		*/
		/*
		 * New board for added randomness :)
		 */
		stdBoardArray = new int[] {
					1, 2, 8, 6, 5, 3, 7, 9, 4,
					6, 3, 5, 7, 9, 4, 8, 2, 1,
					9, 7, 4, 1, 8, 2, 5, 6, 3,
					2, 4, 9, 8, 1, 7, 3, 5, 6,
					7, 6, 3, 9, 4, 5, 1, 8, 2,
					5, 8, 1, 3, 2, 6, 4, 7, 9,
					8, 5, 6, 4, 3, 9, 2, 1, 7,
					4, 9, 2, 5, 7, 1, 6, 3, 8,
					3, 1, 7, 2, 6, 8, 9, 4, 5
					};
		
		validValues = new int[] {1,2,3,4,5,6,7,8,9};
		
		QuadrantDimension = 3;
		BoardDimensions = QuadrantDimension * QuadrantDimension;
		BoardLength = BoardDimensions * BoardDimensions;
		numbersToRemove = 81;
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
