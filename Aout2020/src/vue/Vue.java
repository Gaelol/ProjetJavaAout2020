package vue;

import java.util.Observer;

import controleur.Controleur;
import modele.Modele;

public abstract class Vue implements Observer{
	
	protected Modele modele;
	protected Controleur controleur;
	
	protected Vue(Modele modele,
			Controleur controleur) {
		this.modele = modele;
		this.controleur = controleur;
		modele.addObserver(this);
	}

	public abstract void affiche(String string) ;
}
