package modele;

import java.util.Observable;

public class Quizz extends Observable{
	public int question = 0; 
	public String[] avance = {
			"Combien font 1+1",
			"Donnez le seul mot masculin finnissant par 'ette'",
			"salut",
			"Quel est l'écriture exact de ce mot ?",
			"Okkkkkk oKKKKKK",
			"4",
			"f",
			"ds",
			"ntm",
			"slt",
			"terrible"
			};
	
	public boolean Demarre(String rep) {
		
		if(question == 0) {
			if(rep.equals("0")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
			
		}
		if(question == 1) {
			if(rep.equals("0")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true; 
			}
			
		}
		if(question == 2) {
			if(rep.equals("0")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
		}
		if(question == 3) {
			if(rep.equals("0")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
		}
		if(question == 4) {
			if(rep.equals("0")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
		}
		
		if(question == 5) {
			if(rep.equals("0")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
		}
		
		if(question == 6) {
			if(rep.equals("0")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
		}
		if(question == 7) {
			if(rep.equals("0")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
		}
		if(question == 8) {
			if(rep.equals("0")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
		}
		if(question == 9) {
			if(rep.equals("0")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
		}
		if(question == 10) {
			if(rep.equals("0")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}
		}
		
		return false;
	}
	
	public String toString(){
		return question+1 +") " + avance[question] ; 
		
	}
}
