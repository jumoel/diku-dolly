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
	
	private DifficultyAction difficultyAction;
	private HelpAction helpAction;

	public IngameControls(final Component frame,
			DifficultyAction difficultyAction,
			HelpAction helpAction) {
		
		this.setLayout(new GridLayout(1, 2, 0, 0));
		
		this.difficultyAction = difficultyAction;
		this.helpAction = helpAction;
		
		SudokuButton helpButton = new SudokuButton("help.png");
		helpButton.addActionListener(this.helpAction);
		this.add(helpButton);
		
		SudokuButton newButton = new SudokuButton("newGame.png");
		newButton.addActionListener(this.difficultyAction);
		this.add(newButton);
		
		this.setOpaque(false);
		
		this.setSize(300, 100);
	}

	public DifficultyAction getDifficultyAction() {
		return difficultyAction;
	}

	public HelpAction getHelpAction() {
		return helpAction;
	}
	
	
}
