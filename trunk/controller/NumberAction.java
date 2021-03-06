package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Changes the number on the board based on a user's selection.
 */
public class NumberAction extends AbstractAction {
	/**
	 * Classes that implement <code>Serializable</code> needs this.
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = -3042742452358674456L;
	
	private model.Game game;
	private view.Board board;
	private int fieldId;
	private view.MainInterface main;
	public NumberAction(view.MainInterface main, int fieldId, Component frame) {
		this.main = main;
		this.game = main.getGame();
		this.board = main.getBoard();
		this.fieldId = fieldId;
	}

	/**
	 * Shows a dialog and changes the numbervalue 
	 * and the sheep's text based on the user's selection.
	 */
	public void actionPerformed(ActionEvent e) {
		view.NumberDialog dialog = new view.NumberDialog(main);
		
		int value = dialog.getValue();
		if (value != -1) {
			board.clearNotice(fieldId);
			
			board.setValue(fieldId, value);
			board.updateUI();
			game.getCurrentBoard().setValue(fieldId, value);
			
			/* 
			 * The following if-statement ensures that a field is colored
			 * red if wrong, white if correct. Furthermore, the SheepSpeak
			 * is updated to tell the user that there has been a mistake.
			 * 
			 * Before the statistics were added:
			 * main.getSheepSpeak().setText("Det ser jo ud til at g� fint.");
			 */
			if (value == 0) {
				main.getSheepSpeak().setText("Du ombestemte dig?");
			} else {
				main.getSheepSpeak().setText("Du kan trykke p� hj�lp, hvis du sidder fast.");
			}
			
			if (game.getCurrentBoard().isEqualTo(game.getSolutionBoard())) {
				game.getStatistics().setStopTime();
				view.CongratulationScreen congratsScreen = new view.CongratulationScreen();
				congratsScreen.show(main, game);
			}
		}
	}
}