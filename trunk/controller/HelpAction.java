package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import view.MainInterface;
import view.ViewSettings;

/**
 * Takes care of finding and showing help to the user.
 */
public class HelpAction extends AbstractAction {
	/**
	 * Classes that implement <code>Serializable</code> needs this.
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = -8116137103326969261L;
	
	private MainInterface frame;
	private model.Game game;
	
	public HelpAction(MainInterface frame, model.Game game) {
		this.frame = frame;
		this.game = game;
	}

	/**
	 * If there are mistakes on the board, these gets marked.
	 * Otherwise it finds a solvable field (if any) and marks
	 * it on the board.
	 */
	public void actionPerformed(ActionEvent e) {
		
		/*
		 * int value containing the fieldId that's being hinted at,
		 * if help can be given.
		 */
		int hint = 0;
		
		/*
		 * It is checked whether or not there is a solveable field.
		 * If not, the Exception thrown by findSolveable() is caught,
		 * and the SheepSpeak tells the user that an error accured, urging
		 * the user to start a new game.
		 * 
		 * If no Exception is caught, the fieldId is saved in the hint value
		 * for later use.
		 */
		try {
			hint = model.Helper.findSolveable(game);
		} catch (NoSuchFieldException exception) {
			((view.MainInterface)frame).getSheepSpeak().setText(exception.getMessage()
					+ "<br><br>Start en ny sudoku.");
		}
		
		/*
		 * The amount of mistakes on the board is gathered.
		 */
		int amountOfMistakes = model.Helper.getAmountOfMistakes(game);
		
		/*
		 * It is then tested if there is any mistakes on the board,
		 * based on the value of amountOfMistakes. 
		 */
		if (amountOfMistakes > 0) {
			
			/*
			 * Mistakes has been found on the board, so fields with errors
			 * are marked on the board with the WrongNumberColor.
			 */
			((view.MainInterface)frame).getBoard().clearHintNotices();
			((view.MainInterface)frame).getBoard().setNotices(
					model.Helper.getFieldsWithMistakes(game, amountOfMistakes), 
					ViewSettings.getWrongNumberColor());
			
			/*
			 * Next, the statistics get updated with the amount of mistakes made.
			 */
			game.getStatistics().increaseMistakesBy(amountOfMistakes);

			/*
			 * Lastly, SheepSpeak tells the user that there has been made mistakes.
			 */
			((view.MainInterface)frame).getSheepSpeak().setText(
				"Ups, du har vist lavet fejl.");
		} else {

			/*
			 * No mistakes has been found on the board, so the fieldId
			 * with the value hint is marked on the board with the HintColor. 
			 */
			((view.MainInterface)frame).getBoard().clearNotices();
			((view.MainInterface)frame).getBoard().setNotice(
					hint, ViewSettings.getHintColor());

			/*
			 * The SheepSpeak then tells the user that the field can be solved,
			 * and only has one solution.
			 */
			((view.MainInterface)frame).getSheepSpeak().setText(
				"Prøv at løse den grønne firkant.<br><br>Den kan kun være ét tal.");
		}
		/*
		 * The amount of hints used is increased in the statistics.
		 */
		this.game.getStatistics().increaseHints();
	}
}