package modele;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.text.html.HTML;

public class Quizz extends Observable{
	public int question = 0; 
	public String[] avance = {"Combien font 1+1","Donnez le seul mot masculin finnissant par 'ette'","Quel est l'écriture exact de ce mot ?","Okkkkkk oKKKKKK"};
	
	public boolean Demarre(String rep) {
		
		if(question == 0) {
			if(rep.equals("2")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
			
		}
		if(question == 1) {
			if(rep.equals("squelette")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
			
		}
		if(question == 2) {
			if(rep.equals("elephant")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
		if(question == 3) {
			if(rep.equals("3")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
		}
			
		}
		return false;
	}
	
	public String toString(){
		return question+1 +") " + avance[question] ; 
		
	}
}
