package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Starts a new game based on the user's selection
 */
public class DifficultySelectionAction extends AbstractAction {
	/**
	 * Classes that implement <code>Serializable</code> needs this.
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 4675487524964772531L;
	
	private model.Game game;
	private Component frame;
	
	public DifficultySelectionAction(model.Game game, Component frame) {
		this.game = game;
		this.frame = frame;
	}

	/**
	 * Starts a new game based on the ActionCommand
	 * sent when the user clicked one of the difficultybuttons.
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
