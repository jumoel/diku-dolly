/**
 * 
 */
package controller;

import javax.swing.SwingUtilities;

/**
 * @author Julian
 *
 */
public class SudokuGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable()
		{
            public void run()
            {
            	new view.MainWindow();
            }
		});
	}
}
