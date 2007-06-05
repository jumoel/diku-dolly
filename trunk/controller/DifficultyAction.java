/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import view.MainInterface;

/**
 * @author Julian
 *
 */
public class DifficultyAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1598929066322541006L;

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	private MainInterface component;
	model.Game game;
	Boolean firstScreen;
	public DifficultyAction(MainInterface component, model.Game game, Boolean firstScreen) {
		super("DifficultyAction");
		this.game = game;
		this.component = component;
		this.firstScreen = firstScreen;
	}
	
	public void actionPerformed(ActionEvent e) {
		Boolean showScreen = true;
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
		
		if (showScreen) {		
			view.DifficultySelection selection = new view.DifficultySelection(game);
			selection.show(component);
		}
	}

}
