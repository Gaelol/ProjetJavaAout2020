package modele;

import java.util.Observable;

public class Quizz extends Observable{
	public int question = 0; 
	public String[] avance = {
			
			"Compl�tez la suite : 0, 2, 5, 7, 8, 9, 11, ?",
			"Donnez le seul mot masculin finnissant par 'ette'",
			"Quel est l'�criture exact de ce mot ? 1)Yacht 2)Yaught 3)Yot 4)Yocht",
			"Vrai/Faux ? Il y a plus d'eau que de terre sur la plan�te?",
			"Quel est l'artiste de cette chanson?",
			"Compl�tez cette phrase : L'homme est un ... pour l'homme.",
			"Quelle est la corde de R�?",
			"A quelle question parle-t-on d'un bateau?",
			"O� est Charlie?",
			"Quel est le nombre manquant ?",
			"F�licitations ! Merci d'avoir jou� !"
			
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
