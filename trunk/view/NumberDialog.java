/**
 * 
 */
package view;

import java.awt.GridLayout;
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
	 * 
	 */
	private static final long serialVersionUID = -824283720921024119L;
	
	private int value;
	private JButton[] buttons;
	private model.Game game;
	
	public NumberDialog(model.Game game) {
		super();
		this.value = -1;
		
		this.game = game;
		model.GameSettings settings = this.game.getCurrentBoard().getSettings();
		
		int[] validValues = settings.getValidValues();
		int length = validValues.length;
		 
		buttons = new JButton[length];
		
		JPanel outerPanel = new JPanel(new GridLayout(2, 1, 2, 2));
		
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new GridLayout(settings.getQuadrantDimensions(),
										settings.getQuadrantDimensions(),
										2, 2));
		
		for (int i = 0; i < length; i++)
		{
			final int buttonVal = validValues[i];
			buttons[i] = new JButton(Integer.toString(buttonVal));
			
			buttons[i].setSize(ViewSettings.getButtonDimension());
			buttons[i].setPreferredSize(buttons[i].getSize());
			
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					value = buttonVal;
					close();
				}
			});
			innerPanel.add(buttons[i]);
		}
		
		JButton noVal = new JButton("Fjern tal");
		noVal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				value = 0;
				close();
			}
		});
		
		outerPanel.add(innerPanel);
		outerPanel.add(noVal);
		
		this.add(outerPanel);
		
		this.setModal(true);
		
		this.setSize(300, 300);
		this.setPreferredSize(this.getSize());
		
		PlaceCenter.placeCenter(this);
		
		this.setVisible(true);
	}
	
	private void close() {
		this.setVisible(false);
		this.dispose();
	}
	
	public int getValue() {
		return value;
	}

}