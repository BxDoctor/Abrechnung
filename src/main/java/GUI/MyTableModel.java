package GUI;

import javax.swing.table.DefaultTableModel;

import Datenstruktur.Bank;
import Datenstruktur.Bank.names;
import Datenstruktur.BankKat;
import Datenstruktur.Kategorie;

public class MyTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	public MyTableModel(){
		super(new Object[][] { },
				new String[] { "Bank" , "Kategorie", "Wert" } );
				
	}

	public void insertRow(MyTextfield inputField) {
		
		Bank.names bank = inputField.getCurrentBank();
		Kategorie.names kat = inputField.getCurrentKategorie();
		double val = inputField.getValue();
		
		super.insertRow(this.getRowCount(), new Object[]{
				bank,
				kat,
				val}
				);
		this.fireTableDataChanged();
		
		
	}


	
}
