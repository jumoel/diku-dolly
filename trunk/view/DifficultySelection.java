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

/**
 * @author Julian
 *
 */
public class DifficultySelection {
	/*
	 * The value to pass on to the calling function.
	 */
	protected int returnvalue;
	
	public DifficultySelection() {
	}
	public int show(Component frame) {
		/*
		 * Creates a new modal Dialog-frame.
		 */
		final JDialog dialog = new JDialog((Frame)frame, "Vælg en sværhedsgrad", true);
		
		JLayeredPane layeredPane = dialog.getLayeredPane();
		
		dialog.setSize(new Dimension(700, 500));
		dialog.setPreferredSize(dialog.getSize());
		dialog.setUndecorated(true);

		JPanel panel = new JPanel();
			SudokuButton easy = new SudokuButton("easy.png");
			SudokuButton medium = new SudokuButton("medium.png");
			SudokuButton hard = new SudokuButton("hard.png");
			
			easy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dialog.setVisible(false);
					returnvalue = 0;
				}
			});
			
			medium.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dialog.setVisible(false);
					returnvalue = 1;
				}
			});
			
			hard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dialog.setVisible(false);
					returnvalue = 2;
				}
			});
			
			panel.setLayout(new GridLayout(3, 1, 5, 5));
			panel.add(easy);
			panel.add(medium);
			panel.add(hard);
			panel.setSize(150, 300);
			panel.setOpaque(false);
			
			panel.setLocation(300, 110);
		
		layeredPane.add(panel, 2);
		Background background = new Background("startScreen.png");
		background.setSize(700, 500);
		layeredPane.add(background, 3);
		
		PlaceCenter.placeCenter(dialog);
		dialog.pack();
		dialog.setVisible(true);
		
		return returnvalue;
	}
}
