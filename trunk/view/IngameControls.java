package view;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;
import controller.DifficultyAction;
import controller.HelpAction;

/**
 * The ingamecontrols (Help- and New Game-button)
 */
public class IngameControls extends JPanel {
	/**
	 * Classes that implement <code>Serializable</code> needs this.
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = -1310963790966866671L;
	
	private DifficultyAction difficultyAction;
	private HelpAction helpAction;

	/**
	 * Creates the controls.
	 * @param frame The frame the screen should be added to.
	 * @param difficultyAction The DifficultyAction showing the New Game-screen.
	 * @param helpAction The HelpAction handling requests for help.
	 */
	public IngameControls(final Component frame,
			DifficultyAction difficultyAction,
			HelpAction helpAction) {
		
		this.setLayout(new GridLayout(1, 2, 0, 0));
		
		this.difficultyAction = difficultyAction;
		this.helpAction = helpAction;
		
		/*
		 * Create the buttons and add the actions.
		 */
		SudokuButton helpButton = new SudokuButton("help.png");
		helpButton.addActionListener(this.helpAction);
		this.add(helpButton);
		
		SudokuButton newButton = new SudokuButton("newGame.png");
		newButton.addActionListener(this.difficultyAction);
		this.add(newButton);
		
		this.setOpaque(false);
		this.setSize(300, 100);
	}

	/**
	 * Gets the DifficultyAction associated with the controls.
	 * @return The DifficultyAction
	 */
	public DifficultyAction getDifficultyAction() {
		return difficultyAction;
	}

	/**
	 * Gets the HelpAction associated with the controls.
	 * @return The HelpAction
	 */
	public HelpAction getHelpAction() {
		return helpAction;
	}
	
	
}
