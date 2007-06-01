/**
 * 
 */
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import view.ViewSettings;

/**
 * @author Julian
 *
 */
public class NumberAction extends AbstractAction {

	/**
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = -3042742452358674456L;
	
	private model.Game game;
	private view.Board board;
	private int fieldId;
	private Component frame;
	private view.MainWindow main;
	public NumberAction(view.MainWindow main, int fieldId, Component frame) {
		this.main = main;
		this.game = main.getGame();
		this.board = main.getBoard();
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
			board.clearNotices();
			
			board.setValue(fieldId, value);
			board.updateUI();
			game.getCurrentBoard().setValue(fieldId, value);
			
			/* 
			 * The following if-statement ensures that a field is colored
			 * red if wrong, white if correct. Furthermore, the SheepSpeak
			 * is updated to tell the user that there has been a mistake.
			 * 
			 * Before the statistics were added:
			 * main.getSheepSpeak().setText("Det ser jo ud til at gå fint.");
			 */
			if (game.getCurrentBoard().getValue(fieldId) == 
				game.getSolutionBoard().getValue(fieldId)) {
				main.getSheepSpeak().setText("Det ser jo ud til at gå fint.");
				/* 
				 * Sets the fieldcolor to white to ensure that the field gets
				 * the correct white color when the correct value is inserted.
				 */
				board.setNotice(fieldId, ViewSettings.getButtonBackground());
			} else {
				main.getSheepSpeak().setText("Hov, det var vidst et forkert tal.");
				board.setNotice(fieldId, ViewSettings.getWrongNumberColor());
				game.getStatistics().increaseMistakes();		
			}
			// End of Statistics-part
			
			if (game.getCurrentBoard().isEqualTo(game.getSolutionBoard())) {
				view.CongratulationScreen congratsScreen = new view.CongratulationScreen();
				congratsScreen.show(main, game);
			}
		}
	}

}
