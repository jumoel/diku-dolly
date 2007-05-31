/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Julian
 *
 */
public abstract class DifficultySelection {
	public static int show(Component frame) {
		JDialog dialog = new JDialog((Frame)frame, "Vælg en sværhedsgrad", false); // Sæt til true hvis modal
		
		JLayeredPane layeredPane = dialog.getLayeredPane();
		
		dialog.setSize(new Dimension(700, 500));
		dialog.setPreferredSize(dialog.getSize());
		dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		dialog.setUndecorated(true);

		JPanel panel = new JPanel();
			SudokuButton easy = new SudokuButton("easy.png");
			SudokuButton medium = new SudokuButton("medium.png");
			SudokuButton hard = new SudokuButton("hard.png");
			
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
		
		Object[] options = {"I'm too young to die",
	            					"Lol im avaarage",
	            					"SUPER DUPER GODLIKE LOLKEK-MODE!!!111ELEVEN"};
		
		int n = 0; /*JOptionPane.showOptionDialog(frame,
				"Vælg en sværhedsgrad, din goddamn newbie!",
				"^_^",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[2]); */
		
		return n;
	}
}
