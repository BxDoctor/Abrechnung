package Datenstruktur;

import Datenstruktur.Kategorie.names;

public class Bank {

	public static enum names{
		DKB("d"),
		Postbank("p"),
		Sparkasse("s");
		
		private String _id;
		private names(String id){
			_id = id;
		}
		public String getID(){
			return _id;
		}
		public static names getName(String id){
			for (names name : names.values()){
				if (name.getID().equals(id)){
					return name;
				}
			}
			return null;
		}
	}
	
	
	public static names B(Kategorie.names kat){
		if (Kategorie.names.Manu == kat){
			return names.Sparkasse;
		}
		if (Kategorie.names.Karo == kat){
			return names.Postbank;
		}
		return names.DKB;	}


	public static Datenstruktur.Bank.names Binv(Kategorie.names kat) {
		if (Kategorie.names.Karo == kat){
			return names.Sparkasse;
		}
		if (Kategorie.names.Manu == kat){
			return names.Postbank;
		}
		return names.DKB;
	}
	
	
}
