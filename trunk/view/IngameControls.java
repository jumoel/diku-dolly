/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;
import controller.DifficultyAction;
import controller.HelpAction;

/**
 * @author Julian
 *
 */
public class IngameControls extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1310963790966866671L;

	public IngameControls(final Component frame,
			DifficultyAction difficultyAction,
			HelpAction helpAction) {
		
		this.setLayout(new GridLayout(1, 2, 0, 0));
		
		SudokuButton helpButton = new SudokuButton("help.png");
		helpButton.addActionListener(helpAction);
		this.add(helpButton);
		
		SudokuButton newButton = new SudokuButton("newGame.png");
		newButton.addActionListener(difficultyAction);
		this.add(newButton);
		
		this.setOpaque(false);
		
		this.setSize(300, 100);
	}
}
