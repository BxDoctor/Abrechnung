package Datenstruktur;

public class BankKat {

	double[][] map = new double[Bank.names.values().length][Kategorie.names.values().length];
	public BankKat(){
		reset();
	}
	
	private void reset() {
		int a = 0;
		int b = 0;
		int m = Bank.names.values().length;
		for (int i = 0; i < map.length; i++){
			b = b + 1 % m;
			if (b==0){
				a++;
			}
			map[a][b] = 0.0;
		}
		
	}

	public void put(Bank.names bank,Kategorie.names kat, double value){
		map[bank.ordinal()][kat.ordinal()] += value;
	}
	
	public double get(Bank.names bank,Kategorie.names kat){
		return map[bank.ordinal()][kat.ordinal()];
	}


	
}
