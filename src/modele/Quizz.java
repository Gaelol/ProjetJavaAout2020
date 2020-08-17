package modele;

import java.util.Observable;

public class Quizz extends Observable{
	public int question = 0; 
	public String[] avance = {
			
			"Complétez la suite : 0, 2, 5, 7, 8, 9, 11, ?",
			"Donnez le seul mot masculin finnissant par 'ette'",
			"Quel est l'écriture exact de ce mot ? 1)Yacht 2)Yaught 3)Yot 4)Yocht",
			"Vrai/Faux ? Il y a plus d'eau que de terre sur la planète?",
			"Quel est l'artiste de cette chanson?",
			"Complétez cette phrase : L'homme est un ... pour l'homme.",
			"Quelle est la corde de Ré?",
			"A quelle question parle-t-on d'un bateau?",
			"Où est Charlie?",
			"Quel est le nombre manquant ?",
			"Félicitations ! Merci d'avoir joué !"
			
			};
	
	public boolean Demarre(String rep) {
		rep = rep.toLowerCase();
		if(question == 0) {
			if(rep.contains("100")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
			
		}
		if(question == 1) {
			if(rep.contains("squelette")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true; 
			}return false;
			
		}
		if(question == 2) {
			if(rep.contains("1")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		if(question == 3) {
			if(rep.contains("faux")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		
		if(question == 4) {
			if(rep.contains("queen")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		
		if(question == 5) {
			if(rep.contains("loup")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		
		if(question == 6) {
			if(rep.contains("3")) {
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		if(question == 7) {
			if(rep.equals("question 3")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		if(question == 8) {
			if(rep.equals("bouton")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		if(question == 9) {
			if(rep.equals("79")) {
				
				question +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}return false;
	}

	
	public String toString(){
		return question+1 +") " + avance[question] ; 
		
	}
}
