/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controller.DifficultyAction;

import model.Game;

/**
 * @author Julian
 *
 */
public class CongratulationScreen {
	public CongratulationScreen() {
	}
	public void show(Component frame, Game game) {
		/*
		 * Creates a new modal Dialog-frame.
		 */
		final JDialog dialog = new JDialog((Frame)frame, "Tillykke", false);
		
		JLayeredPane layeredPane = dialog.getLayeredPane();
		
		dialog.setSize(new Dimension(700, 500));
		dialog.setPreferredSize(dialog.getSize());
		dialog.setUndecorated(true);

		JPanel panel = new JPanel();
			SudokuButton newGame = new SudokuButton("newGame.png");
			
			newGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dialog.setVisible(false);
					dialog.dispose();
				}
			});
			newGame.addActionListener(new DifficultyAction(frame, game));
			
			panel.setLayout(new GridLayout(1, 1, 5, 5));
			panel.add(newGame);
			panel.setSize(150, 100);
			panel.setOpaque(false);
			
			panel.setLocation(100, 300);
		
		layeredPane.add(panel, 2);
		Background background = new Background("congratulations.png");
		background.setSize(700, 500);
		layeredPane.add(background, 3);

		dialog.setLocation(((MainWindow)frame).getBackgroundPanel().getLocationOnScreen());
		dialog.pack();
		dialog.setVisible(true);
	}
}
