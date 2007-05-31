/**
 * 
 */
package model;

/**
 * Performs various mathematical operations on SudokuBoards.
 * Everything is 0-index'ed. 
 * Fx. a row from a 3x3x9 Sudoku has the numbers 0 to 8.
 * 
 * @author Emil
 */
public abstract class SudokuMath {
	
	/**
	 * Converts a position to a rownumber, 
	 * by calculating (position / boardDimension).
	 * 
	 * @param position The position on the board.
	 * @return The number of the row.
	 */
	public static int getRowNumber(int position, GameSettings settings) {
		return (position / settings.getBoardDimensions());
	}
	
	/**
	 * Converts a position to a columnnumber, 
	 * by calculating (position % boardDimension).
	 * 
	 * @param position The position on the board.
	 * @return The number of the column.
	 */
	public static int getColumnNumber(int position, GameSettings settings) {
		return (position % settings.getBoardDimensions());
	}
	
	/**
	 * Converts a position to a quadrantnumber, by calculating
	 * ((rowNumber / quadrantDim) * quadrantDim + columnNumber / quadrantDim).
	 * 
	 * @param position The position on the board.
	 * @return The number of the quadrant.
	 */
	public static int getQuadrantNumber(int position, GameSettings settings) {
		int quadrantDim = settings.getQuadrantDimension();
		return ((getRowNumber(position, settings) / quadrantDim) * quadrantDim + 
				(getColumnNumber(position, settings) / quadrantDim));
	}
	
	/**
	 * Gets the contents of the row based on the position in the board.
	 * This is done by substracting the columnNumber from the position value,
	 * and adding values to an int-array until it has reached the length
	 * of the boardDimension. 
	 * 
	 * @param position The position to get the row from.
	 * @param board The board to get the row from.
	 * @return An int-array containing the row.
	 */
	public static int[] getRowFromPos(int position, Board board) {
		int boardDim = board.getSettings().getBoardDimensions();
		int[] rowResult = new int[boardDim];
		
		for(int rowPosition = position - getColumnNumber(position, board.getSettings()), 
				positionInArray = 0; positionInArray < boardDim; 
				rowPosition = rowPosition + 1, positionInArray = positionInArray + 1) {
			rowResult[positionInArray] = board.getValue(rowPosition);
		}
		return rowResult;
	}
	
	/**
	 * Gets the contents of the column based on the position in the board.
	 * This is done by first calculating the columnNumber, 
	 * adding the value this position contains to an array, 
	 * and then continuously adding boardDim to the columnNumber, 
	 * adding that value to the array until the array has boardDimension 
	 * values in it.
	 * 
	 * @param position The position to get the column from.
	 * @param board The board to get the column from.
	 * @return An int-array containing the column.
	 */
	public static int[] getColumnFromPos(int position, Board board) {
		int boardDim = board.getSettings().getBoardDimensions();
		int[] columnResult = new int[boardDim];
		int columnNum = getColumnNumber(position, board.getSettings());
		
		for(int positionInArray = 0; positionInArray < boardDim; 
				positionInArray = positionInArray + 1) {
			columnResult[positionInArray] = board.getValue(columnNum);
			columnNum = columnNum + boardDim;
		}
		return columnResult;
	}
	
	/**
	 * Gets the contents of the quadrant based on the position in the board.
	 * TODO: Elaborate on how this works (as there is no mathematic solution yet
	 * this is pending - it works though!).
	 * 
	 * @param position The position to get the quadrant from.
	 * @param board The board to get the cquadrant from.
	 * @return An int-array containing the quadrant.
	 */
	public static int[] getQuadrantFromPos(int position, Board board) {
		int boardDim = board.getSettings().getBoardDimensions();
		int quadDim = board.getSettings().getQuadrantDimension();
		int quadrantNum = getQuadrantNumber(position, board.getSettings());
		int[] quadrantResult = new int[boardDim];
		
		int quadStartPos = ((quadrantNum % quadDim) * quadDim) + 
		  ((quadrantNum / quadDim) * (boardDim * quadDim));
		
		for (int iter = 0; iter < boardDim; iter = iter + 1) {
			quadrantResult[iter] = board.getValue(quadStartPos + 
					(iter % quadDim) + (iter / quadDim) * (boardDim));
		 	
		}
		return quadrantResult;
	}
}