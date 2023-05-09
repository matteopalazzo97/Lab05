/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCalcolaAnagrammi"
    private Button btnCalcolaAnagrammi; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrati"
    private TextArea txtErrati; // Value injected by FXMLLoader

    @FXML // fx:id="txtInput"
    private TextField txtInput; // Value injected by FXMLLoader

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	/*
    	 * ho fatto il metodo del dao, collegato model e controller, collegato il db
    	 * ora devo fare il juice dell'esercizio
    	 */
    	
    	/*
    	 * lui in più rispetto a me ha fatto sicuramente un qualche controllo sulle doppie in una parola
    	 * ma io non voglio manco pensarci
    	 */
    
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	
    	
    	String parola = this.txtInput.getText();
    	
    	if(parola == null) {
    		this.txtCorretti.setText("Inserisci una parola da anagrammare.");
    		return;
    	}
    	
    	List<String> anagrammi = new ArrayList<String>();
    	anagrammi = this.model.doAnagrammi(parola);
    	
    	for(String s : anagrammi) {
    		if(this.model.isCorretta(s)) {
    			this.txtCorretti.appendText(s + "\n");
    		} else {
    			this.txtErrati.appendText(s + "\n");
    		}
    		
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	this.txtInput.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
		
	}

}
