/**
 * 
 */
package tests;

import model.*;

import junit.framework.TestCase;


/**
 * @author emil
 *
 */
public class Tests extends TestCase {
	
	/**
	 * First test of findSolveable():
	 * 
	 * Tests that the Helper returns an NoSuchFieldException
	 * when no solveable fieldId can be found.
	 */
	public void testFindSolveable01() {
		
		/*
		 * First we create an empty board.
		 */
		Board testBoard = new Board(new int[] {
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0}
		);
		
		/*
		 * Creates two Strings that's used to check if the test is true.
		 * result is the string our NoSuchFieldException returns if thrown,
		 * exception is string the catcher saves the getMessage() call to. 
		 */
		String result = "Der er ingen felter der kan løses.";
		String exception = "";
		
		/*
		 * Checks if the board has any solveable fields.
		 * If an exception is throw, it is caught, and the exception-string
		 * will now contain the error message.
		 * 
		 * This will happen as the Solver only returns a fieldId that has 1,
		 * and the board has no numbers placed at all.
		 */		
		try {
			Helper.findSolveable(testBoard, testBoard.getSettings());
		} catch (NoSuchFieldException e) {
			exception = e.getMessage();
		}
		/*
		 * Since the result string and the exception string is now the same, as:
		 * 
		 * String result = "Der er ingen felter der kan løses.";
		 * and the exception declaration in the Helper is
		 * throw new NoSuchFieldException("Der er ingen felter der kan løses.");
		 */
		assertTrue(result == exception);
	}
	
	/**
	 * Second test of findSolveable():
	 * 
	 * This test looks at the opposite of testFindSolveable01,
	 * namely when there is a field that can be solved, and that the correct
	 * fieldId is returned, plus no Exception is thrown.
	 */
	public void testFindSolveable02() {
		/*
		 * First we create an empty board, where the first quadrant has numbers
		 * filled in. In the fieldId, that has the value 10,
		 * only one solution, namely five, can be found.  
		 */
		Board testBoard = new Board(new int[] {
				1, 2, 3, 0, 0, 0, 0, 0, 0,
				4, 0, 6, 0, 0, 0, 0, 0, 0,
				7, 8, 9, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0}
		);
		
		/*
		 * A boolean is set to false to show that there has been no exception.
		 * An int is set to hold the fieldId which can be solved.
		 * For success, these two values have to be changed to true and 10. 
		 */
		boolean exceptionCaught = false;
		int solvedFieldId = 0;
		
		/*
		 * The findSolveable() is run, and in case of success return 10,
		 * while exceptionResult remains false.
		 */
		try {
			solvedFieldId = Helper.findSolveable(testBoard, testBoard.getSettings());
		} catch (NoSuchFieldException e) {
			exceptionCaught = true;
		}
		
		/*
		 * The result of findSolveable should now be 10, 
		 * and no exception has been caught.
		 */
		assertTrue(solvedFieldId == 10);
		assertFalse(exceptionCaught);
	}
	
	/**
	 * TODO: Lav flere tests!
	 */
	public void testWhichResultIsTrue() {
		
		Board testBoard = new Board(new int[] {
				1, 2, 3, 0, 0, 0, 0, 0, 0,
				4, 0, 6, 0, 0, 0, 0, 0, 0,
				7, 8, 9, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0}
		);
		
		assertTrue(true);
	}
}