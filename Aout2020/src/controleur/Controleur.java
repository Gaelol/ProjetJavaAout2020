package controleur;

import modele.Demarrage;
import vue.Vue;

public class Controleur {
	Demarrage modele; 
	Vue vue;
	public Controleur( Demarrage modele) {
		this.modele = modele;
	}
 
	public void next(String rep) {
		if(modele.Demarre(rep)) {
			
			modele.question +=1;
			vue.affiche(modele.avance[modele.question]);
			
		}
	}
	
	public void addView(Vue vue) {
		this.vue = vue;
	}

}