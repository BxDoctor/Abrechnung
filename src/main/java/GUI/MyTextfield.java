package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JTextField;

import Datenstruktur.Bank;
import Datenstruktur.Kategorie;
import Datenstruktur.Kategorie.names;


public class MyTextfield extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Bank.names currentBank=null;
	private Kategorie.names currentKategorie=null;
	private double value;
	private final GUI gui;
	private String comment="";
	

	
	public MyTextfield(GUI inGui, int i) {
		super(i);
		gui = inGui;
		this.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
					doAction();
				}


			}
		});
		// TODO Auto-generated constructor stub
	}
	public void doAction(){
		String[] items = getText().split(" ");
		boolean done = false;
		for (String item : items){
			if (done){
				comment+= item + " ";
				continue;
			}
			try {
				setValue(Double.parseDouble(item));
				done = true;
			} catch (NumberFormatException e) {

				Bank.names tmp = Bank.names.getName(item);
				if (!(null == tmp)){
					setCurrentBank(tmp);
					continue;
				}
				Kategorie.names tmp2 = Kategorie.names.getName(item);
				if (!(null == tmp2)){
					setCurrentKategorie(tmp2);
					continue;
				}
			}
		}
		if (done){
			System.out.println(getCurrentBank().name()+ "; "+ getCurrentKategorie().name() + "; "+ getValue());
		}
		setText("");
		gui.intoTable();
	}

	public String toString(){
		String ret ="";
		ret+= this.getCurrentBank().name()+ "; "+ this.getCurrentKategorie().name() + "; "+this.getValue();
		return ret;
	}

	public Bank.names getCurrentBank() {
		return currentBank;
	}

	public void setCurrentBank(Bank.names currentBank) {
		this.currentBank = currentBank;
	}

	public Kategorie.names getCurrentKategorie() {
		return currentKategorie;
	}

	public void setCurrentKategorie(Kategorie.names currentKategorie) {
		this.currentKategorie = currentKategorie;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}



}
