/**
 * 
 */
package model;

import java.util.Random;

/**
 * @author Steen
 *
 */	
	
public abstract class Helper {

/**
 * Finds a field on the current board which is solveable and returns that 
 * field id. 
 * @param board The board from which the help is needed.
 * @param settings The game settings from which the board is created under.
 * @return fieldId A field that is solveable and suggested to the player.
 */

	public static int findSolveable(Board board, GameSettings settings) {
		
		int count = 0;
		
		/*
		 * Creates a random to be used to select a random field.
		 */
		Random random = new Random();
		
		/*
		 * Selects a random field from 0 to board length.
		 */
		int fieldId = random.nextInt(settings.getBoardLength());	
		
		/*
		 * If the solver cannont solve the targeted field or the field
		 * is already removed it will move on and try the following field.
		 */
		while (Solver.solveField(fieldId, board) == 0 || 
				board.getValue(fieldId) != 0) {
			count = count + 1;
			if (count >= settings.getBoardLength())
				break;
			fieldId = (fieldId + 1) % settings.getBoardLength();
		}
		
		return fieldId;
	}
	
	public static int findSolveable(Game game) {
		return findSolveable(game.getCurrentBoard(), game.getCurrentBoard().getSettings());
	}
	
	public static int getAmountOfMistakes(Game game) {
		Board currentBoard = game.getCurrentBoard();
		Board solutionBoard = game.getSolutionBoard();
		int numberOfMistakes = 0;
		
		for (int fieldId = 0;
			 fieldId < currentBoard.getSettings().getBoardLength(); 
			 fieldId = fieldId + 1) {
				if (currentBoard.getValue(fieldId) != solutionBoard.getValue(fieldId) &&
					currentBoard.getValue(fieldId) != 0) {
						numberOfMistakes = numberOfMistakes + 1;
				}
		}
		return numberOfMistakes;
	}
	
	public static int[] getFieldsWithMistakes(Game game, int amountOfMistakes) {
		Board currentBoard = game.getCurrentBoard();
		Board solutionBoard = game.getSolutionBoard();
		int[] wrongFields = new int[amountOfMistakes];
		
		for (int fieldId = 0, iter = 0; 
			 fieldId < currentBoard.getSettings().getBoardLength();
			 fieldId = fieldId + 1) {
				if (currentBoard.getValue(fieldId) != solutionBoard.getValue(fieldId) &&
					currentBoard.getValue(fieldId) != 0) {
						wrongFields[iter] = fieldId;
						iter = iter + 1;
				}
		}
		return wrongFields;
	}
	public static int[] getFieldsWithMistakes(Game game) {
		return getFieldsWithMistakes(game, getAmountOfMistakes(game));
	}
}
