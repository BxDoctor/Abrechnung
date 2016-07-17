/**
 * 
 */
package GUI;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author NeX0cc
 *
 */
public class RightPanel extends JPanel {

	private JButton confirmButton;

	public RightPanel(GUI gui) {
		this.setLayout(new BoxLayout( this, BoxLayout.Y_AXIS));
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		confirmButton = new AbrechnungButton(gui);
		this.add(confirmButton);
	}
}
