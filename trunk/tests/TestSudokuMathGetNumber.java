package tests;

import junit.framework.TestCase;
import model.Board;
import model.SudokuMath;

/**
 * The JUnit TestCase Class for the getXNumber methods used in SudokuMath.
 */
public class TestSudokuMathGetNumber extends TestCase {
	
	/**
	 * This tests the first of the get-methods: getRowNumber(). 
	 */
	public void testGetRowNumber() {
		/*
		 * A board is created with fieldIds marked that we will be testing.
		 * One number has been chosen for each row. 
		 */
		Board testBoard = new Board(new int[] {
				 0,  0,  2,  0,  0,  0,  0,  0,  0,
				 0,  0,  0,  0, 13,  0,  0,  0,  0,
				 0,  0,  0,  0,  0,  0,  0,  25, 0,
				27,  0,  0,  0,  0,  0,  0,  0,  0,
				 0,  0,  0,  0,  0,  0, 42,  0,  0,
				 0,  0,  0, 48,  0,  0,  0,  0,  0,
				 0,  0,  0,  0,  0, 59,  0,  0,  0,
				 0, 64,  0,  0,  0,  0,  0,  0,  0,
				 0,  0,  0,  0,  0,  0,  0,  0, 80}		
		);

		/*
		 * Tests that the expected values are true for all the different rows.
		 * Using: getRowNumber(fieldId, gameSettings).
		 */
		assertTrue(SudokuMath.getRowNumber(2, testBoard.getSettings()) == 0);
		assertTrue(SudokuMath.getRowNumber(13, testBoard.getSettings()) == 1);
		assertTrue(SudokuMath.getRowNumber(25, testBoard.getSettings()) == 2);
		assertTrue(SudokuMath.getRowNumber(27, testBoard.getSettings()) == 3);
		assertTrue(SudokuMath.getRowNumber(42, testBoard.getSettings()) == 4);
		assertTrue(SudokuMath.getRowNumber(48, testBoard.getSettings()) == 5);
		assertTrue(SudokuMath.getRowNumber(59, testBoard.getSettings()) == 6);
		assertTrue(SudokuMath.getRowNumber(64, testBoard.getSettings()) == 7);
		assertTrue(SudokuMath.getRowNumber(80, testBoard.getSettings()) == 8);
	}

	/**
	 * This tests the second of the get-methods: getColumnNumber(). 
	 */
	public void testGetColumnNumber() {
		/*
		 * A board is created with fieldIds marked that we will be testing.
		 * One number has been chosen for each column. 
		 */
		Board testBoard = new Board(new int[] {
				 0,  0,  2,  0,  0,  0,  0,  0,  0,
				 0,  0,  0,  0, 13,  0,  0,  0,  0,
				 0,  0,  0,  0,  0,  0,  0,  25, 0,
				27,  0,  0,  0,  0,  0,  0,  0,  0,
				 0,  0,  0,  0,  0,  0, 42,  0,  0,
				 0,  0,  0, 48,  0,  0,  0,  0,  0,
				 0,  0,  0,  0,  0, 59,  0,  0,  0,
				 0, 64,  0,  0,  0,  0,  0,  0,  0,
				 0,  0,  0,  0,  0,  0,  0,  0, 80}		
		);

		/*
		 * Tests that the expected values are true for all the different column.
		 * Using: getColumnNumber(fieldId, gameSettings).
		 */
		assertTrue(SudokuMath.getColumnNumber(27, testBoard.getSettings()) == 0);
		assertTrue(SudokuMath.getColumnNumber(64, testBoard.getSettings()) == 1);
		assertTrue(SudokuMath.getColumnNumber(2, testBoard.getSettings()) == 2);
		assertTrue(SudokuMath.getColumnNumber(48, testBoard.getSettings()) == 3);
		assertTrue(SudokuMath.getColumnNumber(13, testBoard.getSettings()) == 4);
		assertTrue(SudokuMath.getColumnNumber(59, testBoard.getSettings()) == 5);
		assertTrue(SudokuMath.getColumnNumber(42, testBoard.getSettings()) == 6);
		assertTrue(SudokuMath.getColumnNumber(25, testBoard.getSettings()) == 7);
		assertTrue(SudokuMath.getColumnNumber(80, testBoard.getSettings()) == 8);	
	}	
	
	/**
	 * This tests the third of the get-methods: getQuadrantNumber(). 
	 */
	public void testGetQuadrantNumber() {
		/*
		 * A board is created with fieldIds marked that we will be testing.
		 * One number has been chosen for each quadrant. 
		 */
		Board testBoard = new Board(new int[] {
				 0,  0,  2,  0,  0,  0,  0,  0,  0,
				 0,  0,  0,  0, 13,  0,  0,  0,  0,
				 0,  0,  0,  0,  0,  0,  0,  25, 0,
				27,  0,  0,  0,  0,  0,  0,  0,  0,
				 0,  0,  0,  0,  0,  0, 42,  0,  0,
				 0,  0,  0, 48,  0,  0,  0,  0,  0,
				 0,  0,  0,  0,  0, 59,  0,  0,  0,
				 0, 64,  0,  0,  0,  0,  0,  0,  0,
				 0,  0,  0,  0,  0,  0,  0,  0, 80}		
		);

		/*
		 * Tests that the expected values are true for all the different quadrant.
		 * Using: getQuadrantNumber(fieldId, gameSettings).
		 */
		assertTrue(SudokuMath.getQuadrantNumber(2, testBoard.getSettings()) == 0);
		assertTrue(SudokuMath.getQuadrantNumber(13, testBoard.getSettings()) == 1);
		assertTrue(SudokuMath.getQuadrantNumber(25, testBoard.getSettings()) == 2);
		assertTrue(SudokuMath.getQuadrantNumber(27, testBoard.getSettings()) == 3);
		assertTrue(SudokuMath.getQuadrantNumber(48, testBoard.getSettings()) == 4);
		assertTrue(SudokuMath.getQuadrantNumber(42, testBoard.getSettings()) == 5);
		assertTrue(SudokuMath.getQuadrantNumber(64, testBoard.getSettings()) == 6);
		assertTrue(SudokuMath.getQuadrantNumber(59, testBoard.getSettings()) == 7);
		assertTrue(SudokuMath.getQuadrantNumber(80, testBoard.getSettings()) == 8);	
	}
}