/**
 * 
 */
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
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
	
	private Component frame;
	private model.Game game;
	
	public HelpAction(Component frame, model.Game game) {
		this.frame = frame;
		this.game = game;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		int hint = model.Helper.findSolveable(game);
		((view.MainWindow)frame).getBoard().setNotice(hint, ViewSettings.getLookHereHintColor());
		((view.MainWindow)frame).getSheepSpeak().setText("Se på den grønne firkant.<br><br>Den kan du nok løse.");
		/*
		 * The amount of hints used is increased in the statistics.
		 */
		this.game.getStatistics().increaseHints();
	}

}
