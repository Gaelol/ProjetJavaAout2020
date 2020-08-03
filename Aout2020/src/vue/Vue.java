package vue;

import java.util.Observer;

import controleur.Controleur;
import modele.Demarrage;

public abstract class Vue implements Observer{
	
	protected Demarrage modele;
	protected Controleur controleur;
	
	protected Vue(Demarrage modele,
			Controleur controleur) {
		this.modele = modele;
		this.controleur = controleur;
		modele.addObserver(this);
	}

	public abstract void affiche(String string) ;
}
