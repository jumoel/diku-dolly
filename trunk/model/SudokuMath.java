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
		int boardDim = board.getSettings().getBoardDimensions();
		int[] rowResult = new int[boardDim];
		
		for(int i = position - getColumnNumber(position, board.getSettings()), j = 0;
			i < boardDim; i++, j++) {
			rowResult[j] = board.getValue(i);
		}
		return rowResult;
	}
	
	/**
	 * Gets the contents of the column based on
	 * the position in the board.
	 * @param position The position to get the column from.
	 * @param board The board to get the column from.
	 * @return An int-array containing the column.
	 */
	public static int[] getColumnFromPos(int position, Board board) {
		int boardDim = board.getSettings().getBoardDimensions();
		int[] columnResult = new int[boardDim];
		int columnNum = getColumnNumber(position, board.getSettings());
		
		for(int i = 0; i < boardDim; i++) {
			columnResult[i] = board.getValue(columnNum);
			columnNum = columnNum + boardDim;
		}
		return columnResult;
	}
	
	/**
	 * Gets the contents of the quadrant based on
	 * the position in the board.
	 * @param position The position to get the quadrant from.
	 * @param board The board to get the cquadrant from.
	 * @return An int-array containing the quadrant.
	 */
	public static int[] getQuadrantFromPos(int position, Board board) {
		int boardDim = board.getSettings().getBoardDimensions();
		int[] quadrantResult = new int[boardDim];
		int quadrantNum = getQuadrantNumber(position, board.getSettings());
		
		// Incomming soon! O:-)
		
		return null;
	}
	
	/**
	 * Converts a position to a rownumber.
	 * @param position The position
	 * @return The rownumber
	 */
	public static int getRowNumber(int position, GameSettings settings) {
		return (position / settings.getBoardDimensions());
	}
	
	/**
	 * Converts a position to a columnnumber.
	 * @param position The position
	 * @return The columnnumber
	 */
	public static int getColumnNumber(int position, GameSettings settings) {
		return (position % settings.getBoardDimensions());
	}
	
	/**
	 * Converts a position to a quadrantnumber.
	 * The reason for adding and substracting 1 is because we're using 0-index,
	 * and thus by
	 * @param position The position
	 * @return the quadrandtnumber.
	 */
	public static int getQuadrantNumber(int position, GameSettings settings) {
		int quadrantDim = settings.getQuadrantDimension();
		return ((getRowNumber(position, settings) / quadrantDim) * quadrantDim + 
				(getColumnNumber(position, settings) / quadrantDim));
	}
}