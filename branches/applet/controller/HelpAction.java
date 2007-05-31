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
public class HelpAction extends AbstractAction {

	/**
	 * 
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
		JOptionPane.showMessageDialog(frame, "KIG HER: " + model.Helper.findSolveable(game));

	}

}
