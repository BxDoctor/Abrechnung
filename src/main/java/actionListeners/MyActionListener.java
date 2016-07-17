package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Datenstruktur.MyEnvironment;

public class MyActionListener implements ActionListener, KeyListener {
	private MyEnvironment env;

	public MyActionListener(MyEnvironment env) {
		this.setEnv(env);
		
	}
	public MyEnvironment getEnv() {
		return env;
	}

	public void setEnv(MyEnvironment env) {
		this.env = env;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	} 
	
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
