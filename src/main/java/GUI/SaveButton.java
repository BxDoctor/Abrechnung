package GUI;

import javax.swing.JButton;

import Datenstruktur.MyEnvironment;
import actionListeners.SaveAL;

public class SaveButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public SaveButton(MyEnvironment env) {
	super("Speichern");
	this.addActionListener(new SaveAL(env));
}

}
