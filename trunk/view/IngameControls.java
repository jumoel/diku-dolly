/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

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

	public IngameControls(String title, final Component frame,
			DifficultyAction difficultyAction, HelpAction helpAction) {
		TitledBorder titledBorder = BorderFactory.createTitledBorder(title);
		
		this.setBorder(titledBorder);
		JButton newButton = new JButton("Ny Sudokulol");
		newButton.addActionListener(difficultyAction);
		this.add(newButton);
		
		JButton helpButton = new JButton("HJÆÆÆÆLP!");
		helpButton.addActionListener(helpAction);
		this.add(helpButton);
		this.setBackground(Color.MAGENTA);
	}
}
