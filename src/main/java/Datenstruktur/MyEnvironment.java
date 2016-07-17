package Datenstruktur;

import javax.swing.JTable;

import GUI.GUI;

public class MyEnvironment {

	private GUI gui;
	private JTable table;

	public MyEnvironment(GUI gui) {
		this.setGui(gui);
		setTable(gui.getTable_1());
	}

	public GUI getGui() {
		return gui;
	}

	public void setGui(GUI gui) {
		this.gui = gui;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
