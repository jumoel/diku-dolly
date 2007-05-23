package model;

import java.util.Random;

/**
 * @author Julian
 *
 */
public abstract class Generator {
	
/**
 * Generates a playable gameboard removing one field at a time untill the 
 * desired difficulty is achieved.
 * @param board
 * @param settings
 */
	
	public static void generate(Board board, GameSettings settings) {
		Random random = new Random();
		
		for (int i = 0; i < settings.getNumbersToRemove(); i = i + 1) {
			removeField(board, random, settings);
		}
	}
	
	private static void removeField (Board board, Random random, GameSettings settings) {
		

		
		/*
		 * Selects a random place on the gameboard.
		 */
		int fieldId = random.nextInt(settings.getBoardLength());	
		
		
		/*
		 * If the field in empty (already removed) the following field is selected.
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
