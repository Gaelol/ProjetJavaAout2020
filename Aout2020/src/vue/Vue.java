package vue;

import java.util.Observer;

import controleur.Controleur;
import modele.Questions;

public abstract class Vue implements Observer{
	
	protected Questions modele;
	protected Controleur controleur;
	
	protected Vue(Questions modele,
			Controleur controleur) {
		this.modele = modele;
		this.controleur = controleur;
		modele.addObserver(this);
	}

	public abstract void affiche(String string) ;
}
