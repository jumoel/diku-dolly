/**
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import controller.DifficultyAction;

import model.Game;

/**
 * A congratulationscreen used to congratulate the user
 * when they have completed a Sudokupuzzle.
 * 
 * Also shows the statistics.
 */
public class CongratulationScreen {
	private JLayeredPane layeredPane;
	public CongratulationScreen() {
		layeredPane = new JLayeredPane();
	}
	
	/**
	 * Shows a congratulationscreen
	 * @param frame The MainInterface to show the congratulationscreen on
	 * @param game The game to get the statistics from
	 */
	public void show(final MainInterface frame, Game game) {		
		layeredPane.setSize(new Dimension(700, 525));
		layeredPane.setPreferredSize(layeredPane.getSize());

		SudokuButton newGame = new SudokuButton("newGame.png");
		
		/*
		 * Hide the congratulationscreen when the user wants
		 * to start a new game...
		 */
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(false);
				((MainInterface)frame).showElements();
			}
		});
		
		/*
		 * ... and also show the difficultyselection.
		 */
		newGame.addActionListener(new DifficultyAction(frame, game, false));
		newGame.setLocation(100, 350);
		layeredPane.add(newGame, 2);
		
		/*
		 * Create and add the statistics.
		 */
		Statistics statistics = new Statistics(game);
		statistics.setLocation(50, 225);
		layeredPane.add(statistics, 3);
		
		/*
		 * Create and add the background.
		 */
		Background background = new Background("congratulations.png", new Dimension(700, 525));
		layeredPane.add(background, 100);

		((MainInterface)frame).hideElements();
		
		/*
		 * Set the congratulationscreen as the glasspane
		 * (which is on top of every other layer), and
		 * show the screen.
		 */
		((MainInterface)frame).setGlassPane(layeredPane);
		layeredPane.setVisible(true);
	}
}
