/**
 * 
 */
package model;

import java.util.Random;

/**
 * @author Steen
 *
 */
public abstract class Generator {
	
/**
 * Generates a playable gameboard removing one field at a time untill the 
 * desired difficulty is achieved.
 * @param board The board to remove fields from.
 * @param settings The board settings (board size)
 */
	
	public static void generate(Board board, GameSettings settings) {
		
		/*
		 * Creates a random to be used to select a random field.
		 */
		Random random = new Random();
		/*
		 * calls removeField untill the desired number of fields are removed.
		 */
		for (int i = 0; i < settings.getNumbersToRemove(); i = i + 1) {
			removeField(board, random, settings);
		}
	}
	public static void generate(Board board) {
		generate(board, board.getSettings());
	}
	
	/*
	 * Removes a single random field (if it is solveable) from the gameboard.
	 */
	private static void removeField (Board board,
										Random random,
										GameSettings settings) {
		

		
		/*
		 * Selects a random place on the gameboard.
		 */
		int fieldId = random.nextInt(settings.getBoardLength());	
		
		
		/*
		 * If the field in empty (already removed) the following field 
		 * is selected.
		 */
		while (board.getValue(fieldId) == 0) {
			fieldId = (fieldId + 1) % settings.getBoardLength();
		}
		
		/*
		 * Stores the value of the currently selected field in currentValue.
		 * Sets the fields value to 0 (empty)
		 */
		int currentValue = board.getValue(fieldId);
		board.setValue(fieldId, 0);
		
		/*
		 * If the selected (and removed) field cannot be solved by the sudoku 
		 * solver, the field is reset to its previous value and the next field
		 * in line is examined.
		 */
		while (Solver.solveField(fieldId, board) == 0) {

			board.setValue(fieldId, currentValue);
			fieldId = fieldId + 1;
			while (board.getValue(fieldId) == 0) {
				fieldId = (fieldId + 1) % settings.getBoardLength();
			}
			currentValue = board.getValue(fieldId);
			board.setValue(fieldId, 0);
				
		}

	}
}
