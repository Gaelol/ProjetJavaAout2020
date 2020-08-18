package vue;

import java.util.Observer;

import controleur.Controleur;
import modele.Quizz;

/**
 * La classe Vue, la vue du Projet.
 * 
 * @author gael-
 */

public abstract class Vue implements Observer{
	
	protected Quizz modele;
	protected Controleur controleur;
	
	/**
	 * Instancie une nouvelle vue en prenant comme paramètre le modèle et le controleur.
	 *
	 * @param modele 
	 * @param controleur
	 */	
	protected Vue(Quizz modele,
			Controleur controleur) {
		this.modele = modele;
		this.controleur = controleur;
		modele.addObserver(this);
	}

	public abstract void affiche(String string) ;
	
}
