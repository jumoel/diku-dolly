/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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
	public DifficultyAction(MainInterface component, model.Game game) {
		super("DifficultyAction");
		this.game = game;
		this.component = component;
	}
	
	public void actionPerformed(ActionEvent e) {
		view.DifficultySelection selection = new view.DifficultySelection(game);
		selection.show(component);
	}

}
