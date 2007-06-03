/**
 * 
 */
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * @author Julian
 *
 */
public class DifficultySelectionAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4675487524964772531L;
	
	private model.Game game;
	private Component frame;
	
	public DifficultySelectionAction(model.Game game, Component frame) {
		this.game = game;
		this.frame = frame;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		frame.setVisible(false);
		
		switch (Integer.parseInt(arg0.getActionCommand())) {
		case model.NormalSettings.IDENTIFIER:
			game.reset(new model.NormalSettings());
			break;
		case model.EasySettings.IDENTIFIER:
			game.reset(new model.EasySettings());
			break;
		case model.HardSettings.IDENTIFIER:
			game.reset(new model.HardSettings());
			break;
		default:
			game.reset(new model.NormalSettings());
			break;
		}
	}

}
