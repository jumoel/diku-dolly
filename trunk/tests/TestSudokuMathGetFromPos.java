package tests;

import java.util.Arrays;
import junit.framework.TestCase;
import model.Board;
import model.SudokuMath;

/**
 * The JUnit TestCase Class for the getXFromPos methods used in SudokuMath.
 */
public class TestSudokuMathGetFromPos extends TestCase {

	/**
	 * This tests the first of the getFromPos-methods: getRowFromPos().
	 */
	public void testGetRowFromPos() {
		/*
		 * A board is created with all fieldIds containing their value,
		 * for easier comparison. 
		 */
		Board testBoard = new Board(new int[] {
				 0,  1,  2,  3,  4,  5,  6,  7,  8,
				 9, 10, 11, 12, 13, 14, 15, 16, 17,
				18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31, 32, 33, 34, 35,
				36, 37, 38, 39, 40, 41, 42, 43, 44,
				45, 46, 47, 48, 49, 50, 51, 52, 53,
				54, 55, 56, 57, 58, 59, 60, 61, 62,
				63, 64, 65, 66, 67, 68, 69, 70, 71,
				72, 73, 74, 75, 76, 77, 78, 79, 80}
		);
		
		/*
		 * The results we expect when getting the different rows.
		 * The method always gets the row from left to right, not starting from
		 * the fieldId. 
		 */
		int[] expectedRow0 = new int[] { 0,  1,  2,  3,  4,  5,  6,  7,  8};
		int[] expectedRow1 = new int[] { 9, 10, 11, 12, 13, 14, 15, 16, 17};
		int[] expectedRow2 = new int[] {18, 19, 20, 21, 22, 23, 24, 25, 26};
		int[] expectedRow3 = new int[] {27, 28, 29, 30, 31, 32, 33, 34, 35};
		int[] expectedRow4 = new int[] {36, 37, 38, 39, 40, 41, 42, 43, 44};
		int[] expectedRow5 = new int[] {45, 46, 47, 48, 49, 50, 51, 52, 53};
		int[] expectedRow6 = new int[] {54, 55, 56, 57, 58, 59, 60, 61, 62};
		int[] expectedRow7 = new int[] {63, 64, 65, 66, 67, 68, 69, 70, 71};
		int[] expectedRow8 = new int[] {72, 73, 74, 75, 76, 77, 78, 79, 80};
		
		/*
		 * The tests of whether or not the expected arrays fits.
		 * As positions to check from we'll use 0, 10, 20.. etc.
		 */
		assertTrue(Arrays.equals(expectedRow0, SudokuMath.getRowFromPos( 0, testBoard)));
		assertTrue(Arrays.equals(expectedRow1, SudokuMath.getRowFromPos(10, testBoard)));
		assertTrue(Arrays.equals(expectedRow2, SudokuMath.getRowFromPos(20, testBoard)));
		assertTrue(Arrays.equals(expectedRow3, SudokuMath.getRowFromPos(30, testBoard)));
		assertTrue(Arrays.equals(expectedRow4, SudokuMath.getRowFromPos(40, testBoard)));
		assertTrue(Arrays.equals(expectedRow5, SudokuMath.getRowFromPos(50, testBoard)));
		assertTrue(Arrays.equals(expectedRow6, SudokuMath.getRowFromPos(60, testBoard)));
		assertTrue(Arrays.equals(expectedRow7, SudokuMath.getRowFromPos(70, testBoard)));
		assertTrue(Arrays.equals(expectedRow8, SudokuMath.getRowFromPos(80, testBoard)));
	}

	/**
	 * This tests the second of the getFromPos-methods: getColumnFromPos().
	 */
	public void testGetColumnFromPos() {
		/*
		 * A board is created with all fieldIds containing their value,
		 * for easier comparison. 
		 */		
		Board testBoard = new Board(new int[] {
				 0,  1,  2,  3,  4,  5,  6,  7,  8,
				 9, 10, 11, 12, 13, 14, 15, 16, 17,
				18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31, 32, 33, 34, 35,
				36, 37, 38, 39, 40, 41, 42, 43, 44,
				45, 46, 47, 48, 49, 50, 51, 52, 53,
				54, 55, 56, 57, 58, 59, 60, 61, 62,
				63, 64, 65, 66, 67, 68, 69, 70, 71,
				72, 73, 74, 75, 76, 77, 78, 79, 80}
		);
		
		/*
		 * The results we expect when getting the different columns.
		 * The method always gets the column from top to bottom, not starting from
		 * the fieldId.
		 */		
		int[] expectedColumn0 = new int[] { 0,  9, 18, 27, 36, 45, 54, 63, 72};
		int[] expectedColumn1 = new int[] { 1, 10, 19, 28, 37, 46, 55, 64, 73};
		int[] expectedColumn2 = new int[] { 2, 11, 20, 29, 38, 47, 56, 65, 74};
		int[] expectedColumn3 = new int[] { 3, 12, 21, 30, 39, 48, 57, 66, 75};
		int[] expectedColumn4 = new int[] { 4, 13, 22, 31, 40, 49, 58, 67, 76};
		int[] expectedColumn5 = new int[] { 5, 14, 23, 32, 41, 50, 59, 68, 77};
		int[] expectedColumn6 = new int[] { 6, 15, 24, 33, 42, 51, 60, 69, 78};
		int[] expectedColumn7 = new int[] { 7, 16, 25, 34, 43, 52, 61, 70, 79};
		int[] expectedColumn8 = new int[] { 8, 17, 26, 35, 44, 53, 62, 71, 80};		
		
		/*
		 * The tests of whether or not the expected arrays fits.
		 * As positions to check from we'll use 0, 10, 20.. etc.
		 */
		assertTrue(Arrays.equals(expectedColumn0, SudokuMath.getColumnFromPos( 0, testBoard)));
		assertTrue(Arrays.equals(expectedColumn1, SudokuMath.getColumnFromPos(10, testBoard)));
		assertTrue(Arrays.equals(expectedColumn2, SudokuMath.getColumnFromPos(20, testBoard)));
		assertTrue(Arrays.equals(expectedColumn3, SudokuMath.getColumnFromPos(30, testBoard)));
		assertTrue(Arrays.equals(expectedColumn4, SudokuMath.getColumnFromPos(40, testBoard)));
		assertTrue(Arrays.equals(expectedColumn5, SudokuMath.getColumnFromPos(50, testBoard)));
		assertTrue(Arrays.equals(expectedColumn6, SudokuMath.getColumnFromPos(60, testBoard)));
		assertTrue(Arrays.equals(expectedColumn7, SudokuMath.getColumnFromPos(70, testBoard)));
		assertTrue(Arrays.equals(expectedColumn8, SudokuMath.getColumnFromPos(80, testBoard)));
	}

	/**
	 * This tests the third of the getFromPos-methods: getQuadrantFromPos().
	 */
	public void testGetQuadrantFromPos() {
		/*
		 * A board is created with all fieldIds containing their value,
		 * for easier comparison. 
		 */		
		Board testBoard = new Board(new int[] {
				 0,  1,  2,  3,  4,  5,  6,  7,  8,
				 9, 10, 11, 12, 13, 14, 15, 16, 17,
				18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31, 32, 33, 34, 35,
				36, 37, 38, 39, 40, 41, 42, 43, 44,
				45, 46, 47, 48, 49, 50, 51, 52, 53,
				54, 55, 56, 57, 58, 59, 60, 61, 62,
				63, 64, 65, 66, 67, 68, 69, 70, 71,
				72, 73, 74, 75, 76, 77, 78, 79, 80}
		);
		
		/*
		 * The results we expect when getting the different quadrants.
		 * The method always gets the quadrant from top-left to bottom-right, 
		 * using normal reading left to right method, not starting from the fieldId.
		 */
		int[] expectedQuadrant0 = new int[] { 0,  1,  2,  9, 10, 11, 18, 19, 20};
		int[] expectedQuadrant1 = new int[] { 3,  4,  5, 12, 13, 14, 21, 22, 23};
		int[] expectedQuadrant2 = new int[] { 6,  7,  8, 15, 16, 17, 24, 25, 26};
		int[] expectedQuadrant3 = new int[] {27, 28, 29, 36, 37, 38, 45, 46, 47};
		int[] expectedQuadrant4 = new int[] {30, 31, 32, 39, 40, 41, 48, 49, 50};
		int[] expectedQuadrant5 = new int[] {33, 34, 35, 42, 43, 44, 51, 52, 53};
		int[] expectedQuadrant6 = new int[] {54, 55, 56, 63, 64, 65, 72, 73, 74};
		int[] expectedQuadrant7 = new int[] {57, 58, 59, 66, 67, 68, 75, 76, 77};
		int[] expectedQuadrant8 = new int[] {60, 61, 62, 69, 70, 71, 78, 79, 80};		
		
		/*
		 * The tests of whether or not the expected arrays fits.
		 * As positions to check from, we'll be trying each position of a quadrant 
		 * in the different quadrants.
		 * For example, the first quadrant will use fieldId 0, the second will use 4,
		 * and the last with use 80.
		 */
		assertTrue(Arrays.equals(expectedQuadrant0, SudokuMath.getQuadrantFromPos( 0, testBoard)));
		assertTrue(Arrays.equals(expectedQuadrant1, SudokuMath.getQuadrantFromPos( 4, testBoard)));
		assertTrue(Arrays.equals(expectedQuadrant2, SudokuMath.getQuadrantFromPos( 8, testBoard)));
		assertTrue(Arrays.equals(expectedQuadrant3, SudokuMath.getQuadrantFromPos(36, testBoard)));
		assertTrue(Arrays.equals(expectedQuadrant4, SudokuMath.getQuadrantFromPos(40, testBoard)));
		assertTrue(Arrays.equals(expectedQuadrant5, SudokuMath.getQuadrantFromPos(44, testBoard)));
		assertTrue(Arrays.equals(expectedQuadrant6, SudokuMath.getQuadrantFromPos(72, testBoard)));
		assertTrue(Arrays.equals(expectedQuadrant7, SudokuMath.getQuadrantFromPos(76, testBoard)));
		assertTrue(Arrays.equals(expectedQuadrant8, SudokuMath.getQuadrantFromPos(80, testBoard)));
	}	
}