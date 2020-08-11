package vue;

import java.util.Observer;

import controleur.Controleur;
import modele.Quizz;

public abstract class Vue implements Observer{
	
	protected Quizz modele;
	protected Controleur controleur;
	
	protected Vue(Quizz modele,
			Controleur controleur) {
		this.modele = modele;
		this.controleur = controleur;
		modele.addObserver(this);
	}

	public abstract void affiche(String string) ;
	
}
