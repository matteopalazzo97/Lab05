package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		//Model model = new Model();
		TestModel t = new TestModel();
		String s = "ciao";
		//System.out.println("a " + s.substring(0,0) + s.substring(1));
		
		System.out.println(t.ricorsione(s));

	}
	
	/*
	 * non capisco dove o come ma questo metodo modifica di volta in volta proprio la stringa parola
	 * ma non lo fa esplicitamente, cioè non capisco quale parte del codice va a toccare la stringa
	 */
	
	public List<String> ricorsione(String parola) {
		
		//strutture dati per inserire i risultati parziali e finali
		List<String> risultato = new LinkedList<String>();
		List<String> anagrammiRestanti = new LinkedList<String>();
		
		//soluzione caso banale
		if(parola.length() == 1) {
			//List<String> risultato = new LinkedList<String>();  inutile crearla ogni volta
			risultato.add(parola);
			return risultato;
		} else { //soluzione caso normale
			
				//List<String> risultato = new LinkedList<String>(); era inutile creare una lista a ogni iterazione
					
				for(int i = 0; i < parola.length(); i++) {
					
					char lettera = parola.charAt(i);
					String parziale = parola.substring(0, i) + parola.substring(i + 1);
					
					anagrammiRestanti = ricorsione(parziale);
					
					//questa merda ricostruisce le soluzioni intere, senza questa ci sono solo pezzi di soluzioni
					for(String sol : anagrammiRestanti) {
						risultato.add(lettera + sol);
						//System.out.println(lettera + sol);
					}
				
				}
		
			return risultato;
		
		}
		

	}
	
}
