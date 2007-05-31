/**
 * 
 */
package view;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * @author Julian
 *
 */
public abstract class DifficultySelection extends JOptionPane {
	public static int show(Component frame) {
		Object[] options = {"I'm too young to die",
	            					"Lol im avaarage",
	            					"SUPER DUPER GODLIKE LOLKEK-MODE!!!111ELEVEN"};
		
		int n = JOptionPane.showOptionDialog(frame,
				"Vælg en sværhedsgrad, din goddamn newbie!",
				"^_^",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[2]);
		
		return n;
	}
}
