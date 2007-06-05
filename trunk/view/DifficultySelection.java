/**
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.GridLayout;
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
	protected model.Game game;
	private JLayeredPane layeredPane;
	
	public DifficultySelection(model.Game game) {
		this.game = game;
		layeredPane = new JLayeredPane();
	}
	
	public void show(MainInterface frame) {		
		layeredPane.setSize(new Dimension(700, 525));
		layeredPane.setPreferredSize(layeredPane.getSize());
		
		controller.DifficultySelectionAction diffSelAction = new controller.DifficultySelectionAction(game, layeredPane);

		JPanel panel = new JPanel();
			SudokuButton easy = new SudokuButton("easy.png");
			SudokuButton normal = new SudokuButton("medium.png");
			SudokuButton hard = new SudokuButton("hard.png");
			
			easy.setActionCommand(Integer.toString(model.EasySettings.IDENTIFIER));
			easy.addActionListener(diffSelAction);
			easy.setVisible(true);
			
			normal.setActionCommand(Integer.toString(model.NormalSettings.IDENTIFIER));
			normal.addActionListener(diffSelAction);
			normal.setVisible(true);
			
			hard.setActionCommand(Integer.toString(model.HardSettings.IDENTIFIER));
			hard.addActionListener(diffSelAction);
			hard.setVisible(true);
			
			panel.setLayout(new GridLayout(3, 1, 5, 5));
			panel.add(easy);
			panel.add(normal);
			panel.add(hard);
			panel.setSize(150, 300);
			panel.setOpaque(false);
			
			panel.setLocation(300, 130);
		
		layeredPane.add(panel, 2);
		Background background = new Background("startScreen.png", new Dimension(700, 525));
		layeredPane.add(background, 3);
		
		((MainInterface)frame).setGlassPane(layeredPane);
		
		/* 
		 * Force the buttons to show.
		 */ 
		panel.updateUI();
		
		layeredPane.setVisible(true);
	}
}
