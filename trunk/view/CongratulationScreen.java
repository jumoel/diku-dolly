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
 * @author Julian
 *
 */
public class CongratulationScreen {
	private JLayeredPane layeredPane;
	public CongratulationScreen() {
		layeredPane = new JLayeredPane();
	}
	
	public void show(MainInterface frame, Game game) {		
		layeredPane.setSize(new Dimension(700, 525));
		layeredPane.setPreferredSize(layeredPane.getSize());

		SudokuButton newGame = new SudokuButton("newGame.png");
		
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(false);
			}
		});
		
		newGame.addActionListener(new DifficultyAction(frame, game));
		newGame.setLocation(100, 350);
		layeredPane.add(newGame, 2);
		
		Statistics statistics = new Statistics(game);
		statistics.setLocation(50, 225);
		layeredPane.add(statistics, 3);
		
		Background background = new Background("congratulations.png");
		background.setSize(700, 525);
		layeredPane.add(background, 100);

		((MainInterface)frame).setGlassPane(layeredPane);
		layeredPane.setVisible(true);
	}
}
