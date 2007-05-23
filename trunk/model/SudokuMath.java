/**
 * 
 */
package model;

/**
 * Performs various mathematical operations on
 * Sudokuboards.
 * 
 * @author Julian
 *
 */
public abstract class SudokuMath {
	/**
	 * Gets the contents of the row based on
	 * the position in the board.
	 * @param position The position to get the row from.
	 * @param board The board to get the row from.
	 * @return An int-array containing the row.
	 */
	public static int[] getRowFromPos(int position, Board board) {
		return null;
	}
	
	/**
	 * Gets the contents of the column based on
	 * the position in the board.
	 * @param position The position to get the column from.
	 * @param board The board to get the column from.
	 * @return An int-array containing the column.
	 */
	public static int[] getColumnFromPos(int position, Board board) {
		return null;
	}
	
	/**
	 * Gets the contents of the quadrant based on
	 * the position in the board.
	 * @param position The position to get the quadrant from.
	 * @param board The board to get the cquadrant from.
	 * @return An int-array containing the quadrant.
	 */
	public static int[] getQuadrantFromPos(int position, Board board) {
		return null;
	}
	
	public static int getRowNumber(int position) {
		return 0;
	}
	
	public static int getColumnNumber(int position) {
		return 0;
	}
	
	public static int getQuadrantNumber(int position) {
		return 0;
	}
}
