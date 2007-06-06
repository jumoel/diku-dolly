/**
 * 
 */
package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Julian
 *
 */
public class Statistics extends JPanel {
	/**
	 * Classes that implement <code>Serializable</code> needs this.
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 2010781905015455017L;
	
	private model.Statistics statistics;
	
	private JLabel difficultyLabel, difficultyValue,
		mistakesLabel, mistakesValue, 
		helpLabel, helpValue, 
		timeLabel, timeValue;
	private Font font;

	/**
	 * Creates the statisticspanel based on the supplied game.
	 * @param game The game to base the statistics on.
	 */
	public Statistics(model.Game game) {
		this.statistics = game.getStatistics();
		
		/*
		 * Use a standard system font.
		 */
		font = new Font("sansserif", Font.BOLD, 16);
		
		/*
		 * Set the size and make sure the panel isn't opaque.
		 */
		this.setSize(275, 120);
		this.setOpaque(false);
		
		/*
		 * Shows the difficulty
		 */
		difficultyLabel = new JLabel("Sværhedsgrad:");
			difficultyLabel.setSize(250, 30);
			difficultyLabel.setFont(font);
		difficultyValue = new JLabel(game.getCurrentBoard().getSettings().getDifficulty());
			difficultyValue.setSize(25, 30);
			difficultyValue.setFont(font);
			
		/*
		 * Shows the number of mistakes made.
		 */
		mistakesLabel = new JLabel("Antal fejl:");
			mistakesLabel.setSize(250, 30);
			mistakesLabel.setFont(font);
		mistakesValue = new JLabel(Integer.toString(statistics.getMistakes()));
			mistakesValue.setSize(25, 30);
			mistakesValue.setFont(font);
		
		/*
		 * Shows the number of helps used.
		 */
		helpLabel = new JLabel("Antal 'Hjælp' brugt:");
			helpLabel.setSize(250, 30);
			helpLabel.setFont(font);
		helpValue = new JLabel(Integer.toString(statistics.getHints()));
			helpValue.setSize(25, 30);
			helpValue.setFont(font);
			
		/*
		 * Shows the timeusage.
		 */
		timeLabel = new JLabel("Tid brugt:");
			timeLabel.setSize(250, 30);
			timeLabel.setFont(font);
		timeValue = new JLabel(this.statistics.getElapsedTime());
			timeValue.setSize(25, 30);
			timeValue.setFont(font);
		
		/*
		 * Set the layout of the panel and add
		 * all the labels.
		 */
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.ipadx = 20;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(difficultyLabel, gbc);
		gbc.gridx = 1;
		this.add(difficultyValue, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(mistakesLabel, gbc);
		gbc.gridx = 1;
		this.add(mistakesValue, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(helpLabel, gbc);
		gbc.gridx = 1;
		this.add(helpValue, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(timeLabel, gbc);
		gbc.gridx = 1;
		this.add(timeValue, gbc);
	}

}
