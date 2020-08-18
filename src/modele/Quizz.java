package modele;

import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * La classe Quizz, le modèle du projet.
 * 
 * @author gael-
 */

public class Quizz extends Observable{
	
	/** The num question. */
	public int numQuestion = 0; 
	
	/** The questions. */
	public String[] questions = {
			
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
		
	/**
	 * Getter sur le int numQuestion.
	 *
	 * @return numQuestion
	 */
	public int getNumQuestion() {
		return numQuestion;
	}


	/**
	 * Setter sur le int question.
	 *
	 * @param numQuestion le numéro de la question
	 */
	public void setNumQuestion(int numQuestion) {
		this.numQuestion = numQuestion;
	}


	/**
	 * Getter sur le tableau de String questions.
	 *
	 * @return questions
	 */
	public String[] getQuestions() {
		return questions;
	}


	/**
	 * Setter sur le tableau de String questions
	 *
	 * @param questions le texte de la question
	 */
	public void setQuestions(String[] questions) {
		this.questions = questions;
	}


	/**
	 * Cette méthode reçoit un string représentant la réponse à la question posée du quizz. En fonction
	 * de la question à laquelle on se trouve(vérifié par des if) on vérifie que le string est similaire à 
	 * une partie de la réponse souhaitée.
	 *
	 * @param rep la reponse envoyé par l'utilisateur
	 * @return boolean
	 */
	public boolean Demarre(String rep) {
		rep = rep.toLowerCase();
		if(numQuestion == 0) {
			if(rep.contains("100")) {
				
				numQuestion +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
			
		}
		if(numQuestion == 1) {
			if(rep.contains("squelette")) {
				
				numQuestion +=1;
				this.setChanged();
				this.notifyObservers();
				return true; 
			}return false;
			
		}
		if(numQuestion == 2) {
			if(rep.contains("1")) {
				
				numQuestion +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		if(numQuestion == 3) {
			if(rep.contains("faux")) {
				
				numQuestion +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		
		if(numQuestion == 4) {
			if(rep.contains("queen")) {
				
				numQuestion +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		
		if(numQuestion == 5) {
			if(rep.contains("loup")) {
				
				numQuestion +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		
		if(numQuestion == 6) {
			if(rep.contains("3")) {
				numQuestion +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		if(numQuestion == 7) {
			if(rep.contains("3")) {
				
				numQuestion +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		if(numQuestion == 8) {
			if(rep.contains("bouton")) {
				
				numQuestion +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}
		if(numQuestion == 9) {
			if(rep.contains("79")) {
				
				numQuestion +=1;
				this.setChanged();
				this.notifyObservers();
				return true;
				
			}return false;
		}return false;
	}

	
	/**
	 * Mise en texte des questions.
	 *
	 * @return string numéro + question
	 */
	public String toString(){
		return numQuestion+1 +") " + questions[numQuestion] ; 
		
	}
}
