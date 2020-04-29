package it.polito.tdp.alien;

import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary alienDictionary = new AlienDictionary();

    @FXML
    private TextArea txtResult;

    @FXML
    private TextField txtInserisci;

    @FXML
    private Button btnTranslate;

    @FXML
    private Button btnReset;



    @FXML
    void doTranslate(ActionEvent event) {
    	txtResult.clear();
    	String riga = txtInserisci.getText().toLowerCase();
    	
    	// controllo input
    	
    	if(riga == null || riga.length()==0) {
    		txtResult.setText("Inserire una o due parole!");
    		return;
    	}
    	
    	StringTokenizer st = new StringTokenizer(riga, " ");
    	
    	// estraggo la prima parola
    	
    	String alienWord = st.nextToken();
        
    	if(st.hasMoreElements()) {
    		// devo inserire sia parola che traduzione nel dizionario
    		
    		// Estraggo la seconda parola 
    		String translation = st.nextToken();
    		
    		if(!alienWord.matches("[a-zA-Z]*")  || !translation.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici!");
    			return;
    		}
    		
    		// le parole sono entrambe valide, le posso aggiungere
    		this.alienDictionary.addWord(alienWord, translation);
    		
    		txtResult.setText("La parola: "+alienWord+" è stata inserita nel vocabolario, con traduzione : "+translation);
    	
    	} else {    // se invece viene inserita soltanto la parola da tradurre
    		
    		// anche qui controllo l input 
    		if (!alienWord.matches("[a-zA-Z]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}
    		String translation = this.alienDictionary.translateWord(alienWord);
    		
    		if(translation != null) {
    			txtResult.setText(translation);
    		} else {
    			txtResult.setText("La parola cercata non esiste nel dizionario");
    		}
    		
    	}  
    	
    		
    	}
    
    
    @FXML
	void doReset() {
    	this.txtInserisci.clear();
    	this.txtResult.clear();
    	this.alienDictionary.resetDictionary();
    	
    }

	@FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
