package modele;

import java.util.Observable;
import modele.*;

public class Questions extends Observable{
	public int question = 0; 
	public String[] avance = {"Combien font 1+1","Bien ouèj","ntm","Okkkkkk oKKKKKK"};

	public boolean Demarre(String rep) {
		
		if(question == 0) {
			if(rep.equals("2")) {
				this.setChanged();
				this.notifyObservers();
				
				return true;
				
			}
			
		}
		if(question == 1) {
			if(rep.equals("Bonjour")) {
				this.setChanged();
				this.notifyObservers();
				
				return true;
				
			}
			
		}
		if(question == 2) {
			if(rep.equals("yo")) {
				
				return true;
				
			}
			
		}
		return false;
	}
	
	public String toString(){
		
		return avance[question] ;
		
	}
}
