package view;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * @author Julian
 *
 */
public class NumberDialog extends JDialog {
	/**
	 * Classes that implement <code>Serializable</code> needs this.
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = -824283720921024119L;
	
	private int value;
	private JButton[] buttons;
	private model.Game game;
	
	/**
	 * Creates a numberdialog with using the settings of
	 * the supplied MainInterface and also using it as parent.
	 * @param main
	 */
	public NumberDialog(view.MainInterface main) {
		super();
		this.value = -1;
		
		this.game = main.getGame();
		model.GameSettings settings = this.game.getCurrentBoard().getSettings();
		
		/*
		 * Get the valid numbervalues from the settings.
		 */
		int[] validValues = settings.getValidValues();
		int length = validValues.length;
		 
		/*
		 * Create a JButton-array of the right length.
		 */
		buttons = new JButton[length];
		
		JPanel outerPanel = new JPanel(new GridLayout(2, 1, 2, 2));
		
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(settings.getQuadrantDimensions(),
										settings.getQuadrantDimensions(),
										2, 2));
		
		/*
		 * Create a button for each valid numbervalue.
		 */
		for (int index = 0; index < length; index++)
		{
			final int buttonVal = validValues[index];
			buttons[index] = new JButton(Integer.toString(buttonVal));
			
			buttons[index].setSize(ViewSettings.getButtonDimension());
			buttons[index].setPreferredSize(buttons[index].getSize());
			buttons[index].setDefaultCapable(false);
			
			buttons[index].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					value = buttonVal;
					close();
				}
			});
			upperPanel.add(buttons[index]);
		}
		
		JPanel lowerPanel = new JPanel(new GridLayout(1, 2, 2, 2));
		
		/*
		 * Create a button capable of removing the numbers from the board.
		 */
		JButton noVal = new JButton("Fjern tal");
		noVal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				value = 0;
				close();
			}
		});
		
		/*
		 * A cancel-button that closes the dialog.
		 */
		JButton cancel = new JButton("Luk");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		
		lowerPanel.add(noVal);
		lowerPanel.add(cancel);
		
		outerPanel.add(upperPanel);
		outerPanel.add(lowerPanel);
		
		this.add(outerPanel);
		
		this.setModal(true);
		
		this.setSize(200, 200);
		this.setPreferredSize(this.getSize());
		
		/*
		 * Places the numberdialog next to the gameboard.
		 * (On top of the IngameControls and the sheep)
		 */
		Point bgLoc = main.getBackgroundPanel().getLocationOnScreen();
		this.setLocation(bgLoc.x + 375, bgLoc.y + 100);
		
		/*
		 * Show the dialog
		 */
		this.setVisible(true);
	}
	
	/*
	 * Handles closing of the dialog.
	 */
	private void close() {
		this.setVisible(false);
		this.dispose();
	}
	
	/*
	 * Gets the value from the dialog.
	 */
	public int getValue() {
		return value;
	}

}
