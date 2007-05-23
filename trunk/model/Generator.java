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
	
	public void generate(Board board, GameSettings settings) {
		
		// TODO: gør den rekursiv så den laver hele boardet.
		
		Random random = new Random();
		// TODO: random(81) er et magisk tal, skal hentes fra model.gamesettings.boardSize eller lign
		
		/*
		 * Selects a random place on the gameboard.
		 */
		int fieldId = random.nextInt(81);	
		
		
		/*
		 * If the field in empty (already removed) the following field is selected.
		 */
		// TODO: 80 = magic number
		while (board.getValue(fieldId) == 0) {
			fieldId = (fieldId + 1) % 80;
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
				fieldId = (fieldId + 1) % 80;
			}
			currentValue = board.getValue(fieldId);
			board.setValue(fieldId, 0);
				
			}

	}
}
