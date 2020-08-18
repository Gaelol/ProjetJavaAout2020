package modele;

import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * La classe Quizz, le mod�le du projet.
 * 
 * @author gael-
 */

public class Quizz extends Observable{
	
	/** The num question. */
	public int numQuestion = 0; 
	
	/** The questions. */
	public String[] questions = {
			
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
	 * @param numQuestion le num�ro de la question
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
	 * Cette m�thode re�oit un string repr�sentant la r�ponse � la question pos�e du quizz. En fonction
	 * de la question � laquelle on se trouve(v�rifi� par des if) on v�rifie que le string est similaire � 
	 * une partie de la r�ponse souhait�e.
	 *
	 * @param rep la reponse envoy� par l'utilisateur
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
	 * @return string num�ro + question
	 */
	public String toString(){
		return numQuestion+1 +") " + questions[numQuestion] ; 
		
	}
}
