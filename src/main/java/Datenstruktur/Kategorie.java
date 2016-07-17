package Datenstruktur;

import Datenstruktur.Bank.names;

public class Kategorie {

	public enum names{
		Manu("m"),
		Karo("k"),
		Raffi("r"),
		Manu_Karo("mk"),
		Familie("f");
		
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
	
	public Kategorie(){
		
		
	}

	
}
