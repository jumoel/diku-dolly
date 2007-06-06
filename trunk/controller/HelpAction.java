/**
 * 
 */
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
		int hint = 0;
		try {
			hint = model.Helper.findSolveable(game);
		} catch (NoSuchFieldException exception) {
			((view.MainInterface)frame).getSheepSpeak().setText(exception.getMessage()
					+ "<br><br>Start en ny sudoku.");
		}
		int amountOfMistakes = model.Helper.getAmountOfMistakes(game); 
		if (amountOfMistakes > 0) {
			((view.MainInterface)frame).getBoard().clearHintNotices();
			((view.MainInterface)frame).getBoard().setNotices(
					model.Helper.getFieldsWithMistakes(game, amountOfMistakes), 
					ViewSettings.getWrongNumberColor());
			game.getStatistics().increaseMistakesBy(amountOfMistakes);
			((view.MainInterface)frame).getSheepSpeak().setText(
				"Ups, du har vist lavet fejl.");
		} else {
			((view.MainInterface)frame).getBoard().clearNotices();
			((view.MainInterface)frame).getBoard().setNotice(
					hint, ViewSettings.getHintColor());
			((view.MainInterface)frame).getSheepSpeak().setText(
				"Prøv at løse den grønne firkant.<br><br>Den kan kun være ét tal.");
		}
		/*
		 * The amount of hints used is increased in the statistics.
		 */
		this.game.getStatistics().increaseHints();
	}

}
