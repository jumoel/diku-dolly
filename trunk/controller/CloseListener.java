package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class CloseListener implements WindowListener, ActionListener {
	private int getReallyExit() {
		Object[] options = {"Ja, afslut",
                			"Fortryd"};
		int n = JOptionPane.showOptionDialog(null,
					"Er du sikker på at du vil afslutte?",
					"Afslut?",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[1]);
		
		return n;
	}

	/**
	 * Doesn't need to do anything special.
	 */
	public void windowActivated(WindowEvent e) {}

	/**
	 * Doesn't need to do anything special.
	 */
	public void windowClosed(WindowEvent e) {}

	/**
	 * Checks whether or not the user is sure before
	 * closing the window.
	 */
	public void windowClosing(WindowEvent e) {
		if (getReallyExit() == 0) {
			System.exit(0);
		}
	}

	/**
	 * Doesn't need to do anything special.
	 */
	public void windowDeactivated(WindowEvent e) {}

	/**
	 * Doesn't need to do anything special.
	 */
	public void windowDeiconified(WindowEvent e) {}

	/**
	 * Doesn't need to do anything special.
	 */
	public void windowIconified(WindowEvent e) {}

	/**
	 * Doesn't need to do anything special.
	 */
	public void windowOpened(WindowEvent e) {}

	/**
	 * Checks whether or not the user is sure before
	 * closing the window.
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (getReallyExit() == 0) {
			System.exit(0);
		}
	}

}
