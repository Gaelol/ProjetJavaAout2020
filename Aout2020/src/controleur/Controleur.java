package controleur;

import modele.Quizz;
import vue.Vue;

public class Controleur {
	Quizz modele; 
	Vue vue;
	
	public Controleur( Quizz modele) {
		this.modele = modele;
	}
 
	public void next(String rep) {
		
		if(modele.Demarre(rep)) {
		
		}
		
	}	
	
	public void addView(Vue vue) {
		
		this.vue = vue;
	
	}

}