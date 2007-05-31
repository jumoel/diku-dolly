/**
 * 
 */
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 * @author Julian
 *
 */
public class NumberAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3042742452358674456L;
	
	private model.Game game;
	private view.Board board;
	private int fieldId;
	private Component frame;
	public NumberAction(model.Game game, view.Board board, int fieldId, Component frame) {
		this.game = game;
		this.board = board;
		this.fieldId = fieldId;
		this.frame = frame;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		Object[] possibilities = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String s = (String)JOptionPane.showInputDialog(
		                    frame,
		                    "Vælg et tal:\n",
		                    "Vælg et tal",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibilities,
		                    "1");
		if (s != null) {
			int value = Integer.parseInt(s);
			board.setValue(fieldId, value);
			board.updateUI();
			game.getCurrentBoard().setValue(fieldId, value);
		}
	}

}
