package controleur;

import modele.Quizz;
import vue.Vue;

/**
 * La classe Controleur,le Controleur du projet.
 *
 * @author gael-
 */
public class Controleur {
	
	Quizz modele; 
	
	Vue vue;
	
	/**
	 * Instancie un nouveau controleur.
	 *
	 * @param modele the modele
	 */
	public Controleur( Quizz modele) {
		this.modele = modele;
	}
 
	/**
	 * Next.
	 *
	 * @param rep the rep
	 */
	public void next(String rep) {
		if(modele.Demarre(rep)) {
			
		}
	}	
	
	/**
	 * Adds the view.
	 *
	 * @param vue the vue
	 */
	public void addView(Vue vue) {
		
		this.vue = vue;
	
	}

}