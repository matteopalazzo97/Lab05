package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO anagrammaDAO;
	
	public Model() {
		super();
		this.anagrammaDAO = new AnagrammaDAO();
	}

	//questo dovrebbe essere il metodo che fa la ricorsione
	public ArrayList<String> doAnagrammi(String parola) {
		
		ArrayList<String> anagrammi = new ArrayList<String>();
		ArrayList<String> anagrammiParziali = new ArrayList<String>();
		
		//condizione di terminazione o caso banale
		if(parola.length() == 1) {
			
			anagrammi.add(parola);
			return anagrammi;
			
		} else { //caso normale
			
			for(int pos = 0; pos < parola.length(); pos++) {
				
				char lettera = parola.charAt(pos);
				String parziale = parola.substring(0, pos) + parola.substring(pos+1);
				
				anagrammiParziali = doAnagrammi(parziale);
				
				for(String sol : anagrammiParziali) {
					anagrammi.add(lettera + sol);
				}
			}
			return anagrammi;
		}	
		
	}
	
	public boolean isCorretta(String parola) {
		return this.anagrammaDAO.isCorrect(parola);
	}
	
	

}
