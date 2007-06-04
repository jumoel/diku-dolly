/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.MainInterface;
import view.ViewSettings;

/**
 * @author Julian
 *
 */
public class HelpAction extends AbstractAction {
	/**
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = -8116137103326969261L;
	
	private MainInterface frame;
	private model.Game game;
	
	public HelpAction(MainInterface frame, model.Game game) {
		this.frame = frame;
		this.game = game;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		int hint = model.Helper.findSolveable(game);
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
					hint, ViewSettings.getLookHereHintColor());
			((view.MainInterface)frame).getSheepSpeak().setText(
				"Se på den grønne firkant.<br><br>Den kan du nok løse.");
		}
		/*
		 * The amount of hints used is increased in the statistics.
		 */
		this.game.getStatistics().increaseHints();
	}

}
