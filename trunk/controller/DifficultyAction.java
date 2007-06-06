/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import view.MainInterface;

/**
 * Takes care of showing a New Game-dialog to the user
 * and start a new game based on their difficultychoice.
 */
public class DifficultyAction extends AbstractAction {
	/**
	 * Classes that implement <code>Serializable</code> needs this.
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 1598929066322541006L;

	private MainInterface component;
	model.Game game;
	Boolean firstScreen;
	
	/**
	 * Creates a DifficultyAction associated with the component and
	 * based on the game.
	 * 
	 * The firstScreen-flag determines if there should be an
	 * "Are you sure?"-dialog before showing the difficultyselection.
	 * 
	 * @param component The MainInterface to associate the action with
	 * @param game The game to reset if the user wants to start a new game
	 * @param firstScreen Enables the "Are you sure"-dialog if firstScreen is false
	 */
	public DifficultyAction(MainInterface component, model.Game game, Boolean firstScreen) {
		super("DifficultyAction");
		this.game = game;
		this.component = component;
		this.firstScreen = firstScreen;
	}
	
	public void actionPerformed(ActionEvent e) {
		Boolean showScreen = true;
		/*
		 * If it isn't the first screen, show the "Are you sure?"-dialog
		 * before showing the difficultyselection (and only if the user
		 * indeed is sure).
		 */
		if (!firstScreen) {
			Object[] options = {"Ja, start nyt spil",
			"Fortryd"};
			
			int result = JOptionPane.showOptionDialog(null,
							"Er du sikker på at du vil starte et nyt spil?",
							"Nyt spil?",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							options,
							options[1]);
			
			if (result != 0) {
				showScreen = false; 
			}
		}
		
		/*
		 * If the screen should indeed get showed, show it.
		 */
		if (showScreen) {		
			view.DifficultySelection selection = new view.DifficultySelection(game);
			selection.show(component);
		}
	}

}
