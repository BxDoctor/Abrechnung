/**
 * 
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;

import Datenstruktur.Bank;
import Datenstruktur.BankKat;
import Datenstruktur.Kategorie;
import Datenstruktur.Kategorie.names;

/**
 * @author NeX0cc
 *
 */
@SuppressWarnings("serial")
public class AbrechnungButton extends JButton {

	

	public AbrechnungButton(final GUI gui){
		super("ABRECHNUNG");
		
		this.addActionListener(new ActionListener(){

			private BankKat myBankKat;
			private HashMap<names, Double> D;

			public void actionPerformed(ActionEvent arg0) {
				readToBankKat();
				calculateOutput();

			}

			private HashMap<names, Double> calculateOutput() {
				Kategorie.names[] X = new Kategorie.names[2];
				X[0] = Kategorie.names.Manu;
				X[1] = Kategorie.names.Karo;
				
				Kategorie.names[] Y = new Kategorie.names[2];
				Y[1] = Kategorie.names.Familie;
				Y[0] = Kategorie.names.Manu_Karo;

				D = new HashMap<Kategorie.names,Double>();
				int k = 0;
				for (Kategorie.names x : X){

					//fam/mk -> manu/karo
					D.put(x, gui.getIncome()/2);
					int i = 0;
					for (Kategorie.names y : Y){
						add(D, x, tupleB(x, y, ++i));
					}

					
						//manu <-> karo 
						add(D, x, -bankKat(Bank.Binv(x), X[k]) + bankKat(Bank.B(x), X[1 - k]) );
						k += 1;

						//Raffi/dkb <-> manu/karo
						Kategorie.names y=Kategorie.names.Raffi;
						add(D, x, bankKat( Bank.B(x), y) - bankKat(Bank.Binv(y),x) );
					
						names r = Kategorie.names.Raffi; 
						int i1 = 2;
						for (Kategorie.names y1 : Y){
							add(D, x, -bankKat(Bank.B(r), y1)/i1);
							i1+=1;
							
						}
				}
				
				System.out.println(D.get(Kategorie.names.Manu).toString());
				System.out.println(D.get(Kategorie.names.Karo).toString());
				return D;
			}

			private double tupleB(names x, names y, int i) {
				Double valX = bankKat(Bank.B(x), y);
				Double valY = bankKat(Bank.Binv(x),y);
				Double val = valX*i/(i+1) - valY/(i+1);
				return val;
			}

			private void add(HashMap<names, Double> D, names x, double income) {
				Double d = D.get(x);
				d += income;
				D.put(x, d);

			}
			private void toBankKat(Bank.names bank, Datenstruktur.Kategorie.names kat, double val) {
				getMyBankKat().put(bank, kat, val);
			}

			public BankKat getMyBankKat() {
				return myBankKat;
			}
			public Double bankKat(Bank.names bank, Kategorie.names kat){
				Double ret = getMyBankKat().get(bank, kat);
				return ret;
			}

			public void setMyBankKat(BankKat myBankKat) {
				this.myBankKat = myBankKat;
			}

			protected void readToBankKat() {
				setMyBankKat(new BankKat());
				Enumeration rows = gui.getMyModel().getDataVector().elements();
				while (rows.hasMoreElements()){
					Object rowObj = rows.nextElement();
					Vector rowVc = (Vector) rowObj;
					//Object[] row = (Object[]) rowVc.firstElement();
					Bank.names bank = (Bank.names) rowVc.elementAt(0);
					Kategorie.names kat = (Kategorie.names)rowVc.elementAt(1);
					Double val = Double.parseDouble(rowVc.elementAt(2).toString());
					toBankKat(bank, kat, val);
				}
				saveBankKat();

			}

			private void saveBankKat() {


			}
		});
	}


}
