package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<Word> dictionary;

	/**
	 * @param dictionary
	 */
	public AlienDictionary() {
		
		this.dictionary =  new ArrayList<Word>();
	}
	
	public void addWord(String alienWord, String translation) {
		Word word = new Word(alienWord, translation);
		if(this.dictionary.contains(word)) {
			this.dictionary.get(this.dictionary.indexOf(word)).setTranslation(translation);
			return;
		}
		this.dictionary.add(word);
	}
	
	public void resetDictionary() {
		this.dictionary.clear();
	}
	
	
	public String translateWord(String alienWord) {
		Word w = new Word( alienWord);
		if(this.dictionary.contains(w))
			return this.dictionary.get(this.dictionary.indexOf(w)).getTranslation();
		return null;
				
	}
	
	

}
